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
import com.example.bigbigshop.databinding.FragmentSubcategoriesBinding

class SubCatergoriesFragment : Fragment() {
    private var _binding: FragmentSubcategoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSubcategoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val dogPetProductBtn : ImageButton = root.findViewById(R.id.dogPetProductBtn)
        val backBtn : Button = root.findViewById(R.id.backBtn)

        dogPetProductBtn.setOnClickListener{ gotoPetProductCatergories() }
        backBtn.setOnClickListener{ gotoCatergoriesFragment() }

        return root
    }

    private fun gotoCatergoriesFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, CatergoriesFragment())
            addToBackStack(SubCatergoriesFragment::class.java.name)
        }
    }

    private fun gotoPetProductCatergories() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, PetProductCatergories())
            addToBackStack(SubCatergoriesFragment::class.java.name)
        }
    }

}