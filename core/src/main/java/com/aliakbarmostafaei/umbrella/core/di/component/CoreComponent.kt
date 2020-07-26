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

package com.aliakbarmostafaei.umbrella.core.di.component

import com.squareup.moshi.Moshi
import dagger.Component
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Component providing application wide singletons.
 * To call this make use of UmbrellaApplication.coreComponent or the
 * Activity.coreComponent extension function.
 */
@Component(modules = [CoreDataModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(): CoreComponent
    }

    fun provideOkHttpClient(): OkHttpClient
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun provideMoshi(): Moshi
    fun provideMoshiConverter(): MoshiConverterFactory
}