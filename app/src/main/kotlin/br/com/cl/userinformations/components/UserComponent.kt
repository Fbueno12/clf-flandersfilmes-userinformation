package br.com.cl.userinformations.components

import br.com.cl.userinformations.factory.UserDTOFactory
import br.com.cl.userinformations.factory.UserModelFactory
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import br.com.cl.userinformations.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserComponent(
    val userRepository: UserRepository,
    val userModelFactory: UserModelFactory,
    val userDTOFactory: UserDTOFactory
) {

    fun register(dto: UserDTO): UserModel {
        val user = userModelFactory.generateFromDTO(dto)
        return userRepository.save(user)
    }

    fun findById(idUser: Long): UserDTO {
        val user = userRepository.findByIdOrNull(idUser) ?: throw Exception("User not found")
        return userDTOFactory.generateFromModel(user)
    }

}