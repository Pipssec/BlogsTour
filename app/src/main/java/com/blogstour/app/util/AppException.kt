package com.blogstour.app.util


/**Sealed class for handling exception
 * @author E. Merkushev
 * */
sealed class AppException {
    data class NetworkExceptionErrorStatus(val errorResponse: ErrorResponse) :
        AppException()//use this for handling error from server

    data class NetworkException(val message: String) :
        AppException()// mostly used for invalid user data

    data class UnknownException(val message: String) : AppException()
    data class TransferException(val message: String) : AppException()

    /**use in transfer feature. When user try to transfer to card linked to same account*/
    data class SameAccountException(val message: String) : AppException()

    /**use in transfer feature. Currency doesn't match*/
    data class DifferentCurrencyException(val message: String) : AppException()
    data class TokenException(val message: String) : AppException()

    /**uses in cases when network response is null*/
    data class NullResponseBodyException(val message: String = NULL_RESPONSE_BODY_MESSAGE) :
        AppException()

    companion object {
        const val NULL_RESPONSE_BODY_MESSAGE = "Response body is null"
    }
}
