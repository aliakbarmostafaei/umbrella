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

sealed class WindDirection {

    // Cardinal Direction       ---  Degrees Direction
    object N : WindDirection()      // 348.75 - 11.25
    object NNE : WindDirection()    // 11.25 - 33.75
    object NE : WindDirection()     // 33.75 - 56.25
    object ENE : WindDirection()    // 56.25 - 78.75
    object E : WindDirection()      // 78.75 - 101.25
    object ESE : WindDirection()    // 101.25 - 123.75
    object SE : WindDirection()     // 123.75 - 146.25
    object SSE : WindDirection()    // 146.25 - 168.75
    object S : WindDirection()      // 168.75 - 191.25
    object SSW : WindDirection()    // 191.25 - 213.75
    object SW : WindDirection()     // 213.75 - 236.25
    object WSW : WindDirection()    // 236.25 - 258.75
    object W : WindDirection()      // 258.75 - 281.25
    object WNW : WindDirection()    // 281.25 - 303.75
    object NW : WindDirection()     // 303.75 - 326.25
    object NNW : WindDirection()    // 326.25 - 348.75
}