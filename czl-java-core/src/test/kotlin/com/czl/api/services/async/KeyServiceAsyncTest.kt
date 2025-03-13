// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

import com.czl.api.TestServerExtension
import com.czl.api.client.okhttp.CzlOkHttpClientAsync
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateTokenParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class KeyServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun validateKey() {
        val client =
            CzlOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val keyServiceAsync = client.keys()

        val responseFuture =
            keyServiceAsync.validateKey(KeyValidateKeyParams.builder().key("key").build())

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun validateToken() {
        val client =
            CzlOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val keyServiceAsync = client.keys()

        val responseFuture =
            keyServiceAsync.validateToken(KeyValidateTokenParams.builder().token("token").build())

        val response = responseFuture.get()
        response.validate()
    }
}
