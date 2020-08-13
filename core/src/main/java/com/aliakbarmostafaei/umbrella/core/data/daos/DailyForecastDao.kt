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
import com.aliakbarmostafaei.umbrella.core.data.models.DailyForecastEntity

/*
Data access object for daily forecast weather entities in the database
 */
@Dao
interface DailyForecastDao {

    @Query("SELECT * FROM daily_forecast_table WHERE locationId LIKE :id LIMIT 1")
    fun getDailyForecastByCityId(id: Long): List<DailyForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg forecastEntities: DailyForecastEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(vararg forecastEntities: DailyForecastEntity)

    @Query("DELETE FROM hourly_forecast_table")
    fun clearTable()

    @Transaction
    fun insertEntities(vararg forecastEntities: DailyForecastEntity) {
        clearTable()
        insert(*forecastEntities)
    }

    @Transaction
    fun updateEntities(vararg forecastEntities: DailyForecastEntity) {
        clearTable()
        update(*forecastEntities)
    }
}