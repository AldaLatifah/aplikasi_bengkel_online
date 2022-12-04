package com.example.aplikasiobengkel.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.databinding.FragmentCraneBinding
import com.example.aplikasiobengkel.ui.adapter.CraneAdapter


class CraneFragment : Fragment() {
    private var _binding: FragmentCraneBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CraneAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory: HistoryViewModelFactory = HistoryViewModelFactory.getInstance(requireActivity().application)
        val viewModel: HistoryViewModel by viewModels {
            factory
        }

        viewModel.getAllCrane().observe(viewLifecycleOwner) { craneList ->
            if (craneList != null) {
                adapter.setListNotes(craneList)
            }
        }

        adapter = CraneAdapter()

        binding?.rvServiceStation?.layoutManager = LinearLayoutManager(context)
        binding?.rvServiceStation?.setHasFixedSize(true)
        binding?.rvServiceStation?.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCraneBinding.inflate(inflater, container, false)
        return binding.root
    }

//    private fun obtainViewModel(activity: AppCompatActivity): HistoryViewModel {
//        val factory = HistoryViewModelFactory.getInstance(requireActivity().application)
//        return ViewModelProvider(activity, factory).get(HistoryViewModel::class.java)
//    }


}