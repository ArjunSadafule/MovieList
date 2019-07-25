package code.kille.co.myapplication.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import code.kille.co.myapplication.Models.MovieData
import code.kille.co.myapplication.Network.AllAPIs
import code.kille.co.myapplication.Network.ApiUtils
import code.kille.co.myapplication.Network.Interface.GetMovieDataInterface
import code.kille.co.myapplication.R
import code.kille.co.myapplication.Utils.UtilsFiles
import com.bumptech.glide.Glide

class MovieDataActivity : AppCompatActivity(), GetMovieDataInterface {
    override fun onSuccess(value: MovieData) {
        setupData(value)
    }

    private fun setupData(value: MovieData) {
        Glide.with(this).load(ApiUtils.IMAGE_URL + value.getBackdropPath())
            .into(imageView)

        tvMovieName.setText(value.getTitle())
        tvLang.setText(value.getOriginalLanguage())
        rating.rating = value.getPopularity()!!.toFloat()

    }

    override fun onError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var rating: RatingBar
    private lateinit var imageView: ImageView
    private lateinit var tvMovieName: TextView
    private lateinit var tvLang: TextView
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_data)
        initView()

        val movieId = intent.extras.getString("movieId");
        if (UtilsFiles.isNetworkAvailable(this, true))
            AllAPIs.getMovieData(this, "68e82445c8842ba8616d0f6bf0e97a41", movieId,this, progressBar)

    }

    fun initView() {
        rating = findViewById(R.id.rating)
        imageView = findViewById(R.id.imageView)
        tvMovieName = findViewById(R.id.tvMovieName)
        tvLang = findViewById(R.id.tvLang)
        progressBar = findViewById(R.id.progressBar)


    }
}
