package email.example.praticaltest.model

import javax.inject.Inject

class VirtualModelImpl @Inject constructor(): VirtualModel {
    override suspend fun concatStr(str1: String, str2: String): String {
        if(str1 == "" && str2 == "") {
            return "文字列が入力されていません"
        } else {
            return str1 + str2
        }
    }
}