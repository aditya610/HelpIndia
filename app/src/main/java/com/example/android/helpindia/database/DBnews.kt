package com.example.android.helpindia.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val dbname="news.db"
val Db_ver=4
class DBnews(context:Context?):SQLiteOpenHelper(context, dbname,null, Db_ver){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            it.execSQL(newstable.CMD_CREATE_TABLE)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}