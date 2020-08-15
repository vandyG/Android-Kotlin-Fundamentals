package com.example.android.trackmysleepquality.sleepdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepDatabase
import com.example.android.trackmysleepquality.databinding.FragmentSleepDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SleepDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SleepDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil
                .inflate<FragmentSleepDetailBinding>(inflater, R.layout.fragment_sleep_detail, container, false)

        val application = requireNotNull(activity).application
        val arguments = SleepDetailFragmentArgs.fromBundle(arguments)

        val dataSource = SleepDatabase.getInstance(application).sleepDatabaseDao

        val viewModelFactory = SleepDetailViewModelFactory(arguments.sleepNightKey, dataSource)
        val sleepDetailViewModel = ViewModelProvider(this, viewModelFactory)
                .get(SleepDetailViewModel::class.java)

        binding.sleepDetailViewModel = sleepDetailViewModel
        binding.lifecycleOwner = this

        sleepDetailViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    findNavController().navigate(SleepDetailFragmentDirections
                            .actionSleepDetailFragmentToSleepTrackerFragment())
                    sleepDetailViewModel.doneNavigating()
                }
            }
        })

        return binding.root
    }

}