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

package com.aliakbarmostafaei.umbrella.domain.base

/**
 * Responsible for representing different weather conditions since each API has different weather
 * condition codes and a unified, unique entity is necessary for determining the weather condition
 */
sealed class WeatherCondition {

    object Clear : WeatherCondition()
    object Clouds: WeatherCondition()
    object Rain: WeatherCondition()
    object Drizzle: WeatherCondition()
    object Thunderstorm: WeatherCondition()
    object Snow: WeatherCondition()
    object Mist: WeatherCondition()
    object Haze: WeatherCondition()
    object Fog: WeatherCondition()
    object Sand: WeatherCondition()
    object Dust: WeatherCondition()
    object Tornado: WeatherCondition()
    object Ash: WeatherCondition()
    object Squall: WeatherCondition()

}