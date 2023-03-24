package art.pum.insidemonitor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import art.pum.insidemonitor.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    lateinit var firsViewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first,
            container,
            false)

        firsViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        binding.welcome = firsViewModel
        binding.lifecycleOwner = viewLifecycleOwner



        binding.go.setOnClickListener {
            Log.i("COUNTER", "${firsViewModel._l1.value!!} : ${firsViewModel._l2.value!!}")
            var action = FirstFragmentDirections.actionFirstFragmentToCounterFragment()
            action.s1 = firsViewModel._l1.value!!
            action.s2 = firsViewModel._l2.value!!

            findNavController().navigate(action)
        }

        return binding.root
    }

 }