package adl.appture.shared.factory

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object HTTPClient {
    fun <T: Any> create(baseUrl: String, clazz: KClass<T>): T =
        provideRetrofit(baseUrl)
            .create(clazz.java)

    private fun provideRetrofit(baeUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(provideHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baeUrl)
            .build()
    }

    private fun provideHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}
