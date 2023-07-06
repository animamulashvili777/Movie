import com.example.movie.api.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun createService(): MovieService {
        return retrofit.create(MovieService::class.java)
    }

}
