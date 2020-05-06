package net.dstribe.adapter.backlog.api

import com.nulabinc.backlog4j.*
import com.nulabinc.backlog4j.api.option.AddIssueCommentParams
import com.nulabinc.backlog4j.conf.*


class Registration(id: String, key: String) {

    private var backlog: BacklogClient? = null

    init {
        backlog = createClient(id, key)
    }

    private fun configure(id: String, key: String): BacklogConfigure {
        return BacklogComConfigure(id).apiKey(key)
    }

    private fun createClient(id: String, key: String): BacklogClient? {
        val conf = configure(id, key)
        return BacklogClientFactory(conf).newClient()
    }

    public fun addIssueComment(issueKey: String, comment: String): Long {
        val issue = backlog?.getIssue(issueKey)
        if (issue != null) {
            val sendParam = AddIssueCommentParams(issue.issueKey, comment)
            val result = backlog?.addIssueComment(sendParam)
            if (result != null) {
                return result.id
            }
        }
        return 0
    }
}