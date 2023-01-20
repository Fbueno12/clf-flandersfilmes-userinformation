package br.com.cl.userinformations.controllers

import br.com.cl.userinformations.utils.readJson
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `register, must test`() {
        mockMvc.post("/user") {
            header("client_id", "client_id")
            header("client_seed", "client_seed")
            header("Authorization", "bearer Authorization")
            contentType = MediaType.APPLICATION_JSON
            content = readJson("__files/user_request.json")
        }.andExpect {
            status().isOk()
        }
    }
}