package code.kille.co.myapplication.Network

import android.app.Activity
import android.support.annotation.Nullable
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import code.kille.co.myapplication.Models.ErrorModule
import code.kille.co.myapplication.Models.GenreList
import code.kille.co.myapplication.Models.MovieData
import code.kille.co.myapplication.Models.MovieList
import code.kille.co.myapplication.Network.Interface.GetMovieDataInterface
import code.kille.co.myapplication.Network.Interface.GetMovieListInterface
import code.kille.co.myapplication.Network.Interface.GetMovieTypeInterface
import code.kille.co.myapplication.Utils.UtilsFiles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class AllAPIs {
    companion object {

        lateinit var apiService: APIService


        fun getMovieType(
            activity: Activity,
            accessToken: String, @Nullable callbacks: GetMovieTypeInterface,
            progressBar: ProgressBar
        ) {
            apiService = ApiUtils.getAPIService()
            progressBar.visibility = View.VISIBLE

            apiService.getMoviesType(accessToken).enqueue(object : Callback<GenreList> {
                override fun onFailure(call: Call<GenreList>?, t: Throwable?) {
                    Log.e("Error: ", t.toString())
                    callbacks.onError(t!!)
                    progressBar.visibility = View.GONE
                    UtilsFiles.showToast(activity, t.message!!)
                }

                override fun onResponse(call: Call<GenreList>?, response: Response<GenreList>?) {
                    progressBar.visibility = View.GONE
                    if (response!!.isSuccessful() && response.code() == 200) {
                        callbacks.onSuccess(response.body()!!)

                    } else {
                        if (response.code() == 400 || response.code() == 401) {
                            try {
                                val errorResponse = UtilsFiles.getInstanceOfGSON()
                                    .fromJson(response.errorBody()!!.string(), ErrorModule::class.java)
                                UtilsFiles.showToast(activity, errorResponse.getStatusMessage()!!)
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }

                        } else
                            UtilsFiles.showToast(activity, "Internal Server Error")
                    }
                }
            }
            )

        }


        fun getMovieList(
            activity: Activity,
            accessToken: String,
            movieType: String, @Nullable callbacks: GetMovieListInterface,
            progressBar: ProgressBar
        ) {
            apiService = ApiUtils.getAPIService()
            progressBar.visibility = View.VISIBLE

            apiService.getMovieList(movieType, accessToken).enqueue(object : Callback<MovieList> {
                override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                    Log.e("Error: ", t.toString())
                    callbacks.onError(t!!)
                    progressBar.visibility = View.GONE
                    UtilsFiles.showToast(activity, t.message!!)
                }

                override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                    progressBar.visibility = View.GONE
                    if (response!!.isSuccessful() && response.code() == 200) {
                        callbacks.onSuccess(response.body()!!)

                    } else {
                        if (response.code() == 400 || response.code() == 401) {
                            try {
                                val errorResponse = UtilsFiles.getInstanceOfGSON()
                                    .fromJson(response.errorBody()!!.string(), ErrorModule::class.java)
                                UtilsFiles.showToast(activity, errorResponse.getStatusMessage()!!)
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }

                        } else
                            UtilsFiles.showToast(activity, "Internal Server Error")
                    }
                }
            }
            )

        }


        fun getMovieData(
            activity: Activity,
            accessToken: String,
            movieID: String, @Nullable callbacks: GetMovieDataInterface,
            progressBar: ProgressBar
        ) {
            apiService = ApiUtils.getAPIService()
            progressBar.visibility = View.VISIBLE

            apiService.getMovieData(movieID, accessToken).enqueue(object : Callback<MovieData> {
                override fun onFailure(call: Call<MovieData>?, t: Throwable?) {
                    Log.e("Error: ", t.toString())
                    callbacks.onError(t!!)
                    progressBar.visibility = View.GONE
                    UtilsFiles.showToast(activity, t.message!!)
                }

                override fun onResponse(call: Call<MovieData>?, response: Response<MovieData>?) {
                    progressBar.visibility = View.GONE
                    if (response!!.isSuccessful() && response.code() == 200) {
                        callbacks.onSuccess(response.body()!!)

                    } else {
                        if (response.code() == 400 || response.code() == 401) {
                            try {
                                val errorResponse = UtilsFiles.getInstanceOfGSON()
                                    .fromJson(response.errorBody()!!.string(), ErrorModule::class.java)
                                UtilsFiles.showToast(activity, errorResponse.getStatusMessage()!!)
                            } catch (e: IOException) {
                                e.printStackTrace()
                            }

                        } else
                            UtilsFiles.showToast(activity, "Internal Server Error")
                    }
                }
            }
            )

        }


    }
}