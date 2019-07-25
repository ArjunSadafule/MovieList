package code.kille.co.myapplication.Adapters

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import code.kille.co.myapplication.Activities.MovieDataActivity
import code.kille.co.myapplication.Activities.MovieListActivity
import code.kille.co.myapplication.Models.MovieResultData
import code.kille.co.myapplication.Network.ApiUtils.Companion.IMAGE_URL
import code.kille.co.myapplication.R
import com.bumptech.glide.Glide

class MovieListAdapter(val mctx: Activity, val list: MutableList<MovieResultData>) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(mctx).inflate(R.layout.recyclerview_tasks, p0, false)
        return ViewHolder(view, list, mctx)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolderObject: ViewHolder, p1: Int) {

        viewHolderObject.tvMovieType.text = list[p1].getTitle()
        Glide.with(mctx).load(IMAGE_URL + list[p1].getPosterPath())
            .into(viewHolderObject.ivUser)

        //To change body of created functions use File | Settings | File Templates.

    }

    class ViewHolder(itemview: View, list: MutableList<MovieResultData>, mCtx: Activity) :
        RecyclerView.ViewHolder(itemview) {

        var tvMovieType: TextView = itemView.findViewById(R.id.tvName)
        var ivUser: ImageView = itemview.findViewById(R.id.ivUser)

        init {
            itemview.setOnClickListener {

                val intent = Intent(mCtx, MovieDataActivity::class.java)
                intent.putExtra("movieId", list[adapterPosition].getId().toString())
                mCtx.startActivity(intent)


            }
        }
    }
}