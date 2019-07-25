package code.kille.co.myapplication.Utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson

class UtilsFiles {
    companion object {
         var mGson: Gson? = null

        fun getInstanceOfGSON(): Gson {
            if (mGson == null) {
                mGson = Gson()
            }
            return mGson as Gson
        }

        fun toJson(`object`: Any): String {
            return mGson!!.toJson(`object`)
        }

        fun getGson(): Gson? {
            return mGson
        }

        fun showToast(activity: Activity, msg: String) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }


        fun isNetworkAvailable(context: Context, showToast: Boolean): Boolean {
            val connectivityManager: ConnectivityManager
            var connected = false
            try {
                connectivityManager = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager
                    .activeNetworkInfo
                connected = (networkInfo != null && networkInfo.isAvailable
                        && networkInfo.isConnected)
                if (showToast && !connected) {
                    Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
                }
                return connected

            } catch (e: Exception) {
                Log.e("connectivity", e.toString())
            }

            return connected
        }
    }
}