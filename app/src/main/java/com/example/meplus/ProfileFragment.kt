package com.example.meplus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.meplus.databinding.FragmentProfileBinding
import com.example.meplus.database.DatabaseHelper


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // Initialize the database helper
        databaseHelper = DatabaseHelper(requireContext())

        val cursor = databaseHelper.readUser("user@example.com") // Replace with the user's email
        if (cursor != null && cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME))
            val email = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_EMAIL))

            // Set the name and email in the views
            binding.nameTextview.text = name
            binding.emailTextview.text = email
            val nameTextView = binding.nameTextview
            val name2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME))
            nameTextView.text = name2


        }
        cursor.close()

        return view
    }

}

