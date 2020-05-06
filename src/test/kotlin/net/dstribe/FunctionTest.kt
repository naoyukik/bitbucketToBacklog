package net.dstribe

import com.microsoft.azure.functions.*
import net.dstribe.adapter.backlog.api.Registration
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*
import java.util.logging.Logger
import javax.security.auth.login.Configuration
import kotlin.collections.HashMap

/**
 * Unit test for Function class.
 */
class FunctionTest {

    private fun testJsonParseFromString(json: String) {
        // Invoke
        val ret = Function().jsonParseFromString(json)
        assertNotNull(ret)
    }

    @Test
    @Throws(Exception::class)
    fun testJsonParse() {
        val string = "{\n" +
                "  \"push\": {\n" +
                "    \"changes\": [\n" +
                "      {\n" +
                "        \"forced\": false,\n" +
                "        \"old\": {\n" +
                "          \"name\": \"master\",\n" +
                "          \"links\": {\n" +
                "            \"commits\": {\n" +
                "              \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commits/master\"\n" +
                "            },\n" +
                "            \"self\": {\n" +
                "              \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/refs/branches/master\"\n" +
                "            },\n" +
                "            \"html\": {\n" +
                "              \"href\": \"https://bitbucket.org/naoyukik/webhooktest/branch/master\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"default_merge_strategy\": \"merge_commit\",\n" +
                "          \"merge_strategies\": [\n" +
                "            \"merge_commit\",\n" +
                "            \"squash\",\n" +
                "            \"fast_forward\"\n" +
                "          ],\n" +
                "          \"type\": \"branch\",\n" +
                "          \"target\": {\n" +
                "            \"rendered\": {},\n" +
                "            \"hash\": \"01f88723088ddecea5e051e30e8df86c5aee743e\",\n" +
                "            \"links\": {\n" +
                "              \"self\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "              },\n" +
                "              \"html\": {\n" +
                "                \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"author\": {\n" +
                "              \"raw\": \"naoyuki kodama <members@dstribe.net>\",\n" +
                "              \"type\": \"author\",\n" +
                "              \"user\": {\n" +
                "                \"display_name\": \"naoyuki kodama\",\n" +
                "                \"uuid\": \"{e12843b8-66c8-4bfd-a5b9-fa329107aeeb}\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/users/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D/\"\n" +
                "                  },\n" +
                "                  \"avatar\": {\n" +
                "                    \"href\": \"https://secure.gravatar.com/avatar/130b39e256ce986657cdbd56b2b1782d?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FNK-1.png\"\n" +
                "                  }\n" +
                "                },\n" +
                "                \"nickname\": \"naoyukik\",\n" +
                "                \"type\": \"user\",\n" +
                "                \"account_id\": \"557058:db9fa8da-6d20-45a2-8b75-9663f3929557\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"summary\": {\n" +
                "              \"raw\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "              \"markup\": \"markdown\",\n" +
                "              \"html\": \"<p>README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002</p>\",\n" +
                "              \"type\": \"rendered\"\n" +
                "            },\n" +
                "            \"parents\": [\n" +
                "              {\n" +
                "                \"hash\": \"6a4d231703dcaeddeacf505139647ec8a808d66d\",\n" +
                "                \"type\": \"commit\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/6a4d231703dcaeddeacf505139647ec8a808d66d\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/6a4d231703dcaeddeacf505139647ec8a808d66d\"\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ],\n" +
                "            \"date\": \"2020-04-30T08:35:45+00:00\",\n" +
                "            \"message\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "            \"type\": \"commit\",\n" +
                "            \"properties\": {}\n" +
                "          }\n" +
                "        },\n" +
                "        \"links\": {\n" +
                "          \"commits\": {\n" +
                "            \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commits?include=39f444c78cfbd8790ff806659d072a524dfd4bfd&exclude=01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "          },\n" +
                "          \"html\": {\n" +
                "            \"href\": \"https://bitbucket.org/naoyukik/webhooktest/branches/compare/39f444c78cfbd8790ff806659d072a524dfd4bfd..01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "          },\n" +
                "          \"diff\": {\n" +
                "            \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/diff/39f444c78cfbd8790ff806659d072a524dfd4bfd..01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"created\": false,\n" +
                "        \"commits\": [\n" +
                "          {\n" +
                "            \"rendered\": {},\n" +
                "            \"hash\": \"39f444c78cfbd8790ff806659d072a524dfd4bfd\",\n" +
                "            \"links\": {\n" +
                "              \"self\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              },\n" +
                "              \"comments\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/39f444c78cfbd8790ff806659d072a524dfd4bfd/comments\"\n" +
                "              },\n" +
                "              \"patch\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/patch/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              },\n" +
                "              \"html\": {\n" +
                "                \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              },\n" +
                "              \"diff\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/diff/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              },\n" +
                "              \"approve\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/39f444c78cfbd8790ff806659d072a524dfd4bfd/approve\"\n" +
                "              },\n" +
                "              \"statuses\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/39f444c78cfbd8790ff806659d072a524dfd4bfd/statuses\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"author\": {\n" +
                "              \"raw\": \"naoyuki kodama <members@dstribe.net>\",\n" +
                "              \"type\": \"author\",\n" +
                "              \"user\": {\n" +
                "                \"display_name\": \"naoyuki kodama\",\n" +
                "                \"uuid\": \"{e12843b8-66c8-4bfd-a5b9-fa329107aeeb}\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/users/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D/\"\n" +
                "                  },\n" +
                "                  \"avatar\": {\n" +
                "                    \"href\": \"https://secure.gravatar.com/avatar/130b39e256ce986657cdbd56b2b1782d?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FNK-1.png\"\n" +
                "                  }\n" +
                "                },\n" +
                "                \"nickname\": \"naoyukik\",\n" +
                "                \"type\": \"user\",\n" +
                "                \"account_id\": \"557058:db9fa8da-6d20-45a2-8b75-9663f3929557\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"summary\": {\n" +
                "              \"raw\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "              \"markup\": \"markdown\",\n" +
                "              \"html\": \"<p>README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002</p>\",\n" +
                "              \"type\": \"rendered\"\n" +
                "            },\n" +
                "            \"parents\": [\n" +
                "              {\n" +
                "                \"hash\": \"01f88723088ddecea5e051e30e8df86c5aee743e\",\n" +
                "                \"type\": \"commit\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ],\n" +
                "            \"date\": \"2020-04-30T13:36:30+00:00\",\n" +
                "            \"message\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "            \"type\": \"commit\",\n" +
                "            \"properties\": {}\n" +
                "          }\n" +
                "        ],\n" +
                "        \"truncated\": false,\n" +
                "        \"closed\": false,\n" +
                "        \"new\": {\n" +
                "          \"name\": \"master\",\n" +
                "          \"links\": {\n" +
                "            \"commits\": {\n" +
                "              \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commits/master\"\n" +
                "            },\n" +
                "            \"self\": {\n" +
                "              \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/refs/branches/master\"\n" +
                "            },\n" +
                "            \"html\": {\n" +
                "              \"href\": \"https://bitbucket.org/naoyukik/webhooktest/branch/master\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"default_merge_strategy\": \"merge_commit\",\n" +
                "          \"merge_strategies\": [\n" +
                "            \"merge_commit\",\n" +
                "            \"squash\",\n" +
                "            \"fast_forward\"\n" +
                "          ],\n" +
                "          \"type\": \"branch\",\n" +
                "          \"target\": {\n" +
                "            \"rendered\": {},\n" +
                "            \"hash\": \"39f444c78cfbd8790ff806659d072a524dfd4bfd\",\n" +
                "            \"links\": {\n" +
                "              \"self\": {\n" +
                "                \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              },\n" +
                "              \"html\": {\n" +
                "                \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/39f444c78cfbd8790ff806659d072a524dfd4bfd\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"author\": {\n" +
                "              \"raw\": \"naoyuki kodama <members@dstribe.net>\",\n" +
                "              \"type\": \"author\",\n" +
                "              \"user\": {\n" +
                "                \"display_name\": \"naoyuki kodama\",\n" +
                "                \"uuid\": \"{e12843b8-66c8-4bfd-a5b9-fa329107aeeb}\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/users/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D/\"\n" +
                "                  },\n" +
                "                  \"avatar\": {\n" +
                "                    \"href\": \"https://secure.gravatar.com/avatar/130b39e256ce986657cdbd56b2b1782d?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FNK-1.png\"\n" +
                "                  }\n" +
                "                },\n" +
                "                \"nickname\": \"naoyukik\",\n" +
                "                \"type\": \"user\",\n" +
                "                \"account_id\": \"557058:db9fa8da-6d20-45a2-8b75-9663f3929557\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"summary\": {\n" +
                "              \"raw\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "              \"markup\": \"markdown\",\n" +
                "              \"html\": \"<p>README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002</p>\",\n" +
                "              \"type\": \"rendered\"\n" +
                "            },\n" +
                "            \"parents\": [\n" +
                "              {\n" +
                "                \"hash\": \"01f88723088ddecea5e051e30e8df86c5aee743e\",\n" +
                "                \"type\": \"commit\",\n" +
                "                \"links\": {\n" +
                "                  \"self\": {\n" +
                "                    \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest/commit/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "                  },\n" +
                "                  \"html\": {\n" +
                "                    \"href\": \"https://bitbucket.org/naoyukik/webhooktest/commits/01f88723088ddecea5e051e30e8df86c5aee743e\"\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ],\n" +
                "            \"date\": \"2020-04-30T13:36:30+00:00\",\n" +
                "            \"message\": \"README.md \\u3092 Bitbucket \\u4e0a\\u3067\\u30aa\\u30f3\\u30e9\\u30a4\\u30f3\\u3067\\u7de8\\u96c6\\u3057\\u307e\\u3057\\u305f\\u3002\",\n" +
                "            \"type\": \"commit\",\n" +
                "            \"properties\": {}\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"actor\": {\n" +
                "    \"display_name\": \"naoyuki kodama\",\n" +
                "    \"uuid\": \"{e12843b8-66c8-4bfd-a5b9-fa329107aeeb}\",\n" +
                "    \"links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.bitbucket.org/2.0/users/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://bitbucket.org/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D/\"\n" +
                "      },\n" +
                "      \"avatar\": {\n" +
                "        \"href\": \"https://secure.gravatar.com/avatar/130b39e256ce986657cdbd56b2b1782d?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FNK-1.png\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"nickname\": \"naoyukik\",\n" +
                "    \"type\": \"user\",\n" +
                "    \"account_id\": \"557058:db9fa8da-6d20-45a2-8b75-9663f3929557\"\n" +
                "  },\n" +
                "  \"repository\": {\n" +
                "    \"scm\": \"git\",\n" +
                "    \"website\": null,\n" +
                "    \"uuid\": \"{ce3137a9-ef7d-4c7e-bbc3-5c5ef2773d65}\",\n" +
                "    \"links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.bitbucket.org/2.0/repositories/naoyukik/webhooktest\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://bitbucket.org/naoyukik/webhooktest\"\n" +
                "      },\n" +
                "      \"avatar\": {\n" +
                "        \"href\": \"https://bytebucket.org/ravatar/%7Bce3137a9-ef7d-4c7e-bbc3-5c5ef2773d65%7D?ts=default\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"project\": {\n" +
                "      \"links\": {\n" +
                "        \"self\": {\n" +
                "          \"href\": \"https://api.bitbucket.org/2.0/teams/naoyukik/projects/PROJ\"\n" +
                "        },\n" +
                "        \"html\": {\n" +
                "          \"href\": \"https://bitbucket.org/naoyukik/workspace/projects/PROJ\"\n" +
                "        },\n" +
                "        \"avatar\": {\n" +
                "          \"href\": \"https://bitbucket.org/account/user/naoyukik/projects/PROJ/avatar/32?ts=1543457589\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"type\": \"project\",\n" +
                "      \"uuid\": \"{ceaea47a-7bbb-436a-b2fb-7e13e1a6f9b9}\",\n" +
                "      \"key\": \"PROJ\",\n" +
                "      \"name\": \"Untitled project\"\n" +
                "    },\n" +
                "    \"full_name\": \"naoyukik/webhooktest\",\n" +
                "    \"owner\": {\n" +
                "      \"display_name\": \"naoyuki kodama\",\n" +
                "      \"uuid\": \"{e12843b8-66c8-4bfd-a5b9-fa329107aeeb}\",\n" +
                "      \"links\": {\n" +
                "        \"self\": {\n" +
                "          \"href\": \"https://api.bitbucket.org/2.0/users/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D\"\n" +
                "        },\n" +
                "        \"html\": {\n" +
                "          \"href\": \"https://bitbucket.org/%7Be12843b8-66c8-4bfd-a5b9-fa329107aeeb%7D/\"\n" +
                "        },\n" +
                "        \"avatar\": {\n" +
                "          \"href\": \"https://secure.gravatar.com/avatar/130b39e256ce986657cdbd56b2b1782d?d=https%3A%2F%2Favatar-management--avatars.us-west-2.prod.public.atl-paas.net%2Finitials%2FNK-1.png\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"nickname\": \"naoyukik\",\n" +
                "      \"type\": \"user\",\n" +
                "      \"account_id\": \"557058:db9fa8da-6d20-45a2-8b75-9663f3929557\"\n" +
                "    },\n" +
                "    \"type\": \"repository\",\n" +
                "    \"is_private\": true,\n" +
                "    \"name\": \"webhookTest\"\n" +
                "  }\n" +
                "}\n"
        testJsonParseFromString(string)
    }

    @Test
    @Throws(Exception::class)
    fun testAddIssueComment() {
        val backlogSpaceId: String = System.getenv("BacklogSpaceId")
        val backlogUserApiKey: String = System.getenv("BacklogUserApiKey")
        val backlog = Registration(backlogSpaceId, backlogUserApiKey)
        val branchName = "BTB-1"
        val comment = "テスト"
        val result: Long = backlog.addIssueComment(branchName, comment)
        assertNotEquals(result, 0)
    }
}
