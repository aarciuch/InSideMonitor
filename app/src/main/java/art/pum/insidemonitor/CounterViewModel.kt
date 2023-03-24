package art.pum.insidemonitor

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterViewModel(private val start: Int, private val stop: Int) : ViewModel() {

    var name: MutableLiveData<Int> = MutableLiveData(0)


    @OptIn(DelicateCoroutinesApi::class)
    fun counter() {
        viewModelScope.launch(Dispatchers.Default) {
            for (i in start..stop-1) {
                name.postValue(name.value?.plus(1))
                delay(1000)
            }
        }
    }

    init {
        name.value = start
        Log.i("COUNTER", "${start} : ${stop}")
        counter()
    }

    override fun onCleared() {
        super.onCleared()
    }

    internal class CounterViewModelFactory(val start: Int, val stop: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CounterViewModel(start, stop) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}