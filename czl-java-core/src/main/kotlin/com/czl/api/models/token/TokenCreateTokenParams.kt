// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import com.czl.api.core.ExcludeMissing
import com.czl.api.core.JsonField
import com.czl.api.core.JsonMissing
import com.czl.api.core.JsonValue
import com.czl.api.core.NoAutoDetect
import com.czl.api.core.Params
import com.czl.api.core.checkKnown
import com.czl.api.core.checkRequired
import com.czl.api.core.http.Headers
import com.czl.api.core.http.QueryParams
import com.czl.api.core.immutableEmptyMap
import com.czl.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional

/** 通过 accessToken 和数据域生成新的访问 Token */
class TokenCreateTokenParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun accessToken(): String = body.accessToken()

    fun apis(): Optional<List<String>> = body.apis()

    fun productId(): Optional<Long> = body.productId()

    fun times(): Optional<Long> = body.times()

    fun _accessToken(): JsonField<String> = body._accessToken()

    fun _apis(): JsonField<List<String>> = body._apis()

    fun _productId(): JsonField<Long> = body._productId()

    fun _times(): JsonField<Long> = body._times()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("access_token")
        @ExcludeMissing
        private val accessToken: JsonField<String> = JsonMissing.of(),
        @JsonProperty("apis")
        @ExcludeMissing
        private val apis: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("product_id")
        @ExcludeMissing
        private val productId: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("times")
        @ExcludeMissing
        private val times: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun accessToken(): String = accessToken.getRequired("access_token")

        fun apis(): Optional<List<String>> = Optional.ofNullable(apis.getNullable("apis"))

        fun productId(): Optional<Long> = Optional.ofNullable(productId.getNullable("product_id"))

        fun times(): Optional<Long> = Optional.ofNullable(times.getNullable("times"))

        @JsonProperty("access_token")
        @ExcludeMissing
        fun _accessToken(): JsonField<String> = accessToken

        @JsonProperty("apis") @ExcludeMissing fun _apis(): JsonField<List<String>> = apis

        @JsonProperty("product_id") @ExcludeMissing fun _productId(): JsonField<Long> = productId

        @JsonProperty("times") @ExcludeMissing fun _times(): JsonField<Long> = times

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            accessToken()
            apis()
            productId()
            times()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var accessToken: JsonField<String>? = null
            private var apis: JsonField<MutableList<String>>? = null
            private var productId: JsonField<Long> = JsonMissing.of()
            private var times: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                accessToken = body.accessToken
                apis = body.apis.map { it.toMutableList() }
                productId = body.productId
                times = body.times
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun accessToken(accessToken: String) = accessToken(JsonField.of(accessToken))

            fun accessToken(accessToken: JsonField<String>) = apply {
                this.accessToken = accessToken
            }

            fun apis(apis: List<String>) = apis(JsonField.of(apis))

            fun apis(apis: JsonField<List<String>>) = apply {
                this.apis = apis.map { it.toMutableList() }
            }

            fun addApi(api: String) = apply {
                apis =
                    (apis ?: JsonField.of(mutableListOf())).also { checkKnown("apis", it).add(api) }
            }

            fun productId(productId: Long) = productId(JsonField.of(productId))

            fun productId(productId: JsonField<Long>) = apply { this.productId = productId }

            fun times(times: Long) = times(JsonField.of(times))

            fun times(times: JsonField<Long>) = apply { this.times = times }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): Body =
                Body(
                    checkRequired("accessToken", accessToken),
                    (apis ?: JsonMissing.of()).map { it.toImmutable() },
                    productId,
                    times,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && accessToken == other.accessToken && apis == other.apis && productId == other.productId && times == other.times && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(accessToken, apis, productId, times, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{accessToken=$accessToken, apis=$apis, productId=$productId, times=$times, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TokenCreateTokenParams].
         *
         * The following fields are required:
         * ```java
         * .accessToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TokenCreateTokenParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tokenCreateTokenParams: TokenCreateTokenParams) = apply {
            body = tokenCreateTokenParams.body.toBuilder()
            additionalHeaders = tokenCreateTokenParams.additionalHeaders.toBuilder()
            additionalQueryParams = tokenCreateTokenParams.additionalQueryParams.toBuilder()
        }

        fun accessToken(accessToken: String) = apply { body.accessToken(accessToken) }

        fun accessToken(accessToken: JsonField<String>) = apply { body.accessToken(accessToken) }

        fun apis(apis: List<String>) = apply { body.apis(apis) }

        fun apis(apis: JsonField<List<String>>) = apply { body.apis(apis) }

        fun addApi(api: String) = apply { body.addApi(api) }

        fun productId(productId: Long) = apply { body.productId(productId) }

        fun productId(productId: JsonField<Long>) = apply { body.productId(productId) }

        fun times(times: Long) = apply { body.times(times) }

        fun times(times: JsonField<Long>) = apply { body.times(times) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun build(): TokenCreateTokenParams =
            TokenCreateTokenParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TokenCreateTokenParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "TokenCreateTokenParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
