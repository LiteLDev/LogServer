package moe.dazecake.logserver.util

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.*
import lombok.experimental.Accessors
import org.springframework.util.ObjectUtils
import java.io.Serializable

/**
 * 响应信息主体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
class Result<T> : Serializable {

    private var code: Int = 200

    private var msg: String? = null

    private var data: T? = null

    @get:JsonIgnore
    val isDataNull: Boolean
        get() = ObjectUtils.isEmpty(data)

    companion object {
        private const val serialVersionUID = 1L
        fun <T> success(): Result<T?> {
            return restResult(null, 200, null)
        }

        fun <T> success(data: T): Result<T> {
            return restResult(data, 200, null)
        }

        fun <T> success(data: T, msg: String?): Result<T> {
            return restResult(data, 200, msg)
        }

        fun <T> isSuccess(flag: Boolean): Result<T?> {
            return if (flag) success() else failed()
        }

        fun <T> failed(): Result<T?> {
            return restResult(null, 500, null)
        }

        fun <T> failed(code: Int, msg: String?): Result<T?> {
            return restResult(null, code, msg)
        }

        fun <T> failed(msg: String?): Result<T?> {
            return restResult(null, 500, msg)
        }

        fun <T> failed(msg: String?, data: T): Result<T> {
            return restResult(data, 500, msg)
        }

        fun <T> restResult(data: T, code: Int, msg: String?): Result<T> {
            val apiResult: Result<T> = Result<T>()
            apiResult.code = code
            apiResult.data = data
            apiResult.msg = msg
            return apiResult
        }
    }
}
