package com.yunuskemalyazar.tabu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.yunuskemalyazar.tabu.databinding.ActivityConclusionBinding

class ConclusionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConclusionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityConclusionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            var gelenPuan = intent.getIntExtra("Puan",0)
            var gelenDogru = intent.getIntExtra("Doğru",0)
            var gelenTabu = intent.getIntExtra("Tabu",0)
            puan.text="Puan = ${gelenPuan}"
            tvTrue.text="Doğru = ${gelenDogru}"
            tvTabu.text="Tabu = ${gelenTabu}"
            btnDevam.setOnClickListener {
                var intent = Intent(this@ConclusionActivity,GameActivity::class.java)
                startActivity(intent)
                finish()
            }
            btnAnamenu.setOnClickListener {
                startActivity(Intent(this@ConclusionActivity,MainActivity::class.java))
                finish()
            }
            btnCikis.setOnClickListener {
                val uyarimesaji = AlertDialog.Builder(this@ConclusionActivity)
                uyarimesaji.setTitle("Çıkış")
                uyarimesaji.setMessage("Çıkmak istediğinize emin misiniz?")
                uyarimesaji.setPositiveButton("Evet", DialogInterface.OnClickListener{
                        dialogInterface, i ->
                    finish()
                })
                uyarimesaji.setNegativeButton("Hayır", DialogInterface.OnClickListener{
                        dialogInterface, i ->
                })
                uyarimesaji.show()
            }
            }
        }


    }