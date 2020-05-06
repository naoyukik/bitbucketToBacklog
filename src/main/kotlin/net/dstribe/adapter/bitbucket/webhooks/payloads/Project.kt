package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val name: String = "",
    val links: Links,
    val type: String = "",
    val uuid: String = "",
    val key: String = ""
)