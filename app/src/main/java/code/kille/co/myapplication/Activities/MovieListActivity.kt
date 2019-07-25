package code.kille.co.myapplication.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.TextView
import code.kille.co.myapplication.Adapters.MovieListAdapter
import code.kille.co.myapplication.Models.MovieList
import code.kille.co.myapplication.Models.MovieResultData
import code.kille.co.myapplication.Network.APIService
import code.kille.co.myapplication.Network.AllAPIs
import code.kille.co.myapplication.Network.ApiUtils
import code.kille.co.myapplication.Network.Interface.GetMovieListInterface
import code.kille.co.myapplication.R
import code.kille.co.myapplication.Utils.UtilsFiles.Companion.isNetworkAvailable

class MovieListActivity : AppCompatActivity(), GetMovieListInterface {

    private lateinit var tvToolbarTitle: TextView
    private lateinit var rvList: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var movieAdapter: MovieListAdapter
    private lateinit var list: MutableList<MovieResultData>
    private var apiService: APIService? = null
    private lateinit var context: MovieListActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvList = findViewById(R.id.rvList)
        progressBar = findViewById(R.id.progressBar)
        tvToolbarTitle = findViewById(R.id.tvToolbarTitle)
        apiService = ApiUtils.getAPIService()
        context = this
        list = ArrayList()
        tvToolbarTitle.setText("Movies")
        val movieTypeId = intent!!.extras!!.getString("movieTypeId")
        rvList.layoutManager = LinearLayoutManager(this)

        if (isNetworkAvailable(context, true))
            AllAPIs.getMovieList(this, "68e82445c8842ba8616d0f6bf0e97a41", movieTypeId, this, progressBar)

    }

    override fun onSuccess(value: MovieList) {
        list.addAll(value.getResults()!!)
        movieAdapter = MovieListAdapter(context, list)
        rvList.adapter = movieAdapter
    }

    override fun onError(throwable: Throwable) {

    }


}
