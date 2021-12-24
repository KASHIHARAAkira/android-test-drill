package email.example.praticaltest.repository

interface UserRepository {
    suspend fun concatStr(str1: String?, str2: String?): String
}