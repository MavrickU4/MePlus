package com.example.meplus

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.meplus.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        val view = binding.root

        val addPhoto = binding.addPhoto
        addPhoto.setOnClickListener {
            Toast.makeText(requireContext(), "Add image button clicked - freature update coming soon!", Toast.LENGTH_SHORT).show()

            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
        return view
    }

    companion object {
        const val REQUEST_IMAGE_GET = 1
    }

}
