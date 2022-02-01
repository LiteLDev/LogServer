package moe.dazecake.logserver.service

import moe.dazecake.logserver.entity.LoggerEntity

interface LogService {
    fun uploadLog(logger:LoggerEntity)
}