// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.keys

import com.czl.api.core.ExcludeMissing
import com.czl.api.core.JsonValue
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Collections
import java.util.Objects

class KeyValidateKeyResponse
private constructor(private val additionalProperties: MutableMap<String, JsonValue>) {

    @JsonCreator private constructor() : this(mutableMapOf())

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [KeyValidateKeyResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [KeyValidateKeyResponse]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(keyValidateKeyResponse: KeyValidateKeyResponse) = apply {
            additionalProperties = keyValidateKeyResponse.additionalProperties.toMutableMap()
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

        /**
         * Returns an immutable instance of [KeyValidateKeyResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): KeyValidateKeyResponse =
            KeyValidateKeyResponse(additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): KeyValidateKeyResponse = apply {
        if (validated) {
            return@apply
        }

        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is KeyValidateKeyResponse && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "KeyValidateKeyResponse{additionalProperties=$additionalProperties}"
}
