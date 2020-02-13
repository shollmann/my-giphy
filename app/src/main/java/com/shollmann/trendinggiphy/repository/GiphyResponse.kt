package com.shollmann.trendinggiphy.repository


data class ServiceResponse(
    val code: ResponseCode,
    var response: Any? = null,
    var lastUpdate: Long? = null,
    var errorMessage: String? = null
) {
    companion object {

        fun buildSuccessful(response: Any?): ServiceResponse {
            return ServiceResponse(ResponseCode.OK, response, System.currentTimeMillis())
        }

        fun buildNetworkError(message: String?): ServiceResponse {
            return ServiceResponse(ResponseCode.NETWORK_ERROR, errorMessage = message)
        }

        fun buildServiceError(message: String?): ServiceResponse {
            return ServiceResponse(ResponseCode.SERVICE_ERROR, errorMessage = message)
        }
    }

}

enum class ResponseCode {
    OK, NETWORK_ERROR, SERVICE_ERROR
}
