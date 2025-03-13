// File generated from our OpenAPI spec by Stainless.

package com.czl.api.client

import com.czl.api.core.ClientOptions
import com.czl.api.core.getPackageVersion
import com.czl.api.services.async.KeyServiceAsync
import com.czl.api.services.async.KeyServiceAsyncImpl
import com.czl.api.services.async.TokenServiceAsync
import com.czl.api.services.async.TokenServiceAsyncImpl

class CzlClientAsyncImpl(private val clientOptions: ClientOptions) : CzlClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: CzlClient by lazy { CzlClientImpl(clientOptions) }

    private val withRawResponse: CzlClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val keys: KeyServiceAsync by lazy { KeyServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val token: TokenServiceAsync by lazy {
        TokenServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): CzlClient = sync

    override fun withRawResponse(): CzlClientAsync.WithRawResponse = withRawResponse

    override fun keys(): KeyServiceAsync = keys

    override fun token(): TokenServiceAsync = token

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CzlClientAsync.WithRawResponse {

        private val keys: KeyServiceAsync.WithRawResponse by lazy {
            KeyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val token: TokenServiceAsync.WithRawResponse by lazy {
            TokenServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun keys(): KeyServiceAsync.WithRawResponse = keys

        override fun token(): TokenServiceAsync.WithRawResponse = token
    }
}
