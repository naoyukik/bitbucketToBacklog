package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class ChangesItem(
    val new: ReferenceState?,
    val forced: Boolean = false,
    val old: ReferenceState?,
    val created: Boolean = false,
    val commits: List<CommitsItem>,
    val truncated: Boolean = false,
    val closed: Boolean = false,
    val links: Links = Links()
)