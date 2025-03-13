// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

import com.czl.api.core.ClientOptions
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
import com.czl.api.core.prepareAsync
import com.czl.api.errors.CzlError
import com.czl.api.models.token.TokenCreateTokenParams
import com.czl.api.models.token.TokenCreateTokenResponse
import com.czl.api.models.token.TokenRetrieveAccessTokenParams
import com.czl.api.models.token.TokenRetrieveAccessTokenResponse
import java.util.concurrent.CompletableFuture

class TokenServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TokenServiceAsync {

    private val withRawResponse: TokenServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TokenServiceAsync.WithRawResponse = withRawResponse

    override fun createToken(
        params: TokenCreateTokenParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TokenCreateTokenResponse> =
        // post /token/gettoken
        withRawResponse().createToken(params, requestOptions).thenApply { it.parse() }

    override fun retrieveAccessToken(
        params: TokenRetrieveAccessTokenParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TokenRetrieveAccessTokenResponse> =
        // get /token/accessToken
        withRawResponse().retrieveAccessToken(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TokenServiceAsync.WithRawResponse {

        private val errorHandler: Handler<CzlError> = errorHandler(clientOptions.jsonMapper)

        private val createTokenHandler: Handler<TokenCreateTokenResponse> =
            jsonHandler<TokenCreateTokenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun createToken(
            params: TokenCreateTokenParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TokenCreateTokenResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("token", "gettoken")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createTokenHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
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
        ): CompletableFuture<HttpResponseFor<TokenRetrieveAccessTokenResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("token", "accessToken")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
}
