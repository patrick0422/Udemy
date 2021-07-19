package com.example.viewmodelscope

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)

        val users = listOf(
            User(1, "Jack"),
            User(2, "Sam"),
            User(3, "Daniel"),
            User(4, "Amy"),
        )

        return users
    }
}