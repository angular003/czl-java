// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.blocking

import com.czl.api.TestServerExtension
import com.czl.api.client.okhttp.CzlOkHttpClient
import com.czl.api.models.token.TokenCreateTokenParams
import com.czl.api.models.token.TokenRetrieveAccessTokenParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class TokenServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createToken() {
        val client =
            CzlOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val tokenService = client.token()

        val response =
            tokenService.createToken(
                TokenCreateTokenParams.builder()
                    .accessToken("access_token")
                    .addApi("string")
                    .productId(0L)
                    .times(0L)
                    .build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieveAccessToken() {
        val client =
            CzlOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val tokenService = client.token()

        val response =
            tokenService.retrieveAccessToken(
                TokenRetrieveAccessTokenParams.builder().corpId("corp_id").userId("user_id").build()
            )

        response.validate()
    }
}
