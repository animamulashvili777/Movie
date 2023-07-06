import com.example.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movies/popular")
    suspend fun getPopularMovies(
        @Query("b64e458ba573448c6e45c5eb775bb748") apiKey: String,
        @Query("page") page: Int
    ): Response<MovieResponse>
}
