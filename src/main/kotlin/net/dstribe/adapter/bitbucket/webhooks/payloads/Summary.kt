package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class Summary(
    val markup: String = "",
    val raw: String = "",
    val html: String = "",
    val type: String = ""
)