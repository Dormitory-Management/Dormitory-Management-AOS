package com.bowoon.android.dormitory_management_aos.di

import com.bowoon.android.dormitory_management_aos.api.Dormitory
import com.bowoon.android.dormitory_management_aos.api.DormitoryAPIImpl
import com.bowoon.android.network.createRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit() = createRetrofit<Dormitory>()

    @Provides
    @Singleton
    fun provideDormitoryApiImpl(dormitory: Dormitory) = DormitoryAPIImpl(dormitory)
}