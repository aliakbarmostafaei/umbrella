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

package com.aliakbarmostafaei.umbrella.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aliakbarmostafaei.umbrella.core.local.daos.CurrentWeatherDao
import com.aliakbarmostafaei.umbrella.core.local.daos.DailyForecastDao
import com.aliakbarmostafaei.umbrella.core.local.daos.HourlyForecastDao
import com.aliakbarmostafaei.umbrella.core.local.models.CurrentWeatherEntity
import com.aliakbarmostafaei.umbrella.core.local.models.DailyForecastEntity
import com.aliakbarmostafaei.umbrella.core.local.models.HourlyForecastEntity

@Database(
    entities = [CurrentWeatherEntity::class,
        HourlyForecastEntity::class, DailyForecastEntity::class], version = 1
)
@TypeConverters(Converters::class)
abstract class UmbrellaDatabase : RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun hourlyForecastDao(): HourlyForecastDao
    abstract fun dailyForecastDao(): DailyForecastDao

    companion object {
        const val NAME = "UmbrellaDatabase.db"
    }
}