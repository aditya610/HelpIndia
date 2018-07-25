package com.example.android.helpindia.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.android.helpindia.`class`.News

class newstable{

    companion object {
        val TABLE_NAME = "news"
        // primary key to be set before auto increment
        val CMD_CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS ${TABLE_NAME}(
            ${Columns.ID} INTEGER,
                       ${Columns.HEADING} TEXT,
                       ${Columns.INFO} TEXT
            );
        """.trimIndent()
        fun addTask(db: SQLiteDatabase, news: News): Long {
            val row = ContentValues()
            row.put(Columns.INFO,1)
            row.put(Columns.HEADING, news.heading)
            row.put(Columns.INFO, news.new1)
            return db.insert(TABLE_NAME, null, row)

        }
        fun getAllTasks(db: SQLiteDatabase): ArrayList<News> {
            val tasks = ArrayList<News>()
            val cursor = db.query(
                    TABLE_NAME,
                    arrayOf(Columns.ID, Columns.HEADING, Columns.INFO),
                    null, null,
                    null, null,
                    null
            )

            val idCOL = cursor.getColumnIndex(Columns.ID)
            val taskCOL = cursor.getColumnIndex(Columns.HEADING)
            val donCOL = cursor.getColumnIndex(Columns.INFO)
            while (cursor.moveToNext()) {
                val rowTask = News(
                        cursor.getInt(idCOL)
                        , cursor.getString(taskCOL),
                        cursor.getString(donCOL)
                )
                tasks.add(rowTask)
            }
            return tasks;
        }
        fun delete(db: SQLiteDatabase, news: News):Int {
 Log.d("delete",news.ID.toString())
            return db.delete(TABLE_NAME,"${Columns.ID
            }=?", arrayOf( news.ID.toString()))
        }

    }

    object Columns{
        val ID="id"
        val HEADING="heading"
        val INFO="info"
    }

}