package email.example.praticaltest.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class VirtualModelImplTest {
    private val scope = CoroutineScope(Dispatchers.Default)

    //1
    @Test
    fun whenInputIsValid() {
        val virtualModelImpl = VirtualModelImpl()
        val str1 = "Hi!"
        val str2 = "I'm Akira."
        val result = runBlocking { virtualModelImpl.concatStr(str1, str2) }
        assertEquals(str1+str2, result)
    }

    //2
    @Test
    fun whenInput1only() {
        val virtualModelImpl = VirtualModelImpl()
        val str1 = "Hi!"
        val str2 = null
        val result = runBlocking { virtualModelImpl.concatStr(str1, str2) }
        assertEquals(str1, result)
    }

    //3
    @Test
    fun whenInput2only() {
        val virtualModelImpl = VirtualModelImpl()
        val str1 = null
        val str2 = "I'm Akira."
        val result = runBlocking { virtualModelImpl.concatStr(str1, str2) }
        assertEquals(str2, result)
    }

    //4
    @Test
    fun whenNull() {
        val virtualModelImpl = VirtualModelImpl()
        val str1 = null
        val str2 = null
        val result = runBlocking { virtualModelImpl.concatStr(str1, str2) }
        assertEquals("文字列が入力されていません", result)
    }
}