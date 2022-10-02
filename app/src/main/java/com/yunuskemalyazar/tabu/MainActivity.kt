package com.yunuskemalyazar.tabu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yunuskemalyazar.tabu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnNewgame.setOnClickListener {
                startActivity(Intent(this@MainActivity,GameActivity::class.java))
                finish()
            }
            btnOynanis.setOnClickListener {
                startActivity(Intent(this@MainActivity,OynanisActivity::class.java))
            }
        }
    }
}