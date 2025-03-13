// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.blocking

import com.czl.api.core.RequestOptions
import com.czl.api.core.http.HttpResponseFor
import com.czl.api.models.keys.KeyValidateKeyParams
import com.czl.api.models.keys.KeyValidateKeyResponse
import com.czl.api.models.keys.KeyValidateTokenParams
import com.czl.api.models.keys.KeyValidateTokenResponse
import com.google.errorprone.annotations.MustBeClosed

interface KeyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** 验证 Api Key */
    fun validateKey(params: KeyValidateKeyParams): KeyValidateKeyResponse =
        validateKey(params, RequestOptions.none())

    /** @see [validateKey] */
    fun validateKey(
        params: KeyValidateKeyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeyValidateKeyResponse

    /** TODO: 验证用户 token / */
    fun validateToken(params: KeyValidateTokenParams): KeyValidateTokenResponse =
        validateToken(params, RequestOptions.none())

    /** @see [validateToken] */
    fun validateToken(
        params: KeyValidateTokenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KeyValidateTokenResponse

    /** A view of [KeyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /keys/validate_key`, but is otherwise the same as
         * [KeyService.validateKey].
         */
        @MustBeClosed
        fun validateKey(params: KeyValidateKeyParams): HttpResponseFor<KeyValidateKeyResponse> =
            validateKey(params, RequestOptions.none())

        /** @see [validateKey] */
        @MustBeClosed
        fun validateKey(
            params: KeyValidateKeyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeyValidateKeyResponse>

        /**
         * Returns a raw HTTP response for `get /keys/validate_token`, but is otherwise the same as
         * [KeyService.validateToken].
         */
        @MustBeClosed
        fun validateToken(
            params: KeyValidateTokenParams
        ): HttpResponseFor<KeyValidateTokenResponse> = validateToken(params, RequestOptions.none())

        /** @see [validateToken] */
        @MustBeClosed
        fun validateToken(
            params: KeyValidateTokenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KeyValidateTokenResponse>
    }
}
