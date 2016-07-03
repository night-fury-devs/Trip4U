package com.nfd.trip4u.service.domain

import com.nfd.trip4u.dto.UserDto
import com.nfd.trip4u.entity.domain.User
import com.nfd.trip4u.repository.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * Author: Mary Kuchumova
 * Date: 17 June 2016
 * Time: 17:45
 */

@Service
open class UserService {

    @Autowired
    @Qualifier("userRepository")
    lateinit var userRepository: UserRepository

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun delete(user: User) {
        userRepository.delete(user)
    }

    fun delete(id: String) {
        userRepository.delete(id)
    }

    fun findAll(): Iterable<User> {
        return userRepository.findAll()
    }

    fun findById(id: String?): User? {
        return userRepository.findOne(id)
    }

    fun findByUserName(userName: String): User? {
        return userRepository.findUserByUserName(userName)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findUserByEmail(email)
    }

    fun findByUserNameAndPassword(userName: String, password: String): User? {
        return userRepository.findUserByUserNameAndPassword(userName, password)
    }

    fun count(): Long {
        return userRepository.count()
    }

    fun exists(userDto: UserDto): Boolean {
        return userRepository.findUserByUserNameOrEmail(userDto.userName, userDto.email) != null
    }

}