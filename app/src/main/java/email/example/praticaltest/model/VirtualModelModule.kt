package email.example.praticaltest.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class VirtualModelModule {
    @Provides
    @Singleton
    fun provideVirtualModel(virtualModelImpl: VirtualModelImpl): VirtualModel {
        return virtualModelImpl
    }
}