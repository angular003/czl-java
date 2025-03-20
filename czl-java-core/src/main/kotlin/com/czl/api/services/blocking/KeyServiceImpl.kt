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
import com.czl.api.core.http.parseable
import com.czl.api.core.prepare
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateKeyResponse
import com.czl.api.models.keys.KeyValidateTokenParams
import com.czl.api.models.keys.KeyValidateTokenResponse

class KeyServiceImpl internal constructor(private val clientOptions: ClientOptions) : KeyService {

    private val withRawResponse: KeyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KeyService.WithRawResponse = withRawResponse

    override fun validateKey(
        params: KeyValidateKeyParams,
        requestOptions: RequestOptions,
    ): KeyValidateKeyResponse =
        // get /keys/validate_key
        withRawResponse().validateKey(params, requestOptions).parse()

    override fun validateToken(
        params: KeyValidateTokenParams,
        requestOptions: RequestOptions,
    ): KeyValidateTokenResponse =
        // get /keys/validate_token
        withRawResponse().validateToken(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KeyService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val validateKeyHandler: Handler<KeyValidateKeyResponse> =
            jsonHandler<KeyValidateKeyResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun validateKey(
            params: KeyValidateKeyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KeyValidateKeyResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("keys", "validate_key")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { validateKeyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<KeyValidateTokenResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("keys", "validate_token")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
