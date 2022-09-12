package com.example.bigbigshop.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentPaymentmethodBinding

class CartPaymentMethodFragment : Fragment() {

    private var _binding: FragmentPaymentmethodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CartViewModel =
            ViewModelProvider(this).get(CartViewModel::class.java)

        _binding = FragmentPaymentmethodBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val backBtn_cart : Button = root.findViewById(R.id.backBtn_cart)
        val nextButton_toConfirm : Button = root.findViewById(R.id.nextButton_toConfirm)

        backBtn_cart.setOnClickListener { backtoShoppingCart() }
        nextButton_toConfirm.setOnClickListener { gotoConfirmCart() }
        return root
    }

    private fun gotoConfirmCart() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartConfirmFragment())
            addToBackStack(CartPaymentMethodFragment::class.java.name)
        }
    }


    private fun backtoShoppingCart() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartFragment())
            addToBackStack(CartPaymentMethodFragment::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}