package com.cristianvillamil.platziwallet.ui.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view: HomeContract.View): HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()
    private val percentageLiveData: MutableLiveData<String> = MutableLiveData()

    override fun retrieveFavoriteTransfers(){
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallBack{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                // Class Singleton
                UserSingleton.getInstance().userName = "Hola"
                val user = User.Builder()
                    .setUserName("Jhon Carranza")
                    .setPassword("kajsoahdakda")
                    .build()
                percentageLiveData.value = "40%"
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }

    override fun getPercentageLiveData() : LiveData<String> = percentageLiveData

}