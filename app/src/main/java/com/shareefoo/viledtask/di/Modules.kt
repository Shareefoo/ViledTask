package com.shareefoo.viledtask.di

import com.shareefoo.viledtask.repository.GeneralRepository
import com.shareefoo.viledtask.repository.GeneralRepositoryImpl
import com.shareefoo.viledtask.ui.main.MainViewModel
import org.koin.dsl.module


val appModule = module {

    // single instance of GeneralRepository
    single<GeneralRepository> { GeneralRepositoryImpl() }

    // single instance of MainViewModel to be shared between the fragments
    single { MainViewModel(get()) }
}