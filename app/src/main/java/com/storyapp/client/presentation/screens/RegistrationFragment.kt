package com.storyapp.client.presentation.screens

import android.content.Context
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.storyapp.client.R
import com.storyapp.client.databinding.FragmentRegistrationBinding
import com.storyapp.client.presentation.screens.assistant.AssistantNavigation

class RegistrationFragment : Fragment(), AssistantNavigation {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private var myAnimation: Animation? = null
    private var proposalAnimation: Animation? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewsAnimation()
        setUnderlineToRegistrationLinkTextView()
        navigateToMainScreen()
        navigateToAuthorizationScreen()
    }

    private fun viewsAnimation() {
        myAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.views_animation)
        proposalAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.proposal_textview_animation)
        tieViewToAnimation(binding.appNameLogo)
        tieViewToAnimation(binding.registrationTextView)
        tieViewToAnimation(binding.cardView)
        tieViewToAnimation(binding.cardViewLinearLayout)
        tieViewToAnimation(binding.firstNameRegistrationTextView)
        tieViewToAnimation(binding.firstNameRegistrationEditText)
        tieViewToAnimation(binding.lastNameRegistrationTextView)
        tieViewToAnimation(binding.lastNameRegistrationEditText)
        tieViewToAnimation(binding.loginRegistrationTextView)
        tieViewToAnimation(binding.loginRegistrationEditText)
        tieViewToAnimation(binding.passwordRegistrationTextView)
        tieViewToAnimation(binding.passwordRegistrationEditText)
        tieViewToAnimation(binding.emailRegistrationTextView)
        tieViewToAnimation(binding.emailRegistrationEditText)
        tieViewToAnimation(binding.registrationButton)
        tieRegistrationTextViewToAnimation(binding.authorizationProposalTextView)
        tieRegistrationTextViewToAnimation(binding.authorizationLinkTextView)
    }

    private fun tieViewToAnimation(view: View) {
        view.startAnimation(myAnimation)
    }

    private fun tieRegistrationTextViewToAnimation(view: View) {
        view.startAnimation(proposalAnimation)
    }

    private fun setUnderlineToRegistrationLinkTextView() {
        val charSequence = getString(R.string.authorizationLinkText)
        var spannableString = SpannableString(charSequence)
        spannableString.setSpan(UnderlineSpan(), resources.getInteger(R.integer.zero), charSequence.length, resources.getInteger(R.integer.zero))
        binding.authorizationLinkTextView.text = spannableString
    }

    private fun navigateToMainScreen() {
        binding.registrationButton.setOnClickListener {
            navigateToSomeDestination(R.id.action_registrationFragment_to_mainFragment)
        }
    }

    private fun navigateToAuthorizationScreen() {
        binding.authorizationLinkTextView.setOnClickListener {
            navigateToSomeDestination(R.id.action_registrationFragment_to_authorizationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToSomeDestination(destination: Int) {
        findNavController().navigate(destination)
    }

}