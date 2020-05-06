package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class CommitsItem(
    val summary: Summary,
    val date: String = "",
    val rendered: Rendered?,
    val author: Author,
    val links: Links = Links(),
    val message: String = "",
    val type: String = "",
    val hash: String = "",
    val properties: Properties = Properties(),
    val parents: List<ParentsItem>?
)