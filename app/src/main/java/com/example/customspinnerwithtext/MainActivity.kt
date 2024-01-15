package com.example.customspinnerwithtext

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customspinnerwithtext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var selectList: List<String> = listOf("suraj","rajesh")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ArrayAdapter<String>(this,R.layout.simple_spinner_dropdown_item,selectList)
        binding.mainSpinner.setAdapter(adapter)

        binding.mainSpinner.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                val selectedItem = parent?.getItemAtPosition(position)

                        as? String

                if (selectedItem != null) {
                    Toast.makeText(this@MainActivity, selectedItem.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        })
    }
}