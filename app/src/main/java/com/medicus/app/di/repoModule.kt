package com.medicus.app.di

import com.medicus.app.data.repository.biomarker.BiomarkerRepository
import com.medicus.app.data.repository.biomarker.BiomarkerRepositoryImp
import com.medicus.app.data.repository.user.UserRepository
import com.medicus.app.data.repository.user.UserRepositoryImp
import org.koin.dsl.module

val repoModule = module {
    factory<BiomarkerRepository> { BiomarkerRepositoryImp() }
    factory<UserRepository> { UserRepositoryImp() }
}
