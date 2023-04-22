package com.example.meplus.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.meplus.databinding.FragmentGamesBinding
import com.example.meplus.databinding.FragmentHomeBinding
import com.example.meplus.databinding.FragmentVideosBinding

class GamesFragment : Fragment() {

    private lateinit var binding: FragmentGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamesBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }
}
