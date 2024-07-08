package application.ports.outbound

interface Logging {

    fun info(
        key: String,
        data: Any?,
        method: String? = null,
        path: String? = null,
        statusCode: Int? = null,
    )

    fun warn(
        key: String,
        data: Any?,
        method: String? = null,
        path: String? = null,
        statusCode: Int? = null,
    )

    fun error(
        key: String,
        data: Any?,
        method: String? = null,
        path: String? = null,
        statusCode: Int? = null,
    )
}
