package moe.dazecake.logserver.service

import moe.dazecake.logserver.entity.LoggerEntity
import moe.dazecake.logserver.util.Result

interface LogService {

    fun getUUID(): Result<HashMap<String, String>>

    fun uploadLog(logger:LoggerEntity)
}