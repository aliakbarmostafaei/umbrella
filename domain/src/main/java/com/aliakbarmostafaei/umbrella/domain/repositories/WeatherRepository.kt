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

package com.aliakbarmostafaei.umbrella.domain.repositories

import com.aliakbarmostafaei.umbrella.domain.base.Result
import com.aliakbarmostafaei.umbrella.domain.models.CurrentWeather
import com.aliakbarmostafaei.umbrella.domain.models.DailyForecast
import com.aliakbarmostafaei.umbrella.domain.models.HourlyForecast

/**
 * Repository interface declared in domain layer for IoC purposes
 */
interface WeatherRepository {

    /**
     * Method to get the current weather condition data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getCurrentWeatherByCoordinates(latitude: String, longitude: String, isImperial: Boolean):
            Result<CurrentWeather>

    /**
     * Method to get the current weather condition data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getCurrentWeatherByLocation(locationId: String, isImperial: Boolean): Result<CurrentWeather>

    /**
     * Method to get the daily weather forecast data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getDailyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Result<List<DailyForecast>>

    /**
     * Method to get the daily weather forecast data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getDailyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Result<List<DailyForecast>>

    /**
     * Method to get the hourly weather forecast data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getHourlyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Result<List<HourlyForecast>>

    /**
     * Method to get the hourly weather forecast data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getHourlyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Result<List<HourlyForecast>>
}