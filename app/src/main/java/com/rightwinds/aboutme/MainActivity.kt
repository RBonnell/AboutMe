package com.rightwinds.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_done).setOnClickListener { addNickname(it) }
        findViewById<TextView>(R.id.txt_nickname).setOnClickListener { updateNickname(it) }
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.et_nickname)
        val nickNameTextView = findViewById<TextView>(R.id.txt_nickname)

        if (editText.text.isNotEmpty()) {
            nickNameTextView.text = editText.text

            editText.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
            view.visibility = View.GONE
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.et_nickname)
        val doneButton = findViewById<Button>(R.id.btn_done)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editText.requestFocus()
        editText.selectAll()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
