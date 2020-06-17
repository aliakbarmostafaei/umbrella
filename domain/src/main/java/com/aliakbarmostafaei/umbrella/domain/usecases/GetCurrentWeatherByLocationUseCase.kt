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
 * Business application rule (usecase) for getting the current weather condition data
 * for a given location ID
 * @param repository an instance of WeatherRepository to get the data
 */
class GetCurrentWeatherByLocationUseCase(private val repository: WeatherRepository) {

    /**
     * Method to get the current weather condition data from the repository
     * @param locationId the location's id retrieved previously from the remote API
     * @param isImperial request data in imperial unit format (default false)
     */
    operator fun invoke(locationId: String, isImperial: Boolean) =
        repository.getCurrentWeatherByLocation(locationId, isImperial)
}