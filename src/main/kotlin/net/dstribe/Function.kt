package net.dstribe

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import kotlinx.serialization.json.*
import net.dstribe.adapter.backlog.api.Registration
import net.dstribe.adapter.bitbucket.webhooks.payloads.PushEvent
import java.util.*


/**
 * Azure Functions with HTTP Trigger.
 */
class Function {

    @FunctionName("sendBacklogComment")
    fun sendBacklogComment(
        @HttpTrigger(
            name = "req",
            methods = [HttpMethod.POST]
        ) request: HttpRequestMessage<Optional<String>>,
        context: ExecutionContext): HttpResponseMessage.Builder? {

        val query = null
        val reqBody = request.body.orElse(query)

        val obj = jsonParseFromString(reqBody)

        // 投稿するもの:　ブランチ名, hash, author name, url, コメント
        // ブランチ名: push.changes[0].new.name
        // hash: push.changes[0].new.target.hash
        // author name: push.changes[0].new.target.auhor.user.display_name
        // url: push.changes[0].new.target.links.html.href
        // コメント: push.changes[0].new.target.message

        val commitItem = obj.push.changes[0].new
        var result: Long = 0
        if (commitItem != null) {
            val branchName: String = commitItem.name
            val hash: String = commitItem.target.hash
            val author: String = commitItem.target.author.raw
            val url: String = commitItem.target.links.html.href
            val date: String = commitItem.target.date
            val message: String = commitItem.target.message

            val comment = formatComment(hash, author, date, url, message)
            val backlogSpaceId: String = System.getenv("BacklogSpaceId")
            val backlogUserApiKey: String = System.getenv("BacklogUserApiKey")
            val backlog = Registration(backlogSpaceId, backlogUserApiKey)
            result = backlog.addIssueComment(branchName, comment)
        }
        return request.createResponseBuilder(HttpStatus.OK)
    }

    public fun jsonParseFromString(reqBody: String): PushEvent {
        val json = Json(JsonConfiguration.Stable.copy(
            ignoreUnknownKeys = true
        ))
        return json.parse(PushEvent.serializer(), reqBody)
    }

    private fun formatComment(hash: String, author: String, date: String, url: String, comment: String): String {
        val commentFormant = "commit: %s\n" +
            "Author: %s\n" +
            "Date:   %s\n" +
            "\n" +
            "%s\n" +
            "\n" +
            "ref: %s"
        return String.format(commentFormant, hash, author, date, comment, url)
    }
}
