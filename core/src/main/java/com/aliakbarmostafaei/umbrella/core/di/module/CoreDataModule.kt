/*
 *     Copyright (C) 2020  Ali Akbar Mostafaei
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aliakbarmostafaei.umbrella.core.di.module

import android.content.Context
import androidx.room.Room
import com.aliakbarmostafaei.umbrella.core.BuildConfig
import com.aliakbarmostafaei.umbrella.core.di.scope.AppScope
import com.aliakbarmostafaei.umbrella.core.local.UmbrellaDatabase
import com.aliakbarmostafaei.umbrella.core.local.daos.CurrentWeatherDao
import com.aliakbarmostafaei.umbrella.core.local.daos.DailyForecastDao
import com.aliakbarmostafaei.umbrella.core.local.daos.HourlyForecastDao
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

/**
 * Dagger module to provide core data functionality.
 */
@Module
class CoreDataModule {

    @Provides
    @AppScope
    fun provideDatabase(context: Context): UmbrellaDatabase {
        return Room.databaseBuilder(context.applicationContext,
            UmbrellaDatabase::class.java, UmbrellaDatabase.NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @AppScope
    fun provideCurrentWeatherDao(database: UmbrellaDatabase): CurrentWeatherDao {
        return database.currentWeatherDao()
    }

    @Provides
    @AppScope
    fun provideHourlyForecastDao(database: UmbrellaDatabase): HourlyForecastDao {
        return database.hourlyForecastDao()
    }

    @Provides
    @AppScope
    fun provideDailyForecastDao(database: UmbrellaDatabase): DailyForecastDao {
        return database.dailyForecastDao()
    }

    @Provides
    @AppScope
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @AppScope
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @AppScope
    fun provideRxJava3Adapter(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())
    }
}