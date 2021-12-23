package email.example.praticaltest.repository

import email.example.praticaltest.model.VirtualModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val virtualModel: VirtualModel,
): UserRepository {
    override suspend fun concatStr(str1: String, str2: String): String {
        return virtualModel.concatStr(str1 = str1, str2 = str2)
    }
}