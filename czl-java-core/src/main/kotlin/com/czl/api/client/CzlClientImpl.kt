// File generated from our OpenAPI spec by Stainless.

package com.czl.api.client

import com.czl.api.core.ClientOptions
import com.czl.api.core.getPackageVersion
import com.czl.api.services.blocking.KeyService
import com.czl.api.services.blocking.KeyServiceImpl
import com.czl.api.services.blocking.TokenService
import com.czl.api.services.blocking.TokenServiceImpl

class CzlClientImpl(private val clientOptions: ClientOptions) : CzlClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: CzlClientAsync by lazy { CzlClientAsyncImpl(clientOptions) }

    private val withRawResponse: CzlClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val keys: KeyService by lazy { KeyServiceImpl(clientOptionsWithUserAgent) }

    private val token: TokenService by lazy { TokenServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): CzlClientAsync = async

    override fun withRawResponse(): CzlClient.WithRawResponse = withRawResponse

    override fun keys(): KeyService = keys

    override fun token(): TokenService = token

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CzlClient.WithRawResponse {

        private val keys: KeyService.WithRawResponse by lazy {
            KeyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val token: TokenService.WithRawResponse by lazy {
            TokenServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun keys(): KeyService.WithRawResponse = keys

        override fun token(): TokenService.WithRawResponse = token
    }
}
