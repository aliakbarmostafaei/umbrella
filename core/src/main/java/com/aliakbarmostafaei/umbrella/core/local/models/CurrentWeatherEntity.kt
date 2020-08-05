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

package com.aliakbarmostafaei.umbrella.core.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aliakbarmostafaei.umbrella.core.base.WeatherCondition
import com.aliakbarmostafaei.umbrella.core.base.WindDirection

/*
Entity model representing current weather data for local storage
 */
@Entity(tableName = "current_weather_table")
data class CurrentWeatherEntity(
    // Set location ID as primary key since we will only keep the latest weather
    // information for one location at a time and overwrite the old one
    @PrimaryKey
    val locationId: Long,
    val locationName: String,
    val weatherCondition: WeatherCondition,
    val weatherDescription: String,
    val temperature: Double,
    val feelsLike: Double,
    val humidity: Double,
    val precipitation: Int,
    val dewPoint: Double,
    val pressure: Double,
    val windSpeed: Double,
    val windDirection: WindDirection,
    val cloudCover: Int,
    val visibility: Double,
    val uvIndex: Double
)