package com.androiddev.data.constant

import androidx.annotation.IntDef
import androidx.annotation.StringDef

object NetworkConstants {

    const val BASE_URL = "http://www.omdbapi.com/"

    //  const val BASE_URL = "http://www.omdbapi.com/?apikey=3e974fca&i={imdbID} "
    @IntDef(
        NETWORK_ERROR_CODES.BAD_REQUEST,
        NETWORK_ERROR_CODES.TIME_OUT,
        NETWORK_ERROR_CODES.INVALID_CREDENTIAL,
        NETWORK_ERROR_CODES.DEVICE_ID_NOT_FOUND,
        NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE,
        NETWORK_ERROR_CODES.MALFORMED_JSON,
        NETWORK_ERROR_CODES.NO_INTERNET,
        NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
        NETWORK_ERROR_CODES.HTML_RESPONSE_ERROR
    )

    @Retention(AnnotationRetention.SOURCE)
    annotation class NETWORK_ERROR_CODES {
        companion object {
            const val BAD_REQUEST = 400
            const val TIME_OUT = 408
            const val INVALID_CREDENTIAL = 401
            const val DEVICE_ID_NOT_FOUND = 404
            const val SERVICE_UNAVAILABLE = 500
            const val MALFORMED_JSON = 501
            const val NO_INTERNET = 502
            const val UNEXPECTED_ERROR = 503
            const val HTML_RESPONSE_ERROR = 504
        }
    }


    @StringDef(
        NETWORK_ERROR_MESSAGES.BAD_REQUEST,
        NETWORK_ERROR_MESSAGES.TIME_OUT,
        NETWORK_ERROR_MESSAGES.INVALID_CREDENTIAL,
        NETWORK_ERROR_MESSAGES.DEVICE_ID_NOT_FOUND,
        NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE,
        NETWORK_ERROR_MESSAGES.MALFORMED_JSON,
        NETWORK_ERROR_MESSAGES.NO_INTERNET,
        NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
    )

    @Retention(AnnotationRetention.SOURCE)
    annotation class NETWORK_ERROR_MESSAGES {
        companion object {
            const val BAD_REQUEST = "خطا در داده های دریافتی"
            const val TIME_OUT = "مشکلی در سامانه رخ داده است"
            const val INVALID_CREDENTIAL = "اطلاعات نامعتبر"
            const val DEVICE_ID_NOT_FOUND = "عدم اطلاعات کافی از کاربر"
            const val SERVICE_UNAVAILABLE =
                "سیستم موقتاً در دسترس نیست، لطفاً بعداً دوباره امتحان کنید"
            const val MALFORMED_JSON = "بعدا دوباره تلاش کنید"
            const val NO_INTERNET =
                "شما به شبکه وای فای یا داده تلفن همراه متصل نیستید. لطفاً وصل شوید و دوباره امتحان کنید"
            const val UNEXPECTED_ERROR = "خطای ناخواسته"
        }
    }
}
