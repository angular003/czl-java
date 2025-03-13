// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.blocking

import com.czl.api.TestServerExtension
import com.czl.api.client.okhttp.CzlOkHttpClient
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateTokenParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class KeyServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun validateKey() {
        val client =
            CzlOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val keyService = client.keys()

        val response = keyService.validateKey(KeyValidateKeyParams.builder().key("key").build())

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun validateToken() {
        val client =
            CzlOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val keyService = client.keys()

        val response =
            keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())

        response.validate()
    }
}
