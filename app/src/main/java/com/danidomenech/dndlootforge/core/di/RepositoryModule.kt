package com.danidomenech.dndlootforge.core.di

import com.danidomenech.dndlootforge.data.repository.ItemRepositoryImpl
import com.danidomenech.dndlootforge.domain.repository.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindItemRepository(
        impl: ItemRepositoryImpl
    ): ItemRepository
}