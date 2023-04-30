package ru.anb.fitnesskit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.anb.fitnesskit.adapter.TrainingAdapter
import ru.anb.fitnesskit.api.ApiResult
import ru.anb.fitnesskit.databinding.FragmentMainBinding
import ru.anb.fitnesskit.di.App

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var viewModel: ViewModelTraining

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            (activity?.application as App).provideViewModel(ViewModelTraining::class.java, this)

        val trainingAdapter = TrainingAdapter { viewModel.getTrainerById(it) }

        mBinding.trainingAdapter.adapter = trainingAdapter
        viewModel.liveData.observe(requireActivity()) {
            if (it is ApiResult.Success && it.data != null) {
                trainingAdapter.setData(it.data.lessons)
            } else {
                Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}