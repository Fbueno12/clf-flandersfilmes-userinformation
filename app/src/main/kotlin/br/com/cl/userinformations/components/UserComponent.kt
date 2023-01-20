package br.com.cl.userinformations.components

import br.com.cl.userinformations.extensions.toModel
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import br.com.cl.userinformations.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserComponent(
    val userRepository: UserRepository
) {

    fun register(dto: UserDTO): UserModel {
        val model = userRepository.save(dto.toModel(UserModel()))
        return model
    }

}