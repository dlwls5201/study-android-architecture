package com.tistory.mashuparchitecture

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)


        val user1 = User("BlackJin", 20)

        val user2 = User("BlackJin", 20, "seoul","010-xxxx-xxxx",Date())
    }

    class User(
        val name: String,
        val age: Int,
        val address: String? = null,
        val phoneNumber: String? = null,
        val birthday: Date? = null
        )
}
