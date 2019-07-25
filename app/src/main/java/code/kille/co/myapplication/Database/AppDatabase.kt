package code.kille.co.myapplication.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import code.kille.co.myapplication.Database.Dao.CountryDao
import code.kille.co.myapplication.Models.Genre

@Database(entities = [Genre::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (sInstance == null) {
                synchronized(AppDatabase::class.java) {
                    if (sInstance == null) {
                        sInstance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "app_database"
                        )
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this code lab.
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            //                           .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return sInstance
        }
    }
}
