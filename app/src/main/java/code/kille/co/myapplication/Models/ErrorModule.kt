package code.kille.co.myapplication.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ErrorModule
{
    @SerializedName("status_code")
    @Expose
    private var statusCode: Int? = null
    @SerializedName("status_message")
    @Expose
    private var statusMessage: String? = null

    fun getStatusCode(): Int? {
        return statusCode
    }

    fun setStatusCode(statusCode: Int?) {
        this.statusCode = statusCode
    }

    fun getStatusMessage(): String? {
        return statusMessage
    }

    fun setStatusMessage(statusMessage: String) {
        this.statusMessage = statusMessage
    }

}