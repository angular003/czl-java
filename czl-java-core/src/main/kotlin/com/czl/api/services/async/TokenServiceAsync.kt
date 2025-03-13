// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services.async

import com.czl.api.core.RequestOptions
import com.czl.api.core.http.HttpResponseFor
import com.czl.api.models.token.TokenCreateTokenParams
import com.czl.api.models.token.TokenCreateTokenResponse
import com.czl.api.models.token.TokenRetrieveAccessTokenParams
import com.czl.api.models.token.TokenRetrieveAccessTokenResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface TokenServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** 通过 accessToken 和数据域生成新的访问 Token */
    fun createToken(params: TokenCreateTokenParams): CompletableFuture<TokenCreateTokenResponse> =
        createToken(params, RequestOptions.none())

    /** @see [createToken] */
    fun createToken(
        params: TokenCreateTokenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenCreateTokenResponse>

    /** 通过企业信息获取 Token⛳ */
    fun retrieveAccessToken(
        params: TokenRetrieveAccessTokenParams
    ): CompletableFuture<TokenRetrieveAccessTokenResponse> =
        retrieveAccessToken(params, RequestOptions.none())

    /** @see [retrieveAccessToken] */
    fun retrieveAccessToken(
        params: TokenRetrieveAccessTokenParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TokenRetrieveAccessTokenResponse>

    /** A view of [TokenServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /token/gettoken`, but is otherwise the same as
         * [TokenServiceAsync.createToken].
         */
        @MustBeClosed
        fun createToken(
            params: TokenCreateTokenParams
        ): CompletableFuture<HttpResponseFor<TokenCreateTokenResponse>> =
            createToken(params, RequestOptions.none())

        /** @see [createToken] */
        @MustBeClosed
        fun createToken(
            params: TokenCreateTokenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenCreateTokenResponse>>

        /**
         * Returns a raw HTTP response for `get /token/accessToken`, but is otherwise the same as
         * [TokenServiceAsync.retrieveAccessToken].
         */
        @MustBeClosed
        fun retrieveAccessToken(
            params: TokenRetrieveAccessTokenParams
        ): CompletableFuture<HttpResponseFor<TokenRetrieveAccessTokenResponse>> =
            retrieveAccessToken(params, RequestOptions.none())

        /** @see [retrieveAccessToken] */
        @MustBeClosed
        fun retrieveAccessToken(
            params: TokenRetrieveAccessTokenParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TokenRetrieveAccessTokenResponse>>
    }
}
