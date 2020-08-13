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
import com.aliakbarmostafaei.umbrella.core.data.models.CurrentConditionsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/*
Data access object for current weather entities in the database
 */
@Dao
interface CurrentWeatherDao {

    @Query("SELECT * FROM current_weather_table")
    fun getAll(): Single<List<CurrentConditionsEntity>>

    @Query("SELECT * FROM current_weather_table WHERE locationId LIKE :id LIMIT 1")
    fun getWeatherByCityId(id: Long): Single<CurrentConditionsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherEntity(vararg currentConditionsEntities: CurrentConditionsEntity): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateWeatherEntity(vararg currentConditionsEntities: CurrentConditionsEntity): Completable

    @Delete
    fun deleteWeatherEntity(vararg currentConditionsEntities: CurrentConditionsEntity): Completable

    @Query("DELETE FROM current_weather_table")
    fun clearTable(): Completable
}