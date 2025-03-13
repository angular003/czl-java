// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import com.czl.api.core.ExcludeMissing
import com.czl.api.core.JsonValue
import com.czl.api.core.NoAutoDetect
import com.czl.api.core.immutableEmptyMap
import com.czl.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects

@NoAutoDetect
class TokenCreateTokenResponse
@JsonCreator
private constructor(
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
) {

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): TokenCreateTokenResponse = apply {
        if (validated) {
            return@apply
        }

        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [TokenCreateTokenResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TokenCreateTokenResponse]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tokenCreateTokenResponse: TokenCreateTokenResponse) = apply {
            additionalProperties = tokenCreateTokenResponse.additionalProperties.toMutableMap()
        }

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

        fun build(): TokenCreateTokenResponse =
            TokenCreateTokenResponse(additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TokenCreateTokenResponse && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "TokenCreateTokenResponse{additionalProperties=$additionalProperties}"
}
