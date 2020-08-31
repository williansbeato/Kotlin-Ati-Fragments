package com.example.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import androidx.navigation.fragment.findNavController
import com.example.fragments.R
import kotlinx.android.synthetic.main.fragment_images.view.*

class fragment_images : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_images, container, false)

        view.im1.setOnClickListener { openImage(R.drawable.car) }
        view.im2.setOnClickListener { openImage(R.drawable.car1) }

        return view
    }

    private fun openImage(imageId:Int){
        val bundle = Bundle()
        bundle.putInt("imageId", imageId)
        findNavController().navigate(R.id.navigateToShowImage, bundle)

    }

}