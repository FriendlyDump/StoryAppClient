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
import com.storyapp.client.R
import com.storyapp.client.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

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
    }

    private fun viewsAnimation() {
        myAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.views_animation)
        proposalAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.proposal_textview_animation)
        tieViewsToAnimation(binding.appNameLogo)
        tieViewsToAnimation(binding.authorizationTextView)
        tieViewsToAnimation(binding.cardView)
        tieViewsToAnimation(binding.cardViewLinearLayout)
        tieViewsToAnimation(binding.loginAuthorizationTextView)
        tieViewsToAnimation(binding.loginAuthorizationEditText)
        tieViewsToAnimation(binding.passwordAuthorizationTextView)
        tieViewsToAnimation(binding.passwordAuthorizationEditText)
        tieViewsToAnimation(binding.authorizationButton)
        tieRegistrationTextViewToAnimation(binding.registrationProposalTextView)
        tieRegistrationTextViewToAnimation(binding.registrationLinkTextView)
    }

    private fun tieViewsToAnimation(view: View) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _bindind = null
    }

}