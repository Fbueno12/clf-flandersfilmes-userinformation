package br.com.cl.userinformations.extensions

import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO

fun UserModel.toDTO(dto: UserDTO): UserDTO {
    val model = this
    return dto.apply {
        name = model.name ?: throw Exception("Name is invalid")
        email = model.email ?: throw Exception("Email is invalid")
        userName = model.username ?: throw Exception("UserName is invalid")
        password = model.password ?: throw Exception("Password is invalid")
    }
}