package com.storyapp.client.presentation.screens

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import com.storyapp.client.R
import com.storyapp.client.databinding.FragmentMainScreenBinding
import com.storyapp.client.presentation.screens.assistant.AssistantNavigation


class MainFragment: Fragment(), AssistantNavigation {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setNavigationDrawer()
        setMenuClickListenerToolbar()
        navigateToProfileScreen()
        navigateToAuthorizationScreen()
    }

    private fun init() {
        drawerLayout = binding.drawerLayout
        toolbar = binding.mainFragmentToolbar
        navigationView = binding.navigationView
    }

    private fun setMenuClickListenerToolbar() {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.filterStoriesIcon -> {
                    Toast.makeText(requireContext(), "Clicked on filter stories icon", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> super.onOptionsItemSelected(menuItem)
            }
        }
    }

    private fun setNavigationDrawer() {
        toggle = ActionBarDrawerToggle(requireActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun navigateToProfileScreen() {
        binding.apply {
            profileImageView.setOnClickListener {
                drawerLayout.closeDrawer(GravityCompat.START)
                navigateToSomeDestination(R.id.action_mainFragment_to_profileFragment)
            }
        }
    }

    private fun navigateToAuthorizationScreen() {
        binding.exitMainScreen.setOnClickListener {
            navigateToSomeDestination(R.id.action_mainFragment_to_authorizationFragment)
        }
    }

    override fun navigateToSomeDestination(destination: Int) {
        findNavController().navigate(destination)
    }

}