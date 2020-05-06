package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable
import net.dstribe.adapter.bitbucket.webhooks.payloads.Links

@Serializable
data class ParentsItem(
    val links: Links = Links(),
    val type: String = "",
    val hash: String = ""
)