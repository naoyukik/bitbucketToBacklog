package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val self: Self = Self(),
    val commits: Commits = Commits(),
    val html: Html = Html(),
    val diff: Diff = Diff(),
    val avatar: Avatar = Avatar(),
    val approve: Approve = Approve(),
    val statuses: Statuses = Statuses(),
    val patch: Patch = Patch()
)
