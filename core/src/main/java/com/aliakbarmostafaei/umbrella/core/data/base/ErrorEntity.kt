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

package com.aliakbarmostafaei.umbrella.core.data.base

/**
 * Sealed class representing error entities, along with their respective HTTP error codes
 * More info: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
 */
sealed class ErrorEntity {

    // Common client-side errors
    object BadRequest : ErrorEntity() // 400
    object Unauthorized : ErrorEntity() // 401
    object Forbidden : ErrorEntity() // 403
    object NotFound : ErrorEntity() // 404
    object RequestTimeout : ErrorEntity() // 408

    // Common server-side errors
    object InternalServerError : ErrorEntity() // 500
    object BadGateway : ErrorEntity() // 502
    object ServiceUnavailable : ErrorEntity() // 503
    object GatewayTimeout : ErrorEntity() // 504

    object NetworkUnavailable : ErrorEntity() // No internet connection
    object Unknown : ErrorEntity()
}