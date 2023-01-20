package br.com.cl.userinformations.models.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class UserDTO (
    val name: String,
    @JsonProperty("user_name") val userName: String,
    val email: String,
    val password: String
): Serializable