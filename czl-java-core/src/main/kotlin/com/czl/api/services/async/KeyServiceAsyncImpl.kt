// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

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
import com.czl.api.core.http.parseable
import com.czl.api.core.prepareAsync
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateKeyResponse
import com.czl.api.models.keys.KeyValidateTokenParams
import com.czl.api.models.keys.KeyValidateTokenResponse
import java.util.concurrent.CompletableFuture

class KeyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    KeyServiceAsync {

    private val withRawResponse: KeyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KeyServiceAsync.WithRawResponse = withRawResponse

    override fun validateKey(
        params: KeyValidateKeyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeyValidateKeyResponse> =
        // get /keys/validate_key
        withRawResponse().validateKey(params, requestOptions).thenApply { it.parse() }

    override fun validateToken(
        params: KeyValidateTokenParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeyValidateTokenResponse> =
        // get /keys/validate_token
        withRawResponse().validateToken(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KeyServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val validateKeyHandler: Handler<KeyValidateKeyResponse> =
            jsonHandler<KeyValidateKeyResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun validateKey(
            params: KeyValidateKeyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeyValidateKeyResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("keys", "validate_key")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { validateKeyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val validateTokenHandler: Handler<KeyValidateTokenResponse> =
            jsonHandler<KeyValidateTokenResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun validateToken(
            params: KeyValidateTokenParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeyValidateTokenResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("keys", "validate_token")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { validateTokenHandler.handle(it) }
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
