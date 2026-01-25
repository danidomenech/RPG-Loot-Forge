package com.danidomenech.dndlootforge.di

import com.danidomenech.dndlootforge.data.repository.ItemRepository
import com.danidomenech.dndlootforge.data.repository.impl.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindItemRepository(
        impl: ItemRepositoryImpl
    ): ItemRepository
}