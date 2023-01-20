package br.com.cl.userinformations.models

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name = "tbl_user")
data class UserModel (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,

    @Column(name = "name") var name: String? = null,
    @Column(name = "user_name")  var username: String? = null,
    @Column(name = "email")  var email: String? = null,
    @Column(name = "password")  var password: String? = null,
    @Column(name = "seed")  var seed: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as UserModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}