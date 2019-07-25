package code.kille.co.myapplication.Models

import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



@Entity
class Genre
{
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }
}