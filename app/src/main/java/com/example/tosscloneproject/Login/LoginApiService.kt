package com.example.tosscloneproject.Login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tosscloneproject.Consumption.retrofit
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST
import java.lang.Exception

// Check PhoneNumber
interface CheckPhoneApiService {
    @POST("/api/v1/auth/existence-check")
    suspend fun checkPhoneNumber(@Body phoneRequest: PhoneRequest): Response<PhoneResponse>
}





// Login
class MyCookieJar : CookieJar {
    private val responseCookies = mutableListOf<Cookie>()
    private val requestCookies = mutableListOf<Cookie>()

    fun saveRequestCookie(cookie: Cookie) {
        requestCookies.add(cookie)
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        responseCookies.addAll(cookies)
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val validRequestCookies = requestCookies.filter { it.matches(url) }
        val validResponseCookies = responseCookies.filter { it.matches(url) }
        val result = validRequestCookies + validResponseCookies
        Log.d("MyCookieJar", "Returning cookies for $url: $result")
        return validRequestCookies + validResponseCookies
    }
}

val cookieJar = MyCookieJar()

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val originalRequest = chain.request()

            val requestWithCookies = originalRequest.newBuilder()
                .build()

            val response = chain.proceed(requestWithCookies)

            // 응답에서 쿠키 저장
            response.headers("Set-Cookie").forEach { rawCookie ->
                val cookie = Cookie.parse(originalRequest.url, rawCookie)
                if (cookie != null) {
                    cookieJar.saveFromResponse(originalRequest.url, listOf(cookie))
                }
            }

            return response
        }
    })
    .cookieJar(cookieJar)
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://pay-toss.kro.kr:8080")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface LoginApiService {
    @POST("/api/v1/auth")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableStateFlow<String?>(null)
    val loginResult: StateFlow<String?> get() = _loginResult

    fun loginUser(userPassword: String) {
        viewModelScope.launch {
        val loginApiService: LoginApiService = com.example.tosscloneproject.Login.retrofit.create(LoginApiService::class.java)

        try {
        val response = loginApiService.login(LoginRequest(userPassword))

            if (response.isSuccessful) {
                val responseBody = response.body()
                _loginResult.value = "Success"
                Log.d("LoginViewModel","success")
                Log.d("LoginViewModel", "Response: ${response}")
            } else {
                val responseBody = response.body()
                _loginResult.value = "Failed"
                Log.d("LoginViewModel","fail")
                Log.d("LoginViewModel", "Response: ${response}")
            }
        } catch (e: Exception) {
            // handle the failure
            _loginResult.value = "Failed"
            Log.d("LoginViewModel","catch")
        }
        }
    }

    fun resetLoginResult() {
        _loginResult.value = null
    }
}



// SignUp
interface SignUpApiService {
    @POST("/api/v1/auth/register")
    suspend fun signup(@Body newUser: NewUser): Response<User>
}

val signUpApiService = retrofit.create(SignUpApiService::class.java)



