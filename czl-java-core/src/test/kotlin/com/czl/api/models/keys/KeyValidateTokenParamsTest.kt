// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.keys

import com.czl.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KeyValidateTokenParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        KeyValidateTokenParams.builder().token("token").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params = KeyValidateTokenParams.builder().token("token").build()
        val expected = QueryParams.builder()
        expected.put("token", "token")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = KeyValidateTokenParams.builder().token("token").build()
        val expected = QueryParams.builder()
        expected.put("token", "token")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
