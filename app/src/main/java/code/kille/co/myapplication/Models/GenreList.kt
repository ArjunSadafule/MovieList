package code.kille.co.myapplication.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity
class GenreList {
    @SerializedName("genres")
    @Expose
    private var genres: List<Genre>? = null

    fun getGenres(): List<Genre>? {
        return genres
    }

    fun setGenres(genres: List<Genre>) {
        this.genres = genres
    }


}