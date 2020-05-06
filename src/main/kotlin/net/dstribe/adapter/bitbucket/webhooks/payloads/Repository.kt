package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.*

@Serializable
data class Repository(
    val owner: User,
    @SerialName("is_private") val isPrivate: Boolean = false,
    val website: String?,
    @SerialName("full_name") val fullName: String = "",
    val name: String = "",
    val project: Project,
    val links: Links,
    val scm: String = "",
    val type: String = "",
    val uuid: String = ""
)