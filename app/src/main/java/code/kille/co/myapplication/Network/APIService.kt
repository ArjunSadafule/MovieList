package code.kille.co.myapplication.Network

import code.kille.co.myapplication.Models.GenreList
import code.kille.co.myapplication.Models.MovieData
import code.kille.co.myapplication.Models.MovieList
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @GET(ApiUtils.GET_TYPE)
    fun getMoviesType(@Query("api_key") api_key: String): Call<GenreList>

    @GET(ApiUtils.GET_MOVIES_LISt + "{movie_id}" + "/movies")
    fun getMovieList(@Path("movie_id") movie_id: String, @Query("api_key") api_key: String): Call<MovieList>

    @GET(ApiUtils.GET_MOVIE_DATA + "{movie_id}")
    fun getMovieData(@Path("movie_id") movie_id: String, @Query("api_key") api_key: String): Call<MovieData>

}

