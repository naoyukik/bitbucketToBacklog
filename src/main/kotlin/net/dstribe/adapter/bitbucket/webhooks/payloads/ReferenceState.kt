package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.*

@Serializable
data class ReferenceState(
    @SerialName("default_merge_strategy") val defaultMergeStrategy: String = "",
    val name: String = "",
    @SerialName("merge_strategies") val mergeStrategies: List<String>?,
    val links: Links = Links(),
    val type: String = "",
    val target: CommitsItem
)