package com.tweetsearchbyivan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tweetsearchbyivan.data.Datum
import com.tweetsearchbyivan.network.ApplicationApi
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.SocketTimeoutException

class SearchTweetsViewModel : ViewModel() {

    var res: String = "empty"
    // TODO: Implement the ViewModel

    private val _tweets = MutableLiveData<List<Datum>>()

    private val _selectedDatum = MutableLiveData<Datum>()

    val selectedDatum: LiveData<Datum>
        get() = _selectedDatum

    val tweets: LiveData<List<Datum>>
        get() = this._tweets

//    init {
//        searchTweet("banana")
//    }

    fun searchTweet(keyword: String) {
        viewModelScope.launch {
            try {
                var result = ApplicationApi.retrofitService
                try {
                    var listResult = result.searchTweet(ApplicationApi.getBearer(),
                        keyword = keyword
                    ).await()
                    if (listResult.data.size > 0) {
                        Log.i("response ", listResult.data.toString())
                        _tweets.value = listResult.data
                        var a = 2
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Log.i("response",result.toString())

            } catch (e: SocketTimeoutException) {
                e.printStackTrace()
            }
        }
    }

    fun displayTweet(it: Datum) {
        this._selectedDatum.value = it
        var a = 1
    }
}