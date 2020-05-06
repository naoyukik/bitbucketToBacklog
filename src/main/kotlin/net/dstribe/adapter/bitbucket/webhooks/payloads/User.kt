package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.*

@Serializable
data class User(
    @SerialName("account_id") val accountId: String = "",
    val nickname: String = "",
    val links: Links = Links(),
    @SerialName("display_name") val displayName: String = "",
    val type: String = "",
    val uuid: String = ""
)
