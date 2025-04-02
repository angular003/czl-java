// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.keys

import com.czl.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KeyValidateKeyResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val keyValidateKeyResponse = KeyValidateKeyResponse.builder().build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keyValidateKeyResponse = KeyValidateKeyResponse.builder().build()

        val roundtrippedKeyValidateKeyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keyValidateKeyResponse),
                jacksonTypeRef<KeyValidateKeyResponse>(),
            )

        assertThat(roundtrippedKeyValidateKeyResponse).isEqualTo(keyValidateKeyResponse)
    }
}
