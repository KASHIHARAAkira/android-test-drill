package email.example.praticaltest.model

import javax.inject.Inject

class VirtualModelImpl @Inject constructor(): VirtualModel {
    override suspend fun concatStr(str1: String, str2: String): String {
        return str1 + str2
    }
}