package br.com.cl.userinformations.controllers

import br.com.cl.userinformations.config.*
import br.com.cl.userinformations.models.dto.DefaultDTO
import br.com.cl.userinformations.models.dto.UserDTO
import br.com.cl.userinformations.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {
    @PostMapping
    fun register(
        @RequestHeader(value = H_CLIENT_ID) clientId: String,
        @RequestHeader(value = H_CLIENT_SEED) clientSeed: String,
        @RequestHeader(value = H_AUTHORIZATION) authorization: String,
        @RequestBody dto: UserDTO
    ): ResponseEntity<DefaultDTO> {
        val registration = userService.register(dto)
        return ResponseEntity.status(HttpStatus.OK).body(DefaultDTO(registration))
    }
    @GetMapping("/{id_user}")
    fun findById(@RequestHeader(value = H_CLIENT_ID) clientId: String,
                 @RequestHeader(value = H_CLIENT_SEED) clientSeed: String,
                 @RequestHeader(value = H_AUTHORIZATION) authorization: String,
                 @PathVariable(value = P_ID_USER) idUser: Long
                 ): ResponseEntity<DefaultDTO> {
        val user = userService.findById(idUser)
        return ResponseEntity.status(HttpStatus.OK).body(DefaultDTO(user))
    }
}