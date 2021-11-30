package com.cubidevs.examplemvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cubidevs.examplemvvm.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = MainFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(mainBinding) {
            sumarButton.setOnClickListener {
                viewModel.realizarSuma(
                    num1EditText.text.toString().toInt(),
                    num2EditText.text.toString().toInt()
                )
            }
        }

        viewModel.sumaDone.observe(viewLifecycleOwner, {
            mainBinding.totalTextView.text = it.toString()
        })

        return mainBinding.root
    }
}