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

package com.aliakbarmostafaei.umbrella.core.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Entity model representing hourly weather forecast data for local storage
 */
@Entity(tableName = "hourly_forecast_table")
data class HourlyForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Long,
    val locationId: Long,
    val weatherCondition: String,
    val epochTime: Long,
    val temperature: Double,
    val feelsLike: Double,
    val cloudCover: Int,
    val windSpeed: Double,
    val windDirection: String,
    val uvIndex: Double,
    val precipitation: Int
)