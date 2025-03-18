// File generated from our OpenAPI spec by Stainless.

package com.czl.api.errors

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
class CzlError
@JsonCreator
private constructor(
    @JsonAnyGetter
    @ExcludeMissing
    @JsonAnySetter
    @get:JvmName("additionalProperties")
    val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
) {

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [CzlError]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CzlError]. */
    class Builder internal constructor() {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(czlError: CzlError) = apply {
            additionalProperties = czlError.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [CzlError].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CzlError = CzlError(additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CzlError && additionalProperties == other.additionalProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(additionalProperties) /* spotless:on */

    override fun toString() = "CzlError{additionalProperties=$additionalProperties}"
}
