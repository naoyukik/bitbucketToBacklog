package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val raw: String = "",
    val type: String = "",
    val user: User = User()
)