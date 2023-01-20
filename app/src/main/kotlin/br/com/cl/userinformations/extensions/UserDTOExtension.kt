package br.com.cl.userinformations.extensions

import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import java.util.*

fun UserDTO.toModel(model: UserModel): UserModel {
    val dto = this
    return model.apply {
        name = dto.name
        email = dto.email
        password = dto.password
        username = dto.userName
        seed = UUID.randomUUID().toString()
    }
}