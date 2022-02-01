package moe.dazecake.logserver.entity

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime

@TableName("log")
class LoggerEntity {
    @TableId
    var id: Long? = null

    var uuid:String?=null

    var ip: String? = null

    var log: String? = null

    var llVersion: String? = null

    var playerNum: Long? = null

    var createTime: LocalDateTime? = null

}