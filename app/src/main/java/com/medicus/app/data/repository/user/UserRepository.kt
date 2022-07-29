package com.medicus.app.data.repository.user

import com.medicus.app.data.model.User


interface UserRepository {
    suspend fun fetchLocalUser(): User
}