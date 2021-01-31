/*
 *     Copyright (C) 2021  Ali Akbar Mostafaei
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

package com.aliakbarmostafaei.umbrella.accuweather.domain.repositories

import com.aliakbarmostafaei.umbrella.core.data.base.ResultEntity
import com.aliakbarmostafaei.umbrella.core.models.CurrentWeather
import com.aliakbarmostafaei.umbrella.core.models.DailyForecast
import com.aliakbarmostafaei.umbrella.core.models.HourlyForecast

/**
 * Repository interface to centralize data retrieval
 */
interface WeatherRepository {

    /**
     * Method to get the current weather condition data from data sources(remote/local)
     * @param locationId location's id previously retrieved
     * @param language the language to request the data in (default en-us)
     */
    fun getCurrentConditions(locationId: String, language: String): ResultEntity<CurrentWeather>


    /**
     * Method to get the daily weather forecast data from data sources(remote/local)
     * @param locationId location's id previously retrieved
     * @param language the language to request the data in (default en-us)
     * @param isMetric request data in metric unit format (default false)
     */
    fun getDailyForecast(
        locationId: String,
        language: String,
        isMetric: Boolean,
    ): ResultEntity<List<DailyForecast>>

    /**
     * Method to get the hourly weather forecast data from data sources(remote/local)
     * @param locationId location's id previously retrieved
     * @param language the language to request the data in (default en-us)
     * @param isMetric request data in metric unit format (default false)
     */
    fun getHourlyForecast(
        locationId: String,
        language: String,
        isMetric: Boolean,
    ): ResultEntity<List<HourlyForecast>>
}