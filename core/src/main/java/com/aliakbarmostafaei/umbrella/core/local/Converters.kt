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

import androidx.room.TypeConverter
import com.aliakbarmostafaei.umbrella.core.base.WeatherCondition
import com.aliakbarmostafaei.umbrella.core.base.WindDirection

class Converters {

    /*
    Type converters for WeatherCondition
     */
    @TypeConverter
    fun weatherConditionToString(weatherCondition: WeatherCondition): String =
        when (weatherCondition) {
            WeatherCondition.Clear -> "Clear"
            WeatherCondition.Clouds -> "Clouds"
            WeatherCondition.Rain -> "Rain"
            WeatherCondition.Drizzle -> "Drizzle"
            WeatherCondition.Thunderstorm -> "Thunderstorm"
            WeatherCondition.Snow -> "Snow"
            WeatherCondition.Mist -> "Mist"
            WeatherCondition.Haze -> "Haze"
            WeatherCondition.Fog -> "Fog"
            WeatherCondition.Sand -> "Fog"
            WeatherCondition.Dust -> "Dust"
            WeatherCondition.Tornado -> "Tornado"
            WeatherCondition.Ash -> "Ash"
            WeatherCondition.Squall -> "Squall"
            WeatherCondition.Unknown -> "Unknown"
        }

    @TypeConverter
    fun stringToWeatherCondition(string: String): WeatherCondition =
        when (string) {
            "Clear" -> WeatherCondition.Clear
            "Clouds" -> WeatherCondition.Clouds
            "Rain" -> WeatherCondition.Rain
            "Drizzle" -> WeatherCondition.Drizzle
            "Thunderstorm" -> WeatherCondition.Thunderstorm
            "Snow" -> WeatherCondition.Snow
            "Mist" -> WeatherCondition.Mist
            "Haze" -> WeatherCondition.Haze
            "Fog" -> WeatherCondition.Fog
            "Sand" -> WeatherCondition.Sand
            "Dust" -> WeatherCondition.Dust
            "Tornado" -> WeatherCondition.Tornado
            "Ash" -> WeatherCondition.Ash
            "Squall" -> WeatherCondition.Squall
            else -> WeatherCondition.Unknown
        }

    /*
    Type converters for WindDirection
     */
    @TypeConverter
    fun windDirectionToString(windDirection: WindDirection): String =
        when (windDirection) {
            WindDirection.N -> "N"
            WindDirection.NNE -> "NNE"
            WindDirection.NE -> "NE"
            WindDirection.ENE -> "ENE"
            WindDirection.E -> "E"
            WindDirection.ESE -> "ESE"
            WindDirection.SE -> "SE"
            WindDirection.SSE -> "SSE"
            WindDirection.S -> "S"
            WindDirection.SSW -> "SSW"
            WindDirection.SW -> "SW"
            WindDirection.WSW -> "WSW"
            WindDirection.W -> "W"
            WindDirection.WNW -> "WNW"
            WindDirection.NW -> "NW"
            WindDirection.NNW -> "NNW"
            WindDirection.Unknown -> "Unknown"
        }

    @TypeConverter
    fun stringToWindDirection(string: String): WindDirection =
        when (string) {
            "N" -> WindDirection.N
            "NNE" -> WindDirection.NNE
            "NE" -> WindDirection.NE
            "ENE" -> WindDirection.ENE
            "E" -> WindDirection.E
            "ESE" -> WindDirection.ESE
            "SE" -> WindDirection.SE
            "SSE" -> WindDirection.SSE
            "S" -> WindDirection.S
            "SSW" -> WindDirection.SSW
            "SW" -> WindDirection.SW
            "WSW" -> WindDirection.WSW
            "W" -> WindDirection.W
            "WNW" -> WindDirection.WNW
            "NW" -> WindDirection.NW
            "NNW" -> WindDirection.NNW
            else -> WindDirection.Unknown
        }
}