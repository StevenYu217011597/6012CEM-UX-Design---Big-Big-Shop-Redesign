package com.example.bigbigshop.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

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

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val promotionBtn : ImageButton = root.findViewById(R.id.promotionBtn)
        val deleteBtn : ImageButton = root.findViewById(R.id.deleteBtn)
        val recoveryBtn : ImageButton = root.findViewById(R.id.recoveryBtn)
        val apple_pay1_chkbox : CheckBox = root.findViewById(R.id.apple_pay1_chkbox)
        val apple_pay2_chkbox : CheckBox = root.findViewById(R.id.apple_pay2_chkbox)
        val apple_pay1 : ImageView = root.findViewById(R.id.apple_pay1)
        val apple_pay2 : ImageView = root.findViewById(R.id.apple_pay2)
        val nextStepBtn : Button = root.findViewById(R.id.nextStepBtn)

        promotionBtn.setOnClickListener{ gotoPromotionFragment() }
        nextStepBtn.setOnClickListener{ gotoPaymentMethodFragment() }

        val repeatChkBx = root.findViewById<View>(R.id.selectAllCheckBox) as CheckBox
        repeatChkBx.setOnCheckedChangeListener { buttonView, isChecked ->
            if (repeatChkBx.isChecked) {
                apple_pay1_chkbox.setChecked(true);
                apple_pay2_chkbox.setChecked(true);
            }
            if (repeatChkBx.isChecked == false) {
                apple_pay1_chkbox.setChecked(false);
                apple_pay2_chkbox.setChecked(false);
            }
        }

        deleteBtn.setOnClickListener {
            apple_pay1.setVisibility(View.INVISIBLE)
            apple_pay1_chkbox.setVisibility(View.INVISIBLE)
            apple_pay2.setVisibility(View.INVISIBLE)
            apple_pay2_chkbox.setVisibility(View.INVISIBLE)
            repeatChkBx.setChecked(false)
        }

        recoveryBtn.setOnClickListener {
            apple_pay1.setVisibility(View.VISIBLE)
            apple_pay1_chkbox.setVisibility(View.VISIBLE)
            apple_pay2.setVisibility(View.VISIBLE)
            apple_pay2_chkbox.setVisibility(View.VISIBLE)
        }

        return root
    }

    private fun gotoPaymentMethodFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartPaymentMethodFragment())
            addToBackStack(FragmentCartBinding::class.java.name)
        }
    }

    private fun gotoPromotionFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CartPromoteFragment())
            addToBackStack(FragmentCartBinding::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}