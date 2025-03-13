// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

import com.czl.api.TestServerExtension
import com.czl.api.client.okhttp.CzlOkHttpClientAsync
import com.czl.api.models.token.TokenCreateTokenParams
import com.czl.api.models.token.TokenRetrieveAccessTokenParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TokenServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createToken() {
        val client =
            CzlOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val tokenServiceAsync = client.token()

        val responseFuture =
            tokenServiceAsync.createToken(
                TokenCreateTokenParams.builder()
                    .accessToken("access_token")
                    .addApi("string")
                    .productId(0L)
                    .times(0L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveAccessToken() {
        val client =
            CzlOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val tokenServiceAsync = client.token()

        val responseFuture =
            tokenServiceAsync.retrieveAccessToken(
                TokenRetrieveAccessTokenParams.builder().corpId("corp_id").userId("user_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
