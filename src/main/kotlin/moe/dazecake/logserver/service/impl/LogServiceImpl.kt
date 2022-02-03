package moe.dazecake.logserver.service.impl

import moe.dazecake.logserver.entity.LoggerEntity
import moe.dazecake.logserver.mapper.LoggerMapper
import moe.dazecake.logserver.service.LogService
import moe.dazecake.logserver.util.MD5
import moe.dazecake.logserver.util.Result
import moe.dazecake.logserver.util.Solution
import java.util.*
import javax.annotation.Resource
import kotlin.collections.HashMap


class LogServiceImpl : LogService {
    @Resource
    lateinit var solution: Solution

    @Resource
    lateinit var loggerMapper: LoggerMapper

    override fun getUUID(): Result<HashMap<String, String>> {
        var map = HashMap<String, String>()
        map["UUID"] = UUID.randomUUID().toString()
        map["token"] = MD5.encode(Date().time.toString() + "114514")
        solution.list[map["UUID"].toString()] = map["token"].toString()

        return Result.success(map, "success")
    }

    override fun uploadLog(logger: LoggerEntity) {
        loggerMapper.insert(logger)
    }
}