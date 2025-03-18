// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import kotlin.jvm.optionals.getOrNull
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenCreateTokenParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        TokenCreateTokenParams.builder()
            .accessToken("access_token")
            .addApi("string")
            .productId(0L)
            .times(0L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            TokenCreateTokenParams.builder()
                .accessToken("access_token")
                .addApi("string")
                .productId(0L)
                .times(0L)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.accessToken()).isEqualTo("access_token")
        assertThat(body.apis().getOrNull()).containsExactly("string")
        assertThat(body.productId()).contains(0L)
        assertThat(body.times()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params = TokenCreateTokenParams.builder().accessToken("access_token").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.accessToken()).isEqualTo("access_token")
    }
}
