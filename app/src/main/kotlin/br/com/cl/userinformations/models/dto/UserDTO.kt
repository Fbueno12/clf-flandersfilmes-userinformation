package br.com.cl.userinformations.models.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class UserDTO (
    var name: String? = null,
    @JsonProperty("user_name")
    var userName: String? = null,
    var email: String? = null,
    var password: String? = null
): Serializable