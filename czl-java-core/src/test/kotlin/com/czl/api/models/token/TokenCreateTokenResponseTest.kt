// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import com.czl.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenCreateTokenResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val tokenCreateTokenResponse = TokenCreateTokenResponse.builder().build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tokenCreateTokenResponse = TokenCreateTokenResponse.builder().build()

        val roundtrippedTokenCreateTokenResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenCreateTokenResponse),
                jacksonTypeRef<TokenCreateTokenResponse>(),
            )

        assertThat(roundtrippedTokenCreateTokenResponse).isEqualTo(tokenCreateTokenResponse)
    }
}
