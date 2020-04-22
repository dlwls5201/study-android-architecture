package com.tistory.blackjin.domain

import org.junit.Before
import org.junit.Test

class GetReposUsecaseTest {

    @Before
    fun setup() {

    }

    @Test
    fun `test`() {

        var worker: Runnable = Worker()
        worker.run()

    }

}

interface Runnable {
    fun run()
}

open class Worker: Runnable {
    override fun run() {
       println("working")
    }
}

class HardWorker: Worker() {
    override fun run() {
        println("HardWorking")
    }
}
