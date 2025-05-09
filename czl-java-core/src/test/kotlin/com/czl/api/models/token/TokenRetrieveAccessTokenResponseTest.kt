// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import com.czl.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenRetrieveAccessTokenResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val tokenRetrieveAccessTokenResponse = TokenRetrieveAccessTokenResponse.builder().build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tokenRetrieveAccessTokenResponse = TokenRetrieveAccessTokenResponse.builder().build()

        val roundtrippedTokenRetrieveAccessTokenResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tokenRetrieveAccessTokenResponse),
                jacksonTypeRef<TokenRetrieveAccessTokenResponse>(),
            )

        assertThat(roundtrippedTokenRetrieveAccessTokenResponse)
            .isEqualTo(tokenRetrieveAccessTokenResponse)
    }
}
