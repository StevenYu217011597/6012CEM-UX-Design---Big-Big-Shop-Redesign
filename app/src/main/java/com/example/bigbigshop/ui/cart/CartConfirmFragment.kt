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
import com.example.bigbigshop.databinding.FragmentCartconfirmBinding

class CartConfirmFragment : Fragment() {

    private var _binding: FragmentCartconfirmBinding? = null

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

        _binding = FragmentCartconfirmBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val backBtn_toPromote : Button = root.findViewById(R.id.backBtn_toPromote)

        backBtn_toPromote.setOnClickListener { gotoPaymentMethodCart() }
        return root
    }

    private fun gotoPaymentMethodCart() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartPaymentMethodFragment())
            addToBackStack(CartConfirmFragment::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
