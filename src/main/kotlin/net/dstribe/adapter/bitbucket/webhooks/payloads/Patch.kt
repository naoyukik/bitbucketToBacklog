package net.dstribe.adapter.bitbucket.webhooks.payloads

import kotlinx.serialization.Serializable

@Serializable
data class Patch(val href: String = "")