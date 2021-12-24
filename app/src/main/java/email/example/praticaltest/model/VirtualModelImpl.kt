package email.example.praticaltest.model

import javax.inject.Inject

class VirtualModelImpl @Inject constructor(): VirtualModel {
    override suspend fun concatStr(str1: String?, str2: String?): String {
        if (str1 === null && str2 != null) {
            return str2
        } else if (str1 != null && str2 === null) {
            return str1
        } else if (str1 === null && str2 === null) {
            return "文字列が入力されていません"
        }
        return str1 + str2
    }
}