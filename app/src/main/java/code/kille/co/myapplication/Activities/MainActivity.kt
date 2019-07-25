package code.kille.co.myapplication.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.widget.ProgressBar
import android.widget.TextView
import code.kille.co.myapplication.Adapters.MovieAdapter
import code.kille.co.myapplication.Models.Genre
import code.kille.co.myapplication.Models.GenreList
import code.kille.co.myapplication.Network.APIService
import code.kille.co.myapplication.Network.AllAPIs
import code.kille.co.myapplication.Network.ApiUtils
import code.kille.co.myapplication.Network.Interface.GetMovieTypeInterface
import code.kille.co.myapplication.R
import code.kille.co.myapplication.Utils.UtilsFiles.Companion.isNetworkAvailable

class MainActivity : AppCompatActivity(), GetMovieTypeInterface {

    private lateinit var rvList: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var tvToolbarTitle: TextView
    private lateinit var list: MutableList<Genre>
    private var apiService: APIService? = null
    private lateinit var context: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvList = findViewById(R.id.rvList)
        progressBar = findViewById(R.id.progressBar)
        tvToolbarTitle = findViewById(R.id.tvToolbarTitle)
        apiService = ApiUtils.getAPIService()
        context = this
        list = ArrayList()
        tvToolbarTitle.setText("Select Movie Type")
        rvList.layoutManager = LinearLayoutManager(this)

        if (isNetworkAvailable(context, true))
            AllAPIs.getMovieType(this, "68e82445c8842ba8616d0f6bf0e97a41", this, progressBar)

    }

    override fun onSuccess(value: GenreList) {
        list.addAll(value.getGenres()!!)
        movieAdapter = MovieAdapter(context, list)
        rvList.adapter = movieAdapter
    }

    override fun onError(throwable: Throwable) {

    }

}
