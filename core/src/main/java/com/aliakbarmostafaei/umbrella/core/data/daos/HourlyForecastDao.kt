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

package com.aliakbarmostafaei.umbrella.core.data.daos

import androidx.room.*
import com.aliakbarmostafaei.umbrella.core.data.models.HourlyForecastEntity

/*
Data access object for hourly forecast weather entities in the database
 */
@Dao
interface HourlyForecastDao {

    @Query("SELECT * FROM hourly_forecast_table WHERE locationId LIKE :id LIMIT 1")
    fun getHourlyForecastByCityId(id: Long): List<HourlyForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg forecastEntities: HourlyForecastEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg forecastEntities: HourlyForecastEntity)

    @Query("DELETE FROM hourly_forecast_table")
    fun clearTable()

    @Transaction
    fun insertEntities(vararg forecastEntities: HourlyForecastEntity) {
        clearTable()
        insert(*forecastEntities)
    }

    @Transaction
    fun updateEntities(vararg forecastEntities: HourlyForecastEntity) {
        clearTable()
        update(*forecastEntities)
    }
}