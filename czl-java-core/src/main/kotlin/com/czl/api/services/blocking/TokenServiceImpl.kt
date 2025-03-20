// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.blocking

import com.czl.api.core.ClientOptions
import com.czl.api.core.JsonValue
import com.czl.api.core.RequestOptions
import com.czl.api.core.handlers.errorHandler
import com.czl.api.core.handlers.jsonHandler
import com.czl.api.core.handlers.withErrorHandler
import com.czl.api.core.http.HttpMethod
import com.czl.api.core.http.HttpRequest
import com.czl.api.core.http.HttpResponse.Handler
import com.czl.api.core.http.HttpResponseFor
import com.czl.api.core.http.json
import com.czl.api.core.http.parseable
import com.czl.api.core.prepare
import com.czl.api.models.token.TokenCreateTokenParams
import com.czl.api.models.token.TokenCreateTokenResponse
import com.czl.api.models.token.TokenRetrieveAccessTokenParams
import com.czl.api.models.token.TokenRetrieveAccessTokenResponse

class TokenServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TokenService {

    private val withRawResponse: TokenService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TokenService.WithRawResponse = withRawResponse

    override fun createToken(
        params: TokenCreateTokenParams,
        requestOptions: RequestOptions,
    ): TokenCreateTokenResponse =
        // post /token/gettoken
        withRawResponse().createToken(params, requestOptions).parse()

    override fun retrieveAccessToken(
        params: TokenRetrieveAccessTokenParams,
        requestOptions: RequestOptions,
    ): TokenRetrieveAccessTokenResponse =
        // get /token/accessToken
        withRawResponse().retrieveAccessToken(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TokenService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createTokenHandler: Handler<TokenCreateTokenResponse> =
            jsonHandler<TokenCreateTokenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun createToken(
            params: TokenCreateTokenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TokenCreateTokenResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("token", "gettoken")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createTokenHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveAccessTokenHandler: Handler<TokenRetrieveAccessTokenResponse> =
            jsonHandler<TokenRetrieveAccessTokenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveAccessToken(
            params: TokenRetrieveAccessTokenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TokenRetrieveAccessTokenResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("token", "accessToken")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveAccessTokenHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
