package adl.appture.shared.factory

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

object HTTPClient {
    private fun provideRetrofit(okHttpClient: OkHttpClient, baeUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baeUrl)
            .build()
    }

    fun <T: Any> create(okHttpClient: OkHttpClient, baseUrl: String, clazz: KClass<T>): T =
        provideRetrofit(okHttpClient, baseUrl)
            .create(clazz.java)
}
