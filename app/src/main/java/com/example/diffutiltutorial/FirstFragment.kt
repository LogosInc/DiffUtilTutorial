package com.example.diffutiltutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutiltutorial.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MyAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = myAdapter

        val person1 = Person(1, "John", 21)
        val person2 = Person(2, "Steve", 23)
        val person3 = Person(3, "Ann", 16)

        myAdapter.setData(listOf(person1, person2, person3))

        binding.addButton.setOnClickListener {
            val person4 = Person(4, "Hanna", 15)
            myAdapter.setData(listOf(person1, person2, person3, person4))
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}