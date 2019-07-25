package code.kille.co.myapplication.Network.Interface;


import android.support.annotation.NonNull;
import code.kille.co.myapplication.Models.GenreList;
import code.kille.co.myapplication.Models.MovieData;
import code.kille.co.myapplication.Models.MovieList;

public interface GetMovieDataInterface {
    void onSuccess(@NonNull MovieData value);

    void onError(@NonNull Throwable throwable);
}
