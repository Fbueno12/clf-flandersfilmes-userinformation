package br.com.cl.userinformations.controllers

import br.com.cl.userinformations.models.UserModel
import br.com.cl.userinformations.repository.UserRepository
import br.com.cl.userinformations.utils.readJson
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `register, must test`() {
        mockMvc.post("/user") {
            header("client_id", "client_id")
            header("client_seed", "client_seed")
            header("Authorization", "bearer Authorization")
            contentType = MediaType.APPLICATION_JSON
            content = readJson("__files/user_request.json")
        }.andExpect {
            status().isOk
            jsonPath("$.data").exists()
            jsonPath("$.data.id", Matchers.`is`(1))
            jsonPath("$.data.name", Matchers.`is`("Felipe"))
            jsonPath("$.data.username", Matchers.`is`("fbueno12"))
            jsonPath("$.data.email", Matchers.`is`("felipebueno181@gmail.com"))
            jsonPath("$.data.password", Matchers.`is`("something cyphered"))
        }
    }

    @Test
    fun `findById, must test`() {
        val idUser = 1L
        val userMock = this.insertNewUser(idUser)
        mockMvc.get("/user/${idUser}") {
            header("client_id", "client_id")
            header("client_seed", "client_seed")
            header("Authorization", "bearer Authorization")
        }.andExpect {
            status().isOk
            jsonPath("$.data").exists()
            jsonPath("$.data.name", Matchers.`is`(userMock.name))
            jsonPath("$.data.user_name", Matchers.`is`(userMock.username))
            jsonPath("$.data.email", Matchers.`is`(userMock.email))
            jsonPath("$.data.password", Matchers.`is`(userMock.password))
        }
    }

    private fun insertNewUser(idUser: Long): UserModel {
        val newUser = UserModel().apply {
            id = idUser
            name = "name"
            username = "username"
            email = "email@email.com"
            password = "password"
            seed = "seed"
        }
        return userRepository.save(newUser)
    }
}