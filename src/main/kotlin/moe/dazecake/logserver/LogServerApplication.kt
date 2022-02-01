package moe.dazecake.logserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogServerApplication

fun main(args: Array<String>) {
    runApplication<LogServerApplication>(*args)
}
