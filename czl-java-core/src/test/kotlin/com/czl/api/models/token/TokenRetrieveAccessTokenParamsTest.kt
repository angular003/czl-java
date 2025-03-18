// File generated from our OpenAPI spec by Stainless.

package com.czl.api.models.token

import com.czl.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenRetrieveAccessTokenParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        TokenRetrieveAccessTokenParams.builder().corpId("corp_id").userId("user_id").build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            TokenRetrieveAccessTokenParams.builder().corpId("corp_id").userId("user_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("corp_id", "corp_id").put("user_id", "user_id").build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            TokenRetrieveAccessTokenParams.builder().corpId("corp_id").userId("user_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("corp_id", "corp_id").put("user_id", "user_id").build()
            )
    }
}
