package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class TestPushPayloads(
    val actor: String = "",
    val repository: String
)