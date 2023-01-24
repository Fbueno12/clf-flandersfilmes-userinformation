package br.com.cl.userinformations.components

import br.com.cl.userinformations.factory.UserDTOFactory
import br.com.cl.userinformations.factory.UserModelFactory
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import br.com.cl.userinformations.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserComponentTest() {

    @Mock
    lateinit var userRepository: UserRepository
    @Mock
    lateinit var userModelFactory: UserModelFactory
    @Mock
    lateinit var userDTOFactory: UserDTOFactory
    @InjectMocks
    lateinit var userComponent: UserComponent

    @Mock
    lateinit var dto: UserDTO
    @Mock
    lateinit var userModel: UserModel

    private val USER_ID = 1L

    @Test
    fun `register, must register a new user`() {
        `when`(userModelFactory.generateFromDTO(dto)).thenReturn(userModel)
        `when`(userRepository.save(userModel)).thenReturn(userModel)
        val result = userComponent.register(dto)
        assertNotNull(result)
        assertEquals(userModel, result)
    }

    @Test
    fun `findById, must find a user`() {
        val userModelOpt = Optional.ofNullable(userModel)
        `when`(userRepository.findById(USER_ID)).thenReturn(userModelOpt)
        `when`(userDTOFactory.generateFromModel(userModel)).thenReturn(dto)
        val result = userComponent.findById(USER_ID)
        assertNotNull(result)
        assertEquals(dto, result)
    }

    @Test
    fun `findById, must return exception when not finding a user`() {
        assertThrows(Exception::class.java) {
            userComponent.findById(USER_ID)
        }
    }
}