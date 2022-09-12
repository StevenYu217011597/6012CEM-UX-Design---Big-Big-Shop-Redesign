package com.example.bigbigshop.ui.catergories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentPetproductcatergoriesBinding

class PetProductCatergories : Fragment() {
    private var _binding: FragmentPetproductcatergoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPetproductcatergoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val backBtn_subCate : Button = root.findViewById(R.id.backBtn_subCate)

        backBtn_subCate.setOnClickListener { backtoSubCate() }
        return root
    }

    private fun backtoSubCate() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, SubCatergoriesFragment())
            addToBackStack(PetProductCatergories::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
