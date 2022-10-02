package com.yunuskemalyazar.tabu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AlertDialog
import com.yunuskemalyazar.tabu.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGameBinding
    var skor = 0
    var dogrutık = 0
    var tabutık = 0
    var check = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            yazı()

            btnTrue.setOnClickListener {
                skor++
                puan.text="Puan = ${skor}"
                dogrutık++
                yazı()

            }
            btnTabu.setOnClickListener {
                skor=skor-2
                puan.text="Puan = ${skor}"
                tabutık++
                yazı()
            }
            var hak = 3
            pas.setOnClickListener {
                if (pashak.text == "0"){
                    pashak.text="0"
                }else {
                    hak--
                    pashak.text = "${hak}"
                    yazı()
                }

            }

           object : CountDownTimer(60000,1000){
                override fun onTick(p0: Long) {
                    tvTime.text = "" + p0/1000
                }
                override fun onFinish() {
                    var intent = Intent(this@GameActivity,ConclusionActivity::class.java)
                    intent.putExtra("Puan",skor)
                    intent.putExtra("Doğru",dogrutık)
                    intent.putExtra("Tabu",tabutık)
                    if(check == false){
                        startActivity(intent)
                        finish()
                    }
                }
            }.start()
            imgBack.setOnClickListener {
                val uyarimesaji = AlertDialog.Builder(this@GameActivity)
                uyarimesaji.setTitle("Çıkış")
                uyarimesaji.setMessage("Çıkmak istediğinize emin misiniz?")
                uyarimesaji.setPositiveButton("Evet",DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    check = true
                    startActivity(Intent(this@GameActivity,MainActivity::class.java))
                    finish()
                })
                uyarimesaji.setNegativeButton("Hayır",DialogInterface.OnClickListener{
                    dialogInterface, i ->
                })
                uyarimesaji.show()
            }

        }
    }
    override fun onBackPressed() {
        val uyarimesaji = AlertDialog.Builder(this@GameActivity)
        uyarimesaji.setTitle("Çıkış")
        uyarimesaji.setMessage("Çıkmak istediğinize emin misiniz?")
        uyarimesaji.setPositiveButton("Evet",DialogInterface.OnClickListener{
                dialogInterface, i ->
            check = true
            startActivity(Intent(this@GameActivity,MainActivity::class.java))
            finish()
        })
        uyarimesaji.setNegativeButton("Hayır",DialogInterface.OnClickListener{
                dialogInterface, i ->
        })
        uyarimesaji.show()
    }
    fun yazı (){
        binding.apply {
            var tık = (1..102).random()
            if (tık == 1) {
                btnIsim.text = "KİVİ"
                isim1.text = "EKŞİ"
                isim2.text = "MEYVE"
                isim3.text = "YEŞİL"
                isim4.text = "TÜYLÜ"
                isim5.text = "KARADENİZ"
            } else if (tık == 2) {
                btnIsim.text = "BECERMEK"
                isim1.text = "BOZMAK"
                isim2.text = "ÜSTESİNDEN GELMEK"
                isim3.text = "YAPMAK"
                isim4.text = "ÇÖZMEK"
                isim5.text = "ÜST"
            } else if (tık == 3) {
                btnIsim.text = "FERYAT"
                isim1.text = "BAĞIRMA"
                isim2.text = "FİGAN"
                isim3.text = "ÇIĞLIK"
                isim4.text = "HAYKIRMA"
                isim5.text = "DİKKAT ÇEKME"
            } else if (tık == 4) {
                btnIsim.text = "FLÖRT"
                isim1.text = "SEVGİ"
                isim2.text = "İLİŞKİ"
                isim3.text = "BAKIŞ"
                isim4.text = "ERKEK"
                isim5.text = "KADIN"
            } else if (tık == 5) {
                btnIsim.text = "DOLAP"
                isim1.text = "AÇILMAK"
                isim2.text = "TUTMAK"
                isim3.text = "KAPAK"
                isim4.text = "MUTFAK"
                isim5.text = "RAF"
            } else if (tık == 6) {
                btnIsim.text = "EVLENMEK"
                isim1.text = "ERKEK"
                isim2.text = "KADIN"
                isim3.text = "NİKAH"
                isim4.text = "BERABER"
                isim5.text = "EV"
            } else if (tık == 7) {
                btnIsim.text = "TRAVESTİ"
                isim1.text = "ERKEK"
                isim2.text = "KADIN OLMAK"
                isim3.text = "TRANS"
                isim4.text = "KILIK"
                isim5.text = "CİNSİYET"
            } else if (tık == 8) {
                btnIsim.text = "AYRINTI"
                isim1.text = "PARÇA"
                isim2.text = "DETAY"
                isim3.text = "TEFERRUAT"
                isim4.text = "ŞEYTAN"
                isim5.text = "TAKILMAK"
            } else if (tık == 9) {
                btnIsim.text = "YUNUS"
                isim1.text = "BALIK"
                isim2.text = "DENİZ"
                isim3.text = "YAKIŞIKLI"
                isim4.text = "YÜZME"
                isim5.text = "GÜZEL"
            } else if (tık == 10) {
                btnIsim.text = "ELMA"
                isim1.text = "ARMUT"
                isim2.text = "MEYVE"
                isim3.text = "KIRMIZI"
                isim4.text = "YEŞİL"
                isim5.text = "EKŞİ"
            } else if (tık == 11) {
                btnIsim.text = "DAVA"
                isim1.text = "SUÇ"
                isim2.text = "HAKİM"
                isim3.text = "MAHKEME"
                isim4.text = "MÜVEKKİL"
                isim5.text = "YARGI"
            } else if (tık == 12) {
                btnIsim.text = "DEPREM"
                isim1.text = "FAY"
                isim2.text = "SALLANMA"
                isim3.text = "EV"
                isim4.text = "BİNA"
                isim5.text = "YIKILMAK"
            } else if (tık == 14) {
                btnIsim.text = "KIRINTI"
                isim1.text = "UFAK"
                isim2.text = "PARÇA"
                isim3.text = "EKMEK"
                isim4.text = "KALINTI"
                isim5.text = "MASA"
            } else if (tık == 15) {
                btnIsim.text = "KOMA"
                isim1.text = "HASTA"
                isim2.text = "GİRMEK"
                isim3.text = "BİLİNÇ"
                isim4.text = "YATMAK"
                isim5.text = "UYUMAK"
            } else if (tık == 16) {
                btnIsim.text = "MISIR"
                isim1.text = "PİRAMİT"
                isim2.text = "ÜLKE"
                isim3.text = "NİL"
                isim4.text = "PATLAMIŞ"
                isim5.text = "SARI"
            } else if (tık == 17) {
                btnIsim.text = "YATAKHANE"
                isim1.text = "YATMAK"
                isim2.text = "YURT"
                isim3.text = "ASKER"
                isim4.text = "KOĞUŞ"
                isim5.text = "KIŞLA"
            } else if (tık == 18) {
                btnIsim.text = "ŞARJ ALETİ"
                isim1.text = "KABLO"
                isim2.text = "TELEFON"
                isim3.text = "DOLDURMAK"
                isim4.text = "BATARYA"
                isim5.text = "BİTİRMEK"
            } else if (tık == 19) {
                btnIsim.text = "ZIRH"
                isim1.text = "KALKAN"
                isim2.text = "SAVAŞ"
                isim3.text = "SAVUNMAK"
                isim4.text = "GİYMEK"
                isim5.text = "DEMİR"
            } else if (tık == 20) {
                btnIsim.text = "FREN"
                isim1.text = "ARABA"
                isim2.text = "DURMAK"
                isim3.text = "YAVAŞLAMAK"
                isim4.text = "SIKMAK"
                isim5.text = "BASMAK"
            } else if (tık == 21) {
                btnIsim.text = "ARMUT"
                isim1.text = "YEŞİL"
                isim2.text = "ELMA"
                isim3.text = "AMPUL"
                isim4.text = "MEYVE"
                isim5.text = "AĞAÇ"
            } else if (tık == 22) {
                btnIsim.text = "NAR"
                isim1.text = "TANELİ"
                isim2.text = "MEYVE"
                isim3.text = "KIŞ"
                isim4.text = "KIRMIZI"
                isim5.text = "PAZAR"
            } else if (tık == 23) {
                btnIsim.text = "ÜZÜM"
                isim1.text = "BAĞ"
                isim2.text = "SALKIM"
                isim3.text = "MEYVE"
                isim4.text = "SİYAH"
                isim5.text = "TANELİ"
            } else if (tık == 24) {
                btnIsim.text = "KİRAZ"
                isim1.text = "MEYVE"
                isim2.text = "KÜPE"
                isim3.text = "YAZ"
                isim4.text = "AĞAÇ"
                isim5.text = "KIRMIZI"
            } else if (tık == 25) {
                btnIsim.text = "KİTAP"
                isim1.text = "OKUMAK"
                isim2.text = "SAYFA"
                isim3.text = "KAPAK"
                isim4.text = "YAZI"
                isim5.text = "KAĞIT"
            } else if (tık == 26) {
                btnIsim.text = "KALEM"
                isim1.text = "RENKLİ"
                isim2.text = "YAZMAK"
                isim3.text = "DEFTER"
                isim4.text = "KİTAP"
                isim5.text = "UÇ"
            } else if (tık == 27) {
                btnIsim.text = "ÇOCUK"
                isim1.text = "EVLAT"
                isim2.text = "ANNE"
                isim3.text = "BABA"
                isim4.text = "DOĞUM"
                isim5.text = "SEVGİ"
            } else if (tık == 28) {
                btnIsim.text = "ÜTÜ MASASI"
                isim1.text = "ÇAMAŞIR"
                isim2.text = "BUHAR"
                isim3.text = "GÖMLEK"
                isim4.text = "DÜZELTMEK"
                isim5.text = "PANTOLON"
            } else if (tık == 29) {
                btnIsim.text = "HALI"
                isim1.text = "SERMEK"
                isim2.text = "BASMAK"
                isim3.text = "MODEL"
                isim4.text = "PARKE"
                isim5.text = "YIKAMA"
            } else if (tık == 30) {
                btnIsim.text = "KUMANDA"
                isim1.text = "TELEVİZYON"
                isim2.text = "KANAL"
                isim3.text = "DEĞİŞTİRMEK"
                isim4.text = "AÇMAK"
                isim5.text = "KAPATMAK"
            } else if (tık == 31) {
                btnIsim.text = "FIRLAMAK"
                isim1.text = "YÜKSEK"
                isim2.text = "HIZLI"
                isim3.text = "UÇMAK"
                isim4.text = "İLERİ"
                isim5.text = "ATILMAK"
            } else if (tık == 32) {
                btnIsim.text = "TURKUAZ"
                isim1.text = "RENK"
                isim2.text = "MAVİ"
                isim3.text = "YEŞİL"
                isim4.text = "DENİZ"
                isim5.text = "GÜZEL"
            } else if (tık == 33) {
                btnIsim.text = "HEDİYE"
                isim1.text = "ARMAĞAN"
                isim2.text = "VERMEK"
                isim3.text = "ALMAK"
                isim4.text = "DEĞERLİ"
                isim5.text = "ÖZEL GÜN"
            } else if (tık == 34) {
                btnIsim.text = "ŞARJ ALETİ"
                isim1.text = "TELEFON"
                isim2.text = "BATARYA"
                isim3.text = "PİL"
                isim4.text = "KABLO"
                isim5.text = "BİTMEK"
            } else if (tık == 35) {
                btnIsim.text = "SU"
                isim1.text = "H2O"
                isim2.text = "BERRAK"
                isim3.text = "İÇMEK"
                isim4.text = "DENİZ"
                isim5.text = "AKARSU"
            } else if (tık == 36) {
                btnIsim.text = "ARABA"
                isim1.text = "VASITA"
                isim2.text = "TEKERLEK"
                isim3.text = "GİTMEK"
                isim4.text = "ARAÇ"
                isim5.text = "BENZİN"
            } else if (tık == 37) {
                btnIsim.text = "İBADET"
                isim1.text = "NAMAZ"
                isim2.text = "FARZ"
                isim3.text = "DUA"
                isim4.text = "DİN"
                isim5.text = "ALLAH"
            } else if (tık == 38) {
                btnIsim.text = "İLAÇ"
                isim1.text = "İÇMEK"
                isim2.text = "HASTA"
                isim3.text = "HAP"
                isim4.text = "ŞURUP"
                isim5.text = "ŞİFA"
            } else if (tık == 39) {
                btnIsim.text = "AYVA"
                isim1.text = "EKŞİ"
                isim2.text = "SARI"
                isim3.text = "MEYVE"
                isim4.text = "İRİ"
                isim5.text = "REÇEL"
            } else if (tık == 40) {
                btnIsim.text = "PORTAKAL"
                isim1.text = "İÇECEK"
                isim2.text = "SIKMAK"
                isim3.text = "MEYVE"
                isim4.text = "TURUNCU"
                isim5.text = "AĞAÇ"
            }else if (tık == 41) {
                btnIsim.text = "CEVİZ"
                isim1.text = "ÇETİN"
                isim2.text = "SERT"
                isim3.text = "BEYİN"
                isim4.text = "KIRMAK"
                isim5.text = "BEYİN"
            }else if (tık == 42) {
                btnIsim.text = "FARMBUAZ"
                isim1.text = "PASTA"
                isim2.text = "MEYVE"
                isim3.text = "AHUDUDU"
                isim4.text = "KIRMIZI"
                isim5.text = "BÖĞÜRTLEN"
            }else if (tık == 43) {
                btnIsim.text = "MUZ"
                isim1.text = "SARI"
                isim2.text = "PASTA"
                isim3.text = "UZUN"
                isim4.text = "MAYMUN"
                isim5.text = "MEYVE"
            }else if (tık == 44) {
                btnIsim.text = "ŞEFTALİ"
                isim1.text = "MEYVE"
                isim2.text = "TURUNCU"
                isim3.text = "YAZ"
                isim4.text = "AĞAÇ"
                isim5.text = "SU"
            }else if (tık == 45) {
                btnIsim.text = "KARPUZ"
                isim1.text = "ÇEKİRDEK"
                isim2.text = "SU"
                isim3.text = "YUVARLAK"
                isim4.text = "KELEK"
                isim5.text = "SOĞUK"
            }else if (tık == 46) {
                btnIsim.text = "VİŞNE"
                isim1.text = "KİRAZ"
                isim2.text = "KIRMIZI"
                isim3.text = "SU"
                isim4.text = "AĞAÇ"
                isim5.text = "SIKMA"
            }else if (tık == 47) {
                btnIsim.text = "HURMA"
                isim1.text = "RAMAZAN"
                isim2.text = "ORUÇ"
                isim3.text = "UMRE"
                isim4.text = "MEKKE"
                isim5.text = "MEDİNE"
            }else if (tık == 48) {
                btnIsim.text = "ANANAS"
                isim1.text = "SU"
                isim2.text = "TROPİK"
                isim3.text = "SERT"
                isim4.text = "KESMEK"
                isim5.text = "KABUK"
            }else if (tık == 49) {
                btnIsim.text = "KAYISI"
                isim1.text = "KAYSERİ"
                isim2.text = "MEYVE"
                isim3.text = "KURU"
                isim4.text = "SU"
                isim5.text = "ÇEKİRDEK"
            }else if (tık == 50) {
                btnIsim.text = "KAVUN"
                isim1.text = "TATLI"
                isim2.text = "MEYVE"
                isim3.text = "KELEK"
                isim4.text = "SARI"
                isim5.text = "ÇEKİRDEK"
            }else if (tık == 51) {
                btnIsim.text = "BURUN"
                isim1.text = "SİVRİ"
                isim2.text = "ORGAN"
                isim3.text = "YÜZ"
                isim4.text = "AĞIZ"
                isim5.text = "KOKU"
            }else if (tık == 52) {
                btnIsim.text = "GÖZ"
                isim1.text = "GÖRMEK"
                isim2.text = "GÖZLÜK"
                isim3.text = "LENS"
                isim4.text = "YÜZ"
                isim5.text = "ORGAN"
            }else if (tık == 53) {
                btnIsim.text = "KİRPİK"
                isim1.text = "KAŞ"
                isim2.text = "GÖZ"
                isim3.text = "RİMEL"
                isim4.text = "YAKMA"
                isim5.text = "ALIN"
            }else if (tık == 54) {
                btnIsim.text = "KAŞ"
                isim1.text = "GÖZ"
                isim2.text = "ALIN"
                isim3.text = "ANTALYA"
                isim4.text = "YÜZ"
                isim5.text = "KIL"
            }else if (tık == 55) {
                btnIsim.text = "AĞIZ"
                isim1.text = "YÜZ"
                isim2.text = "BURUN"
                isim3.text = "DİL"
                isim4.text = "DİŞ"
                isim5.text = "KONUŞMAK"
            }else if (tık == 56) {
                btnIsim.text = "DİŞ"
                isim1.text = "AĞIZ"
                isim2.text = "DOKTOR"
                isim3.text = "DİL"
                isim4.text = "ISIRMAK"
                isim5.text = "YEMEK"
            }else if (tık == 57) {
                btnIsim.text = "YANAK"
                isim1.text = "YÜZ"
                isim2.text = "MAKAS"
                isim3.text = "PUDRA"
                isim4.text = "ALLIK"
                isim5.text = "PEMBE"
            }else if (tık == 58) {
                btnIsim.text = "TIRNAK"
                isim1.text = "EL"
                isim2.text = "AYAK"
                isim3.text = "OJE"
                isim4.text = "BATMAK"
                isim5.text = "MANİKÜR"
            }else if (tık == 59) {
                btnIsim.text = "BACAK"
                isim1.text = "KOL"
                isim2.text = "AYAK"
                isim3.text = "YÜRÜMEK"
                isim4.text = "BALDIR"
                isim5.text = "DİZ"
            }else if (tık == 60) {
                btnIsim.text = "AYAK"
                isim1.text = "PARMAK"
                isim2.text = "YÜRÜMEK"
                isim3.text = "NASIR"
                isim4.text = "DİZ"
                isim5.text = "BACAK"
            }else if (tık == 61) {
                btnIsim.text = "KALP"
                isim1.text = "ATMAK"
                isim2.text = "KIRILMAK"
                isim3.text = "KAN"
                isim4.text = "NEFES"
                isim5.text = "DURMAK"
            }else if (tık == 62) {
                btnIsim.text = "MİDE"
                isim1.text = "YEMEK"
                isim2.text = "KARIN"
                isim3.text = "BULANTI"
                isim4.text = "REFLÜ"
                isim5.text = "BULANTI"
            }else if (tık == 63) {
                btnIsim.text = "OMURGA"
                isim1.text = "DURUŞ"
                isim2.text = "SIRT"
                isim3.text = "SÜRÜNGEN"
                isim4.text = "KABURGA"
                isim5.text = "KEMİK"
            }else if (tık == 64) {
                btnIsim.text = "KULAK"
                isim1.text = "DUYMAK"
                isim2.text = "KEPÇE"
                isim3.text = "KAFA"
                isim4.text = "ZAR"
                isim5.text = "İŞİTME"
            }else if (tık == 65) {
                btnIsim.text = "KULAKLIK"
                isim1.text = "DİNLEMEK"
                isim2.text = "ŞARKI"
                isim3.text = "TELEFON"
                isim4.text = "TAKMAK"
                isim5.text = "SES"
            }else if (tık == 66) {
                btnIsim.text = "BARDAK"
                isim1.text = "İÇMEK"
                isim2.text = "ÇAY"
                isim3.text = "SU"
                isim4.text = "KULPLU"
                isim5.text = "İNCE BEL"
            }else if (tık == 67) {
                btnIsim.text = "TAKSİ"
                isim1.text = "ŞÖFOR"
                isim2.text = "SARI"
                isim3.text = "YOLCU"
                isim4.text = "ARABA"
                isim5.text = "TEKERLEK"
            }else if (tık == 68) {
                btnIsim.text = "MUM"
                isim1.text = "IŞIK"
                isim2.text = "ATEŞ"
                isim3.text = "ÜFLEMEK"
                isim4.text = "PASTA"
                isim5.text = "ELEKTRİK"
            }else if (tık == 69) {
                btnIsim.text = "ÇAYDANLIK"
                isim1.text = "DEMLİK"
                isim2.text = "BARDAK"
                isim3.text = "SU"
                isim4.text = "ŞEKER"
                isim5.text = "İÇMEK"
            }else if (tık == 70) {
                btnIsim.text = "ŞEKERLİK"
                isim1.text = "KASE"
                isim2.text = "TATLI"
                isim3.text = "ÇAY"
                isim4.text = "ŞEKER"
                isim5.text = "KAŞIK"
            }else if (tık == 71) {
                btnIsim.text = "KUYRUK"
                isim1.text = "KEDİ"
                isim2.text = "KÖPEK"
                isim3.text = "SIRA"
                isim4.text = "SALLAMAK"
                isim5.text = "ARKA"
            }else if (tık == 72) {
                btnIsim.text = "GÜLMEK"
                isim1.text = "AĞIZ"
                isim2.text = "MUTLU"
                isim3.text = "ESPRİ"
                isim4.text = "SEVİNÇ"
                isim5.text = "KAHKAHA"
            }else if (tık == 73) {
                btnIsim.text = "DÜŞÜNMEK"
                isim1.text = "FİKİR"
                isim2.text = "AKIL"
                isim3.text = "BEYİN"
                isim4.text = "SEVGİLİ"
                isim5.text = "HATIRLAMAK"
            }else if (tık == 74) {
                btnIsim.text = "SOĞUK"
                isim1.text = "BUZ"
                isim2.text = "SICAK"
                isim3.text = "SU"
                isim4.text = "KUTUP"
                isim5.text = "ÜŞÜMEK"
            }else if (tık == 75) {
                btnIsim.text = "SARIMSAK"
                isim1.text = "SOĞAN"
                isim2.text = "ŞİFA"
                isim3.text = "KELLE PAÇA"
                isim4.text = "BİTKİ"
                isim5.text = "EZMEK"
            }else if (tık == 76) {
                btnIsim.text = "SARILMAK"
                isim1.text = "KOL"
                isim2.text = "SEVGİ"
                isim3.text = "BULUŞMA"
                isim4.text = "SIKI"
                isim5.text = "EL"
            }else if (tık == 77) {
                btnIsim.text = "GOL"
                isim1.text = "FUTBOL"
                isim2.text = "TOP"
                isim3.text = "KALE"
                isim4.text = "KALECİ"
                isim5.text = "SEVİNÇ"
            }else if (tık == 78) {
                btnIsim.text = "HÜCRE"
                isim1.text = "CANLI"
                isim2.text = "KÜÇÜK"
                isim3.text = "MİKROSKOP"
                isim4.text = "STOPLAZMA"
                isim5.text = "FEN BİLGİSİ"
            }else if (tık == 79) {
                btnIsim.text = "DOKU"
                isim1.text = "HÜCRE"
                isim2.text = "TOPLULUK"
                isim3.text = "YAPI"
                isim4.text = "GÖREV"
                isim5.text = "ORGAN"
            }else if (tık == 80) {
                btnIsim.text = "GEN"
                isim1.text = "DNA"
                isim2.text = "ÇOCUK"
                isim3.text = "BOY"
                isim4.text = "GÖZ"
                isim5.text = "BİRİM"
            }else if (tık == 81) {
                btnIsim.text = "ÇORAP"
                isim1.text = "AYAK"
                isim2.text = "GİYMEK"
                isim3.text = "İNCE"
                isim4.text = "KISA"
                isim5.text = "BABET"
            }else if (tık == 82) {
                btnIsim.text = "SİNCAP"
                isim1.text = "KEMİRMEK"
                isim2.text = "HAYVAN"
                isim3.text = "FINDIK"
                isim4.text = "AĞAÇ"
                isim5.text = "KUYRUK"
            }else if (tık == 83) {
                btnIsim.text = "KÖPEK"
                isim1.text = "İT"
                isim2.text = "HAYVAN"
                isim3.text = "KEDİ"
                isim4.text = "HAV"
                isim5.text = "ATMAK"
            }else if (tık == 84) {
                btnIsim.text = "SUCUK"
                isim1.text = "SALAM"
                isim2.text = "SOSİS"
                isim3.text = "PİZZA"
                isim4.text = "YUMURTA"
                isim5.text = "KANGAL"
            }else if (tık == 85) {
                btnIsim.text = "SOSİS"
                isim1.text = "EKMEK"
                isim2.text = "UZUN"
                isim3.text = "ÇUBUK"
                isim4.text = "SUCUK"
                isim5.text = "SALAM"
            }else if (tık == 86) {
                btnIsim.text = "SINAV"
                isim1.text = "OKUL"
                isim2.text = "DERS"
                isim3.text = "PUAN"
                isim4.text = "NOT"
                isim5.text = "GEÇİŞ"
            }else if (tık == 87) {
                btnIsim.text = "DAVETİYE"
                isim1.text = "EVLİLİK"
                isim2.text = "DÜĞÜN"
                isim3.text = "DERNEK"
                isim4.text = "TARİH"
                isim5.text = "ÇAĞIRMAK"
            }else if (tık == 88) {
                btnIsim.text = "ROKA"
                isim1.text = "BİTKİ"
                isim2.text = "SALATA"
                isim3.text = "YEŞİL"
                isim4.text = "BALIK"
                isim5.text = "LİMON"
            }else if (tık == 89) {
                btnIsim.text = "BROKOLİ"
                isim1.text = "HAŞLAMA"
                isim2.text = "YEŞİL"
                isim3.text = "SALATA"
                isim4.text = "KÜÇÜK"
                isim5.text = "DİYET"
            }
            else if (tık == 90) {
                btnIsim.text = "DOMATES"
                isim1.text = "KIRMIZI"
                isim2.text = "SALATA"
                isim3.text = "SALÇA"
                isim4.text = "PEYNİR"
                isim5.text = "YEMEK"
            }
            else if (tık == 91) {
                btnIsim.text = "HAVUÇ"
                isim1.text = "TURUNCU"
                isim2.text = "TAVŞAN"
                isim3.text = "TARATOR"
                isim4.text = "SEBZE"
                isim5.text = "UZUN"
            }
            else if (tık == 92) {
                btnIsim.text = "SOĞAN"
                isim1.text = "KURU"
                isim2.text = "SARIMSAK"
                isim3.text = "ARPACIK"
                isim4.text = "CÜCÜK"
                isim5.text = "EKMEK"
            }
            else if (tık == 93) {
                btnIsim.text = "PATATES"
                isim1.text = "TOPRAK"
                isim2.text = "KIZARTMA"
                isim3.text = "HAŞLAMA"
                isim4.text = "DOMATES"
                isim5.text = "SALATA"
            }
            else if (tık == 94) {
                btnIsim.text = "KAHKÜL"
                isim1.text = "SAÇ"
                isim2.text = "ALIN"
                isim3.text = "KESMEK"
                isim4.text = "KADIN"
                isim5.text = "GÖZ"
            }
            else if (tık == 95) {
                btnIsim.text = "AYDINLIK"
                isim1.text = "GÜNDÜZ"
                isim2.text = "GECE"
                isim3.text = "AÇIK"
                isim4.text = "NET"
                isim5.text = "BELİRGİN"
            }
            else if (tık == 96) {
                btnIsim.text = "PAPYON"
                isim1.text = "GÖMLEK"
                isim2.text = "DAMATLIK"
                isim3.text = "KRAVAT"
                isim4.text = "TAKIM ELBİSE"
                isim5.text = "YAKA"
            }
            else if (tık == 97) {
                btnIsim.text = "GELİN"
                isim1.text = "EV"
                isim2.text = "DAMAT"
                isim3.text = "DÜĞÜN"
                isim4.text = "BEYAZ"
                isim5.text = "NİKAH"
            }
            else if (tık == 98) {
                btnIsim.text = "BERE"
                isim1.text = "BORDO"
                isim2.text = "ŞAPKA"
                isim3.text = "ASKER"
                isim4.text = "KAFA"
                isim5.text = "KIŞ"
            }
            else if (tık == 99) {
                btnIsim.text = "YANGIN"
                isim1.text = "ATEŞ YAKMAK"
                isim2.text = "MANGAL"
                isim3.text = "DUMAN"
                isim4.text = "ALEV"
                isim5.text = "İTFAİYE"
            }
            else if (tık == 100) {
                btnIsim.text = "DOĞUM GÜNÜ"
                isim1.text = "HEDİYE"
                isim2.text = "MUM"
                isim3.text = "PASTA"
                isim4.text = "PARTİ"
                isim5.text = "SÜRPRİZ"
            }
            else if (tık == 101) {
                btnIsim.text = "HEDİYE"
                isim1.text = "SÜRPRİZ"
                isim2.text = "ÇİÇEK"
                isim3.text = "SEVGİ"
                isim4.text = "ALMAK"
                isim5.text = "PAKET"
            }
            else if (tık == 102) {
                btnIsim.text = "AŞK"
                isim1.text = "SEVGİ"
                isim2.text = "KALP"
                isim3.text = "TUTKU"
                isim4.text = "EVLİLİK"
                isim5.text = "DUYGU"
            }
            else if (tık == 103) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 104) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 105) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 106) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 107) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 108) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 109) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
            else if (tık == 110) {
                btnIsim.text = ""
                isim1.text = ""
                isim2.text = ""
                isim3.text = ""
                isim4.text = ""
                isim5.text = ""
            }
        }

        }
    }
