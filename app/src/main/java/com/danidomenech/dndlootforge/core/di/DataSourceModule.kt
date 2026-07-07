package com.danidomenech.dndlootforge.core.di

import com.danidomenech.dndlootforge.data.local.source.HardcodedItemLocalDataSource
import com.danidomenech.dndlootforge.data.local.source.ItemLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindItemLocalDataSource(
        impl: HardcodedItemLocalDataSource
    ): ItemLocalDataSource
}