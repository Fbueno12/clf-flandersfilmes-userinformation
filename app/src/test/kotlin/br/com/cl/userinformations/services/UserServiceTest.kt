package br.com.cl.userinformations.services

import br.com.cl.userinformations.components.UserComponent
import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.models.dto.UserDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    lateinit var userComponent: UserComponent
    @InjectMocks
    lateinit var userService: UserService

    @Mock
    lateinit var userModel: UserModel
    @Mock
    lateinit var dto: UserDTO

    private val USER_ID = 1L
    @Test
    fun `register, must register a new user`() {
        `when`(userComponent.register(dto)).thenReturn(userModel)
        val result = userService.register(dto)
        assertNotNull(result)
    }

    @Test
    fun `findById, must return a user`() {
        `when`(userComponent.findById(USER_ID)).thenReturn(dto)
        val result = userService.findById(USER_ID)
        assertNotNull(result);
        assertEquals(dto, result)
    }
}
