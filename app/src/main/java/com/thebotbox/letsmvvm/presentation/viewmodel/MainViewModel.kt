package com.thebotbox.letsmvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thebotbox.letsmvvm.data.network.model.RandomQuoteResponse
import com.thebotbox.letsmvvm.data.repository.IRepository
import kotlinx.coroutines.launch
import com.thebotbox.letsmvvm.util.ApiException
import com.thebotbox.letsmvvm.util.NoInternetException
import java.lang.Exception

class MainViewModel(
    private val iRepository: IRepository
) : ViewModel() {

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private val _fetchRandomQuoteLiveData: MutableLiveData<RandomQuoteResponse> = MutableLiveData()
    val fetchRandomQuoteLiveData: LiveData<RandomQuoteResponse>
        get() = _fetchRandomQuoteLiveData

    fun fetchQuoteFromServer() = viewModelScope.launch {
        try {
            _fetchRandomQuoteLiveData.value = iRepository.fetchRandomQuote()
        } catch (e: ApiException) {
            _errorLiveData.value = e.message
        } catch (e: NoInternetException) {
            _errorLiveData.value = e.message
        } catch (e: Exception) {
            _errorLiveData.value = e.message
        }
    }


    fun addQuoteToDB() = viewModelScope.launch {
        val randomQuote = _fetchRandomQuoteLiveData.value
        if (randomQuote != null) {
            iRepository.addQuoteToDB(randomQuote)
            _errorLiveData.value = "Saved to database"
        } else {
            _errorLiveData.value = "No Quote available to save."
        }
    }
}