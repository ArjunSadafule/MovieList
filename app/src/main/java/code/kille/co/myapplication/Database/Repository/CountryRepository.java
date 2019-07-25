package code.kille.co.myapplication.Database.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;
import code.kille.co.myapplication.Database.Dao.CountryDao;
import code.kille.co.myapplication.Models.Genre;

import java.util.List;

public class CountryRepository extends AppRepository {
    public CountryDao customerDao;
    private LiveData<List<Genre>> customerTableListLiveData;
    private List<Genre> customerTableList;

    public CountryRepository(Application application) {
        super(application);
        customerDao = getAppDatabase().countryDao();
        customerTableListLiveData = customerDao.getCustomerTableListLiveData();
        customerTableList = customerDao.getCustomerTableList();
    }

    public LiveData<List<Genre>> getCustomerListLiveData() {
        return customerTableListLiveData;
    }

    public List<Genre> getCustomerList() {
        return customerTableList;
    }

    public Genre getCustomerByCustomerId(Integer id) {
        return customerDao.getCustomerByCustomerId(id);
    }


    //****************
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public Integer doOfferCrudOperation(Genre offer, int operationValue) {
        Integer newAsssessmentValue = null;
        try {
            Long receivedData = new doOnlineOfferCrudOperationAsyncTask(customerDao, operationValue).execute(offer).get();
            newAsssessmentValue = receivedData.intValue();
            return newAsssessmentValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newAsssessmentValue;

    }
    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.

    private static class doOnlineOfferCrudOperationAsyncTask extends AsyncTask<Genre, Void, Long> {
        private CountryDao mAsyncTaskDao;
        int operationValue;

        doOnlineOfferCrudOperationAsyncTask(CountryDao dao, int operationValue) {
            mAsyncTaskDao = dao;
            this.operationValue = operationValue;
        }

        @Override
        protected Long doInBackground(final Genre... params) {
            switch (operationValue) {
                case 0:
                    Long aLong = mAsyncTaskDao.insert(params[0]);
                    Log.e("Insert customer", "" + aLong);
                    return aLong;
                case 1:
                    return (long) mAsyncTaskDao.update(params[0]);
                case 2:
                    return (long) mAsyncTaskDao.delete(params[0]);
            }
            return null;
        }
    }
}
