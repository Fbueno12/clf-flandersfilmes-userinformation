package br.com.cl.userinformations.factory

import br.com.cl.userinformations.extensions.toDTO
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import org.springframework.stereotype.Component

@Component
class UserDTOFactory {

    fun generateFromModel(model: UserModel): UserDTO {
        return model.toDTO(UserDTO())
    }

}