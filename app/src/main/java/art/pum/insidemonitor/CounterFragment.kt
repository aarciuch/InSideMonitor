package art.pum.insidemonitor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import art.pum.insidemonitor.databinding.FragmentCounterBinding



class CounterFragment : Fragment() {

    private lateinit var binding : FragmentCounterBinding
    private lateinit var counterViewModelFactory : CounterViewModel.CounterViewModelFactory
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_counter,
            container,
            false)


        val s1 = arguments?.getString("s1")
        val s2 = arguments?.getString("s2")
        Log.i("COUNTER", "${s1} : ${s2}")


        counterViewModelFactory = CounterViewModel.CounterViewModelFactory(s1!!.toInt(),s2!!.toInt())
        counterViewModel = ViewModelProvider(this, counterViewModelFactory).get(CounterViewModel::class.java)


        binding.licznik = counterViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }



}