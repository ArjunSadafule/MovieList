package code.kille.co.myapplication.Network.Interface;


import android.support.annotation.NonNull;
import code.kille.co.myapplication.Models.GenreList;

public interface GetMovieTypeInterface {
    void onSuccess(@NonNull GenreList value);

    void onError(@NonNull Throwable throwable);
}
