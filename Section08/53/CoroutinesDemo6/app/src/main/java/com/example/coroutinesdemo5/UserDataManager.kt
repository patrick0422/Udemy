package com.example.coroutinesdemo5

import kotlinx.coroutines.*

class UserDataManager {
    companion object {
        var count = 0
        lateinit var deffered: Deferred<Int>

        suspend fun getTotalUserCount(): Int {
            coroutineScope {
                launch(Dispatchers.IO) {
                    delay(1000)
                    count = 50
                }
                deffered = async(Dispatchers.IO) {
                    delay(3000)
                    return@async 70
                }
            }

            return count + deffered.await()
        }
    }
}