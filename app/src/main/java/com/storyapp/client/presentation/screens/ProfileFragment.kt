package com.storyapp.client.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.storyapp.client.R
import com.storyapp.client.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarStuff(savedInstanceState)
    }

    private fun toolBarStuff(savedInstanceState: Bundle?) {
        toolbar = binding.profileFragmentToolbar
        binding.profileToolbarTextView.text = "Hopeless Future"
        toolbar.setNavigationOnClickListener {
            if (savedInstanceState == null) {
                fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, MainFragment())?.commit()
            }
        }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.createNewStoryIcon -> {
                    Toast.makeText(requireContext(), "Clicked on create new story icon", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> super.onOptionsItemSelected(menuItem)
            }
        }
    }
}