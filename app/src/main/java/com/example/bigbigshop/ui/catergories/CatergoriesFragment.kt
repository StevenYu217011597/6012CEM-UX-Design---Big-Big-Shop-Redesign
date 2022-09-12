package com.example.bigbigshop.ui.catergories

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
import com.example.bigbigshop.databinding.FragmentCategoriesBinding
import com.example.bigbigshop.ui.catergories.CatergoriesViewModel

class CatergoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val CatergoriesViewModel =
            ViewModelProvider(this).get(CatergoriesViewModel::class.java)

        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val petBtn : ImageButton = root.findViewById(R.id.petBtn)

        petBtn.setOnClickListener{ gotoSubCatergories() }
        return root

    }

    private fun gotoSubCatergories() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, SubCatergoriesFragment())
            addToBackStack(SubCatergoriesFragment::class.java.name)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


