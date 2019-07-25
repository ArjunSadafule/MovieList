package code.kille.co.myapplication.Database.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.support.v4.app.FragmentActivity
import code.kille.co.myapplication.Database.Repository.AppRepository
import code.kille.co.myapplication.Models.Genre

import java.util.ArrayList

class CustomerViewModel(internal var application: Application) : AndroidViewModel(application) {
    private val appRepository: AppRepository
    val customerTableListLiveData: LiveData<List<Genre>>
    private val customerTableList: List<Genre>
    lateinit var lifecycleOwner: LifecycleOwner
    private val onlineOfferViewModel: CustomerViewModel? = null

    init {
        appRepository = AppRepository(application)
        customerTableListLiveData = appRepository.getCountryRepository(application).customerListLiveData
        customerTableList = appRepository.getCountryRepository(application).customerList
    }

    fun setLifecycleOwner(fragment: FragmentActivity) {
        this.lifecycleOwner = fragment
    }

    fun doCurdOperation(customerTable: Genre, operationValue: Int): Int? {
        return appRepository.getCountryRepository(application).doOfferCrudOperation(customerTable, operationValue)
    }

    fun getCustomerWithCustomerId(id: Int?): Genre {
        return appRepository.getCountryRepository(application).getCustomerByCustomerId(id)
    }

    fun getCustomerTableList(): List<Genre> {
        val onlineOffersList = ArrayList<Genre>()
        onlineOffersList.addAll(onlineOffersList)
        return onlineOffersList
    }

}
