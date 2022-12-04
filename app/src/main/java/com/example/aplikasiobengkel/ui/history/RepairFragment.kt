package com.example.aplikasiobengkel.ui.history


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiobengkel.databinding.FragmentRepairBinding
import com.example.aplikasiobengkel.ui.adapter.RepairAdapter


class RepairFragment() : Fragment() {
    private var _binding: FragmentRepairBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RepairAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory: HistoryViewModelFactory = HistoryViewModelFactory.getInstance(requireActivity().application)
        val viewModel: HistoryViewModel by viewModels {
            factory
        }

        viewModel.getAllRepair().observe(viewLifecycleOwner) { craneList ->
            if (craneList != null) {
                adapter.setListNotes(craneList)
            }
        }

        adapter = RepairAdapter()

        binding?.rvMechanic?.layoutManager = LinearLayoutManager(context)
        binding?.rvMechanic?.setHasFixedSize(true)
        binding?.rvMechanic?.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepairBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}