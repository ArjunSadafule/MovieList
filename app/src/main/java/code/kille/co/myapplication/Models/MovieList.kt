package code.kille.co.myapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MovieList
{
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("page")
    @Expose
    private var page: Int? = null
    @SerializedName("results")
    @Expose
    private var results: List<MovieResultData>? = null
    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int? = null
    @SerializedName("total_results")
    @Expose
    private var totalResults: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getResults(): List<MovieResultData>? {
        return results
    }

    fun setResults(results: List<MovieResultData>) {
        this.results = results
    }

    fun getTotalPages(): Int? {
        return totalPages
    }

    fun setTotalPages(totalPages: Int?) {
        this.totalPages = totalPages
    }

    fun getTotalResults(): Int? {
        return totalResults
    }

    fun setTotalResults(totalResults: Int?) {
        this.totalResults = totalResults
    }
}