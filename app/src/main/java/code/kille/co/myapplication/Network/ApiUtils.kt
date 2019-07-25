package code.kille.co.myapplication.Network

class ApiUtils {

    companion object {


        const val API_KEY = "68e82445c8842ba8616d0f6bf0e97a41"
        const val IMAGE_URL="https://image.tmdb.org/t/p/original"

        const val DOMAIN_NAME = "https://api.themoviedb.org/"

        const val GET_TYPE = "3/genre/movie/list"
        const val GET_MOVIES_LISt = "3/genre/"///28/movies
        const val GET_MOVIE_DATA="3/movie/"

        fun getAPIService(): APIService {
            return ApiClient.getClient(DOMAIN_NAME)!!.create(
                APIService::class.java
            )
        }

    }

}
