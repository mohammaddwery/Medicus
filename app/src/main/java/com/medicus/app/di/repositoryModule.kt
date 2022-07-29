package com.medicus.app.di

import com.medicus.app.data.repository.biomarker.BiomarkerRepository
import com.medicus.app.data.repository.biomarker.BiomarkerRepositoryImp
import com.medicus.app.data.repository.user.UserRepository
import com.medicus.app.data.repository.user.UserRepositoryImp
import org.koin.dsl.module

val repositoryModule = module {
    factory<BiomarkerRepository> {
        BiomarkerRepositoryImp(
            get()
        )
    }
    factory<UserRepository> { UserRepositoryImp() }
}
