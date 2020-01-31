package com.rightwinds.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rightwinds.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ellen Cook")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.btnDone.setOnClickListener { addNickname() }
        binding.txtNickname.setOnClickListener { updateNickname() }
    }

    private fun addNickname() {

        if (binding.etNickname.text.isNotEmpty()) {
            binding.apply {
                myName?.nickname = etNickname.text.toString()
                invalidateAll()
                binding.etNickname.visibility = View.GONE
                binding.txtNickname.visibility = View.VISIBLE
                binding.btnDone.visibility = View.GONE
            }
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.btnDone.windowToken, 0)
        }
    }

    private fun updateNickname() {

        binding.etNickname.visibility = View.VISIBLE
        binding.btnDone.visibility = View.VISIBLE
        binding.txtNickname.visibility = View.GONE
        binding.etNickname.requestFocus()
        binding.etNickname.selectAll()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etNickname, 0)
    }
}
