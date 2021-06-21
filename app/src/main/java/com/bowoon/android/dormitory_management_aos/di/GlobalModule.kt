package com.bowoon.android.dormitory_management_aos.di

import com.bowoon.android.dormitory_management_aos.component.navigation.NavigationGraphImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlobalModule {
    @Provides
    @Singleton
    fun provideNavigationGraph() = NavigationGraphImpl()

    @Provides
    @Singleton
    fun provideGson() = Gson()
}