package com.eloboostum

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<EloboostumApplication>().with(TestcontainersConfiguration::class).run(*args)
}
