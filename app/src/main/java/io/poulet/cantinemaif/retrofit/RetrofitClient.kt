package io.poulet.cantinemaif.retrofit

//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitClient {

    val webService: WebService by lazy {
//    val logging =  HttpLoggingInterceptor();
//    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//    val client =  OkHttpClient.Builder()
//    .addInterceptor(logging)
//    .build();
        Retrofit.Builder()
            .baseUrl("https://maif-solutions.moneweb.fr/")
//            .client(client)
            .build()
            .create(WebService::class.java)
    }
}
