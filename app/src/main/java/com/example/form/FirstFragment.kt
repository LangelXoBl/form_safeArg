package com.example.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.form.databinding.FragmentFirstBinding
import com.example.form.model.Person

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentFirstBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val name = _binding?.inputName?.text.toString()
            val lastName = _binding?.inputLastName?.text.toString()
            val age = _binding?.inputAge?.text.toString()
            if(name.isNullOrEmpty() && lastName.isNullOrEmpty() && age.isNullOrEmpty()){
                Toast.makeText(requireContext(), "inputs Required",Toast.LENGTH_SHORT ).show()
                return@setOnClickListener
            }
            val person = Person(name, lastName, age.toInt())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(person)
            findNavController().navigate(action)
        }
    }

    fun submitForm(){

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}