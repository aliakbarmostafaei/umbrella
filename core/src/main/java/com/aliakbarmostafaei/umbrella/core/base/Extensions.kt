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

package com.aliakbarmostafaei.umbrella.core.base

import com.aliakbarmostafaei.umbrella.core.data.base.ResultEntity
import com.aliakbarmostafaei.umbrella.core.utils.ExceptionHandler
import io.reactivex.rxjava3.core.Single

fun <T> Single<T>.toResult(exceptionHandler: ExceptionHandler): Single<ResultEntity<T>> = this
    .map<ResultEntity<T>> { data -> ResultEntity.Success(data) }
    .onErrorReturn { throwable -> ResultEntity.Error(exceptionHandler.getErrorEntity(throwable)) }
