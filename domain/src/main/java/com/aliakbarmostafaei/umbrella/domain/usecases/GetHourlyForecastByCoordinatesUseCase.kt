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

package com.aliakbarmostafaei.umbrella.domain.usecases

import com.aliakbarmostafaei.umbrella.domain.repositories.WeatherRepository

/**
 * Business application rule (usecase) for getting the hourly weather forecast data
 * for given coordinates
 * @param repository an instance of WeatherRepository to get the data
 */
class GetHourlyForecastByCoordinatesUseCase(private val repository: WeatherRepository) {

    /**
     * Method to get the hourly weather forecast data from the repository
     * @param latitude location's latitude coordinate
     * @param longitude location's longitude coordinate
     * @param isImperial request data in imperial unit format (default false)
     */
    operator fun invoke(latitude: String, longitude: String, isImperial: Boolean) =
        repository.getHourlyForecastByCoordinates(latitude, longitude, isImperial)
}