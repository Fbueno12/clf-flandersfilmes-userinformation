package br.com.cl.userinformations.repository

import br.com.cl.userinformations.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserModel, Long>