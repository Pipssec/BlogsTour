package com.blogstour.data.di

import com.blogstour.data.ContentRepositoryImpl
import com.blogstour.domain.ContentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideContentRepo(impl : ContentRepositoryImpl) : ContentRepository

}