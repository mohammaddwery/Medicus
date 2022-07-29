package com.medicus.app.data.repository.user

import com.medicus.app.data.model.User

class UserRepositoryImp(
    // TODO: Pass local data resource to get cached user
) : UserRepository {
    override suspend fun fetchLocalUser(): User = User(id = "hZZ5j8", name = "Mohammad")
}