// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

import com.czl.api.core.RequestOptions
import com.czl.api.core.http.HttpResponseFor
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateKeyResponse
import com.czl.api.models.keys.KeyValidateTokenParams
import com.czl.api.models.keys.KeyValidateTokenResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface KeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** 验证 Api Key */
    fun validateKey(params: KeyValidateKeyParams): CompletableFuture<KeyValidateKeyResponse> =
        validateKey(params, RequestOptions.none())

    /** @see [validateKey] */
    fun validateKey(
        params: KeyValidateKeyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeyValidateKeyResponse>

    /** TODO: 验证用户 token / */
    fun validateToken(params: KeyValidateTokenParams): CompletableFuture<KeyValidateTokenResponse> =
        validateToken(params, RequestOptions.none())

    /** @see [validateToken] */
    fun validateToken(
        params: KeyValidateTokenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<KeyValidateTokenResponse>

    /** A view of [KeyServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /keys/validate_key`, but is otherwise the same as
         * [KeyServiceAsync.validateKey].
         */
        @MustBeClosed
        fun validateKey(
            params: KeyValidateKeyParams
        ): CompletableFuture<HttpResponseFor<KeyValidateKeyResponse>> =
            validateKey(params, RequestOptions.none())

        /** @see [validateKey] */
        @MustBeClosed
        fun validateKey(
            params: KeyValidateKeyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeyValidateKeyResponse>>

        /**
         * Returns a raw HTTP response for `get /keys/validate_token`, but is otherwise the same as
         * [KeyServiceAsync.validateToken].
         */
        @MustBeClosed
        fun validateToken(
            params: KeyValidateTokenParams
        ): CompletableFuture<HttpResponseFor<KeyValidateTokenResponse>> =
            validateToken(params, RequestOptions.none())

        /** @see [validateToken] */
        @MustBeClosed
        fun validateToken(
            params: KeyValidateTokenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<KeyValidateTokenResponse>>
    }
}
