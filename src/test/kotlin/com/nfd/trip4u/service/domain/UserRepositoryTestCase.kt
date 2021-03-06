package com.nfd.trip4u.service.domain

import com.nfd.trip4u.AbstractTestCase
import com.nfd.trip4u.entity.domain.User
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Author: Mary Kuchumova
 * Date: 17 Jun 2016
 * Time: 22:56
 */
@Component
open class UserRepositoryTestCase : AbstractTestCase() {

    private lateinit var user: User

    @Autowired
    private lateinit var userService: UserService

    @Before
    fun populateTestData() {
        user = User("test user", "test@mail.com", "passwrd")
        user = userService.save(user)
        Assert.assertNotNull(user.id)
    }

    @Test
    fun updateUser(){
        user.firstName = "name"
        val newUser = userService.save(user)
        Assert.assertEquals(newUser.firstName, user.firstName)
    }

    @Test
    fun findAllUsers(){
        val userList = userService.findAll()
        Assert.assertTrue(userList.contains(user))
    }

    @Test
    fun findUserById(){
        val foundUser = userService.findById(user.id)
        Assert.assertEquals(foundUser, user)
    }

    @Test
    fun findUserByUsername(){
        val foundUser = userService.findByUsername(user.username)
        Assert.assertEquals(foundUser, user)
    }

    @Test
    fun findUserByEmail(){
        val foundUser = userService.findByEmail(user.email)
        Assert.assertEquals(foundUser, user)
    }

    @Test
    fun findUserByCredentials(){
        val foundUser = userService.findByUsernameAndPassword(user.username, user.password)
        Assert.assertEquals(foundUser, user)
    }

    @Test
    fun getUsersCount(){
        val usersCount = userService.count()
        Assert.assertNotEquals(usersCount, 0)
    }

    @After
    fun removeTestData() {
        userService.delete(user)
    }
}