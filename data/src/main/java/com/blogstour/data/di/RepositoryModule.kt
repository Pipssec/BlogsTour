package com.blogstour.data.di

import com.blogstour.data.ContentRepositoryImpl
import com.blogstour.domain.ContentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideContentRepo(impl : ContentRepositoryImpl) : ContentRepository

}