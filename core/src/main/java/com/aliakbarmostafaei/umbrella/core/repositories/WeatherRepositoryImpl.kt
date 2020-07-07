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

package com.aliakbarmostafaei.umbrella.core.repositories

import com.aliakbarmostafaei.umbrella.domain.base.Result
import com.aliakbarmostafaei.umbrella.domain.models.CurrentWeather
import com.aliakbarmostafaei.umbrella.domain.models.DailyForecast
import com.aliakbarmostafaei.umbrella.domain.models.HourlyForecast
import com.aliakbarmostafaei.umbrella.domain.repositories.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override fun getCurrentWeatherByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Result<CurrentWeather> {
        TODO("Not yet implemented")
    }

    override fun getCurrentWeatherByLocation(
        locationId: String,
        isImperial: Boolean
    ): Result<CurrentWeather> {
        TODO("Not yet implemented")
    }

    override fun getDailyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Result<List<DailyForecast>> {
        TODO("Not yet implemented")
    }

    override fun getDailyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Result<List<DailyForecast>> {
        TODO("Not yet implemented")
    }

    override fun getHourlyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Result<List<HourlyForecast>> {
        TODO("Not yet implemented")
    }

    override fun getHourlyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Result<List<HourlyForecast>> {
        TODO("Not yet implemented")
    }
}