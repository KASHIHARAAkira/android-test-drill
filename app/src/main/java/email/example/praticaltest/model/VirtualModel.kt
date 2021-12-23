package email.example.praticaltest.model

interface VirtualModel {
    suspend fun concatStr(str1: String, str2: String): String
}