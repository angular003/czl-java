// File generated from our OpenAPI spec by Stainless.

package com.czl.api.services

import com.czl.api.client.CzlClient
import com.czl.api.client.okhttp.CzlOkHttpClient
import com.czl.api.core.JsonValue
import com.czl.api.core.http.Headers
import com.czl.api.core.jsonMapper
import com.czl.api.errors.BadRequestException
import com.czl.api.errors.CzlError
import com.czl.api.errors.CzlException
import com.czl.api.errors.InternalServerException
import com.czl.api.errors.NotFoundException
import com.czl.api.errors.PermissionDeniedException
import com.czl.api.errors.RateLimitException
import com.czl.api.errors.UnauthorizedException
import com.czl.api.errors.UnexpectedStatusCodeException
import com.czl.api.errors.UnprocessableEntityException
import com.czl.api.models.keys.KeyValidateTokenParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@WireMockTest
internal class ErrorHandlingTest {

    companion object {

        private val ERROR: CzlError =
            CzlError.builder().putAdditionalProperty("errorProperty", JsonValue.from("42")).build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: CzlClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            CzlOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken400() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<BadRequestException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken401() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnauthorizedException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken403() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<PermissionDeniedException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken404() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<NotFoundException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken422() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken429() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<RateLimitException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken500() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<InternalServerException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateToken999() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun keysValidateTokenInvalidJsonBody() {
        val keyService = client.keys()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<CzlException> {
                keyService.validateToken(KeyValidateTokenParams.builder().token("token").build())
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
