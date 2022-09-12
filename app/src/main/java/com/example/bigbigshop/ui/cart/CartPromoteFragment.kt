package com.example.bigbigshop.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentCartpromoteBinding


class CartPromoteFragment : Fragment() {

    private var _binding: FragmentCartpromoteBinding? = null

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

        _binding = FragmentCartpromoteBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val promoteShoppingCartBtn : ImageButton = root.findViewById(R.id.promoteShoppingCartBtn)

        promoteShoppingCartBtn.setOnClickListener { goBacktoShoppingCart() }
        return root
    }

    private fun goBacktoShoppingCart() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartFragment())
            addToBackStack(CartPromoteFragment::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}