package code.kille.co.myapplication.Adapters

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import code.kille.co.myapplication.Activities.MovieListActivity
import code.kille.co.myapplication.Models.Genre
import code.kille.co.myapplication.R

class MovieAdapter(val mctx:Activity , val list : MutableList<Genre>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(mctx).inflate(R.layout.item_movie_type, p0, false)
        return ViewHolder(view, list, mctx)

    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.tvMovieType.text= list[p1].getName()
      /*  Glide.with(mctx).load("https://res.cloudinary.com/demo/image/upload/w_250,h_250,c_mpad/w_700/sample.jpg")
            .apply(
                RequestOptions()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
            )
            .into(p0.ivUser)*/

       //To change body of created functions use File | Settings | File Templates.

    }

    class ViewHolder(itemview: View, list : MutableList<Genre> , mCtx : Activity)  : RecyclerView.ViewHolder(itemview) {

        var  tvMovieType : TextView = itemView.findViewById(R.id.tvMovieType)
      //  var  tvName : TextView = itemview.findViewById(R.id.tvName)

        init {
            itemview.setOnClickListener {
                val intent = Intent(mCtx,MovieListActivity::class.java)
                intent.putExtra("movieTypeId",list[adapterPosition].getId().toString())
                mCtx.startActivity(intent)
              //  Toast.makeText(mCtx, "Pos = $adapterPosition",Toast.LENGTH_SHORT).show()
                 }
        }
    }
}