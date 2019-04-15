package com.example.android.helpindia.`class`

import java.net.URL


data class signinclass2(
        val emailid:String,
        val name:String,
        val passcode:String,
        val organizationname:String,
        val city:String,
        val type:String,
        val cause: String,
        val url: String
){
    constructor():this("","","","","","","",""){

    }
}