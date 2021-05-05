package com.shareefoo.viledtask.di

import com.shareefoo.viledtask.repositories.GeneralRepository
import com.shareefoo.viledtask.repositories.GeneralRepositoryImpl
import com.shareefoo.viledtask.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    // single instance of GeneralRepository
    single<GeneralRepository> { GeneralRepositoryImpl() }

    // single instance of MainViewModel
    single { MainViewModel(get()) }
}