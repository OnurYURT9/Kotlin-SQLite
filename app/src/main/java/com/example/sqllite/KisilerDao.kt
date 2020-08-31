package com.example.sqllite

import android.content.ContentValues

class KisilerDao {

    fun kisiekle(
        vt: VeriTabaniYardimcisi,
        kisi_ad: String,
        kisi_tel: String,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.insertOrThrow("kisiler", null, values)
        db.close()

    }

    fun kisiguncelle(
        vt: VeriTabaniYardimcisi,
        kisi_no: Int,
        kisi_ad: String,
        kisi_tel: String,
        kisi_yas: Int,
        kisi_boy: Double
    ) {

        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("kisi_ad", kisi_ad)
        values.put("kisi_tel", kisi_tel)
        values.put("kisi_yas", kisi_yas)
        values.put("kisi_boy", kisi_boy)

        db.update("kisiler", values, "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()

    }

    fun kisiSil(vt: VeriTabaniYardimcisi, kisi_no: Int) {
        val db = vt.writableDatabase
        db.delete("kisiler", "kisi_no=?", arrayOf(kisi_no.toString()))
        db.close()
    }


    fun tumKisiler(vt: VeriTabaniYardimcisi): ArrayList<Kisiler> {        //ne kadar veri varsa bize getirecek

        val kisilerArrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("select * from kisiler", null)
        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no"))
                , cursor.getString(cursor.getColumnIndex("kisi_ad"))
                , cursor.getString(cursor.getColumnIndex("kisi_tel"))
                , cursor.getInt(cursor.getColumnIndex("kisi_yas"))
                , cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

    fun arama(
        vt: VeriTabaniYardimcisi,
        keyWord: String
    ): ArrayList<Kisiler> {

        val kisilerArrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("select * from kisiler WHERE kisi_ad like '%$keyWord%'", null)
        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no"))
                , cursor.getString(cursor.getColumnIndex("kisi_ad"))
                , cursor.getString(cursor.getColumnIndex("kisi_tel"))
                , cursor.getInt(cursor.getColumnIndex("kisi_yas"))
                , cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

    fun rasgelegetir(vt: VeriTabaniYardimcisi): ArrayList<Kisiler> {

        val kisilerArrayList = ArrayList<Kisiler>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("select * from kisiler order by random() LIMIT 2", null)
        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndex("kisi_no"))
                , cursor.getString(cursor.getColumnIndex("kisi_ad"))
                , cursor.getString(cursor.getColumnIndex("kisi_tel"))
                , cursor.getInt(cursor.getColumnIndex("kisi_yas"))
                , cursor.getDouble(cursor.getColumnIndex("kisi_boy"))
            )

            kisilerArrayList.add(kisi)
        }
        return kisilerArrayList
    }

    fun kayitKontrol(vt:VeriTabaniYardimcisi,kisi_ad:String):Int{
        var sonuc = 0

        val db = vt.writableDatabase
        val cursor = db.rawQuery("select count(*) as sonuc from kisiler where kisi_ad='$kisi_ad'", null)
        while (cursor.moveToNext()){
            sonuc = cursor.getInt(cursor.getColumnIndex("sonuc"))
        }
        return sonuc
    }
    fun kisigetir(vt: VeriTabaniYardimcisi,kisi_no: Int): Kisiler ? {

       var gelenKisi:Kisiler? = null //nullable olabilir

        val db = vt.writableDatabase

        val cursor = db.rawQuery("select * from kisiler where kisi_no=$kisi_no", null)

        while (cursor.moveToNext()) {
            gelenKisi = Kisiler(cursor.getInt(cursor.getColumnIndex("kisi_no"))
                , cursor.getString(cursor.getColumnIndex("kisi_ad"))
                , cursor.getString(cursor.getColumnIndex("kisi_tel"))
                , cursor.getInt(cursor.getColumnIndex("kisi_yas"))
                , cursor.getDouble(cursor.getColumnIndex("kisi_boy")))


        }
        return gelenKisi
    }

}