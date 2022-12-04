package com.cristianvillamil.platziwallet.ui.loans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoansViewModel: ViewModel() {
    private var percentageLiveData : MutableLiveData<String> = MutableLiveData()
    private var loansListLivaData : MutableLiveData<List<Loan>> = MutableLiveData()

    fun changeValues(){
        percentageLiveData.value = "100%"
        loansListLivaData.value = emptyList()
    }

    fun getPercentageLiveData() : LiveData<String> = percentageLiveData
    fun getLoansListLivaData() : LiveData<List<Loan>> = loansListLivaData

    override fun onCleared() {
        super.onCleared()
    }

}