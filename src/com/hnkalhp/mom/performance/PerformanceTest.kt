package com.hnkalhp.mom.performance

import com.hnkalhp.momServer.ISubscriber
import com.hnkalhp.momServer.QueueManagerProxy
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class PerformanceTest {

    val DEFAULT_TOPIC = "default_test_topic"

    public fun performanceTest(numberOfRequests: Int = 100, preRequests: Int = 100): Array<Long> {
        test(preRequests)

        val testMetrics = test(numberOfRequests)

        return testMetrics
    }

    private fun test(num: Int) : Array<Long> {
        val sub: QueueManagerProxy = QueueManagerProxy(DEFAULT_TOPIC)
        val pub: QueueManagerProxy = QueueManagerProxy(DEFAULT_TOPIC)

        val initialTime = ArrayList<Date>(num)
        val finalTime = ArrayList<Date>(num)

        fun receiveMessage(message: String) {
            val testNumber = message.toInt()
            finalTime.add(testNumber, Date())
        }

        thread {
            sub.receive(object : ISubscriber {
                override fun receiveMessage(message: String) {
                    val testNumber = message.toInt()
                    finalTime.add(Date())
                }
            })
        }

        Thread.sleep(1000)

        for (testN in 0..(num - 1)) {
            initialTime.add(Date())
            pub.send(testN.toString())
        }


        // wait
        while (finalTime.size < num) {
            Thread.sleep(1000)
        }


        val resultTimes = ArrayList<Long>(num)
        for (N in 0..(num - 1)) {
            resultTimes[N] = finalTime[N].time - initialTime[N].time
        }

        return resultTimes.toArray() as Array<Long>
    }
}