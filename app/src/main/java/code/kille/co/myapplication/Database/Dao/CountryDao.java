package code.kille.co.myapplication.Database.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import code.kille.co.myapplication.Models.Genre;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(Genre country);

    @Transaction
    @Query("SELECT * from Genre")
    LiveData<List<Genre>> getCustomerTableListLiveData();

    @Transaction
    @Query("SELECT * from Genre")
    List<Genre> getCustomerTableList();

    @Transaction
    @Query("Select * FROM Genre WHERE id  == :id")
    Genre getCustomerByCustomerId(Integer id);

    @Update
    int update(Genre onlineOffers);

    @Delete
    int delete(Genre onlineOffers);
}
