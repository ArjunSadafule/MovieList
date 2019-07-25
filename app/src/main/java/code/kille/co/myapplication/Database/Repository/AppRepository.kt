package code.kille.co.myapplication.Database.Repository

import android.app.Application
import code.kille.co.myapplication.Database.AppDatabase

internal open class AppRepository(application: Application) {
    var appDatabase: AppDatabase? = null

    init {
        appDatabase = AppDatabase.getInstance(application)
    }

    /**
     * Set with All Entity Repository
     */
    fun getCountryRepository(context: Application): CountryRepository {
        return CountryRepository(context)
    }

}

