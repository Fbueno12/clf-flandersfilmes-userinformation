package br.com.cl.userinformations.services

import br.com.cl.userinformations.components.UserComponent
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import org.springframework.stereotype.Service

@Service
class UserService(
    val userComponent: UserComponent,
) {
    fun register(dto: UserDTO): UserModel {
        return userComponent.register(dto)
    }

    fun findById(idUser: Long): UserDTO {
        return userComponent.findById(idUser)
    }
}