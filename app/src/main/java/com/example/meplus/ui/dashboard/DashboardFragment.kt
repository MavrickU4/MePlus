package com.example.meplus.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.meplus.R
import com.example.meplus.databinding.FragmentDashboardBinding
import com.example.meplus.ui.photos.PhotosFragment

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var photosButton: Button

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        photosButton = root.findViewById(R.id.photosBtn)
        photosButton.setOnClickListener {
            val fragment = PhotosFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, fragment)
                .addToBackStack(null)
                .commit()
        }

        // Add click listener to root view to dismiss PhotosFragment when clicked outside
        root.setOnClickListener {
            val fragment = requireActivity().supportFragmentManager.findFragmentById(R.id.photos_container)
            if (fragment != null) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
                Toast.makeText(context, "dd", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
