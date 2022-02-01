package moe.dazecake.logserver.service.impl

import moe.dazecake.logserver.entity.LoggerEntity
import moe.dazecake.logserver.mapper.LoggerMapper
import moe.dazecake.logserver.service.LogService
import javax.annotation.Resource

class LogServiceImpl : LogService {

    @Resource
    lateinit var loggerMapper: LoggerMapper

    override fun uploadLog(logger: LoggerEntity) {
        loggerMapper.insert(logger)
    }
}