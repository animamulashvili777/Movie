import com.example.movie.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieService {
    private const val BASE_URL = "https://www.themoviedb.org/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: MovieApi = retrofit.create(MovieApi::class.java)

    suspend fun getPopularMovies(apiKey: String, page: Int): List<Movie> {
        val response = api.getPopularMovies(apiKey, page)
        if (response.isSuccessful) {
            val movieResponse = response.body()
            return movieResponse?.results ?: emptyList()
        } else {
            // Handle error response
            // You can display an error message or perform appropriate actions
            return emptyList()
        }
    }
}