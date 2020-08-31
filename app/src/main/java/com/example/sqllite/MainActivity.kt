package com.example.sqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val vt = VeriTabaniYardimcisi(this)
      //  KisilerDao().kisiekle(vt,"Ahmet","999999",18,1.72)
        //KisilerDao().kisiekle(vt,"Onur","888888",19,1.62)
        //KisilerDao().kisiekle(vt,"Mehmet","777777",20,1.82)
        //KisilerDao().kisiekle(vt,"Yağız","666666",17,1.92)
        //KisilerDao().kisiekle(vt,"Tunahan","555555",16,2.00)

      //  KisilerDao().kisiguncelle(vt,3,"Yeni Onur","1455245",15,1.80)
        //        KisilerDao().kisiSil(vt,3)
       // val sonuc = KisilerDao().kayitKontrol(vt,"Onur")
      //  Log.e("Kayıt Kontrol",sonuc.toString())

        val kisi = KisilerDao().kisigetir(vt,4)
        if(kisi !=null){     //null değilse çalıstır

            Log.e("kisi no--->4",(kisi.kisi_no).toString())
            Log.e("kisi ad--->4",kisi.kisi_ad)
            Log.e("kisi tel--->4",kisi.kisi_tel)
            Log.e("kisi yas--->4",(kisi.kisi_yas).toString())
            Log.e("kisi boy--->4",(kisi.kisi_boy).toString())

        }

        val kisiListe = KisilerDao().tumKisiler(vt)

       // val kisiListe = KisilerDao().arama(vt,"e") //içinde e harfi olanları getirir

  //      val kisiListe =  KisilerDao().rasgelegetir(vt)
        for(k in kisiListe){
            Log.e("kisi no",(k.kisi_no).toString())
            Log.e("kisi ad",k.kisi_ad)
            Log.e("kisi tel",k.kisi_tel)
            Log.e("kisi yas",(k.kisi_yas).toString())
            Log.e("kisi boy",(k.kisi_boy).toString())
        }
    }
}