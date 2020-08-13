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

package com.aliakbarmostafaei.umbrella.core.utils

import com.aliakbarmostafaei.umbrella.core.data.base.ErrorEntity
import com.aliakbarmostafaei.umbrella.core.di.scope.AppScope
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

/**
 * Utility class for mapping common exceptions into their internally defined
 * entity counterparts for handling
 */
@AppScope
class ExceptionHandler @Inject constructor() {

    fun getErrorEntity(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is IOException -> ErrorEntity.NetworkUnavailable
            is HttpException -> {
                when (throwable.code()) {
                    // common client-side exceptions
                    HttpURLConnection.HTTP_BAD_REQUEST -> ErrorEntity.BadRequest
                    HttpURLConnection.HTTP_UNAUTHORIZED -> ErrorEntity.Unauthorized
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.Forbidden
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound
                    HttpURLConnection.HTTP_CLIENT_TIMEOUT -> ErrorEntity.RequestTimeout

                    // common server-side exceptions
                    HttpURLConnection.HTTP_INTERNAL_ERROR -> ErrorEntity.InternalServerError
                    HttpURLConnection.HTTP_BAD_GATEWAY -> ErrorEntity.BadGateway
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable
                    HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> ErrorEntity.GatewayTimeout

                    else -> ErrorEntity.Unknown
                }
            }
            else -> ErrorEntity.Unknown
        }
    }
}