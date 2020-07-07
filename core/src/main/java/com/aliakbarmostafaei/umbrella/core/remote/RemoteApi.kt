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

package com.aliakbarmostafaei.umbrella.core.remote

import io.reactivex.rxjava3.core.Single

interface RemoteApi {

    /**
     * Method to @GET the current weather condition data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getCurrentWeatherByCoordinates(latitude: String, longitude: String, isImperial: Boolean):
            Single<out CurrentWeatherDto>

    /**
     * Method to @GET the current weather condition data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getCurrentWeatherByLocation(
        locationId: String,
        isImperial: Boolean
    ): Single<out CurrentWeatherDto>

    /**
     * Method to @GET the daily weather forecast data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getDailyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Single<List<DailyForecastDto>>

    /**
     * Method to @GET the daily weather forecast data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getDailyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Single<List<DailyForecastDto>>

    /**
     * Method to @GET the hourly weather forecast data from data sources(remote/local)
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getHourlyForecastByCoordinates(
        latitude: String,
        longitude: String,
        isImperial: Boolean
    ): Single<List<HourlyForecastDto>>

    /**
     * Method to @GET the hourly weather forecast data from data sources(remote/local)
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    fun getHourlyForecastByLocation(
        locationId: String,
        isImperial: Boolean
    ): Single<List<HourlyForecastDto>>
}