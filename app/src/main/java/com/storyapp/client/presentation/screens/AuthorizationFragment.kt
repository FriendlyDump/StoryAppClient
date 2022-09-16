package com.storyapp.client.presentation.screens

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.storyapp.client.R
import com.storyapp.client.databinding.FragmentAuthorizationBinding
import com.storyapp.client.presentation.screens.assistant.AssistantNavigation

class AuthorizationFragment : Fragment(), AssistantNavigation {

    private var _bindind: FragmentAuthorizationBinding? = null
    private val binding get() = _bindind!!

    private var myAnimation: Animation? = null
    private var proposalAnimation: Animation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindind = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewsAnimation()
        setUnderlineToRegistrationLinkTextView()
        navigateToMainScreen()
        navigateToRegistrationScreen()
    }

    private fun viewsAnimation() {
        myAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.views_animation)
        proposalAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.proposal_textview_animation)
        tieViewToAnimation(binding.appNameLogo)
        tieViewToAnimation(binding.authorizationTextView)
        tieViewToAnimation(binding.cardView)
        tieViewToAnimation(binding.cardViewLinearLayout)
        tieViewToAnimation(binding.loginAuthorizationTextView)
        tieViewToAnimation(binding.loginAuthorizationEditText)
        tieViewToAnimation(binding.passwordAuthorizationTextView)
        tieViewToAnimation(binding.passwordAuthorizationEditText)
        tieViewToAnimation(binding.authorizationButton)
        tieRegistrationTextViewToAnimation(binding.registrationProposalTextView)
        tieRegistrationTextViewToAnimation(binding.registrationLinkTextView)
    }

    private fun tieViewToAnimation(view: View) {
        view.startAnimation(myAnimation)
    }

    private fun tieRegistrationTextViewToAnimation(view: View) {
        view.startAnimation(proposalAnimation)
    }

    private fun setUnderlineToRegistrationLinkTextView() {
        val charSequence = getString(R.string.registrationProposalLinkText)
        var spannableString = SpannableString(charSequence)
        spannableString.setSpan(UnderlineSpan(), resources.getInteger(R.integer.zero), charSequence.length, resources.getInteger(R.integer.zero))
        binding.registrationLinkTextView.text = spannableString
    }

    private fun navigateToMainScreen() {
        binding.authorizationButton.setOnClickListener {
            navigateToSomeDestination(R.id.action_authorizationFragment_to_mainFragment)
        }
    }

    private fun navigateToRegistrationScreen() {
        binding.registrationLinkTextView.setOnClickListener {
            navigateToSomeDestination(R.id.action_authorizationFragment_to_registrationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindind = null
    }

    override fun navigateToSomeDestination(destination: Int) {
        findNavController().navigate(destination)
    }

}