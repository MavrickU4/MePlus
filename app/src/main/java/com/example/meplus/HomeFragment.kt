package com.example.meplus

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.meplus.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

//        val logoutButton = binding.logoutBtn
//        logoutButton.setOnClickListener {
//            val intent = Intent(requireActivity(), LoginActivity::class.java)
//            Log.d("HomeFragment", "Logout button clicked")
//            Toast.makeText(requireContext(), "Logout button clicked", Toast.LENGTH_SHORT).show()
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//            requireActivity().finish()
//        }

        val logoutButton = binding.logoutBtn
        logoutButton.setOnClickListener {
            val intent = Intent(requireActivity(), LoginActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            requireActivity().finish()
        }

        val profileButton = binding.profileBtn
        profileButton.setOnClickListener {
            val fragment = ProfileFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, fragment)
                .addToBackStack(null)
                .commit()
        }


        return view
    }
}
