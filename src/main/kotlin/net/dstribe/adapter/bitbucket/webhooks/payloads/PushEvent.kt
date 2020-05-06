package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class PushEvent(
    val actor: User,
    val repository: Repository,
    val push: Push
)
