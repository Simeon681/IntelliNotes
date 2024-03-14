package com.example.intellinotes

import com.example.intellinotes.RetrofitHost.EMULATOR
import com.example.intellinotes.repository.AuthRepository
import com.example.intellinotes.service.AuthService
import com.example.intellinotes.service.service_impl.AuthServiceImpl
import com.example.intellinotes.view_model.LoginViewModel
import com.example.intellinotes.view_model.MainViewModel
import com.example.intellinotes.view_model.RegisterViewModel
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single {
        SharedPreferencesInstance.apply {
            initSharedPreferences(androidContext())
        }
    }

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient().newBuilder()
            .addInterceptor(TokenInterceptor(get()))
            .addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    single {
        Gson()
    }
    single {
        val okHttpClient = get<OkHttpClient>()

        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(EMULATOR)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<AuthRepository> {
        get<Retrofit>().create(AuthRepository::class.java)
    }

    single<AuthService> { AuthServiceImpl(get(), get()) }

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { MainViewModel() }

    factory { MainApplication() }
}