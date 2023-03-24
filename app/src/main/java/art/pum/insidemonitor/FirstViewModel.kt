package art.pum.insidemonitor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    var _l1 : MutableLiveData<String> = MutableLiveData("0")
    val l1 : LiveData<String>
        get() = _l1


    var _l2 : MutableLiveData<String> = MutableLiveData("9")
    val l2 : LiveData<String>
        get() = _l2

}