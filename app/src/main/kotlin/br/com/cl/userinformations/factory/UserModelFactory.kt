package br.com.cl.userinformations.factory

import br.com.cl.userinformations.extensions.toModel
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserModelFactory {
    fun generateFromDTO(dto: UserDTO): UserModel {
        return dto.toModel(UserModel()).apply {
            seed = UUID.randomUUID().toString()
        }
    }
}