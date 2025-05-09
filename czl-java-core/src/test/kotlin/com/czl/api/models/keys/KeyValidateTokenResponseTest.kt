// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.keys

import com.czl.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KeyValidateTokenResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val keyValidateTokenResponse = KeyValidateTokenResponse.builder().build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keyValidateTokenResponse = KeyValidateTokenResponse.builder().build()

        val roundtrippedKeyValidateTokenResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keyValidateTokenResponse),
                jacksonTypeRef<KeyValidateTokenResponse>(),
            )

        assertThat(roundtrippedKeyValidateTokenResponse).isEqualTo(keyValidateTokenResponse)
    }
}
