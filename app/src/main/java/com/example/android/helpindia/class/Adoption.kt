package com.example.android.helpindia.`class`

import java.util.*
import kotlin.collections.ArrayList


data class Adoption(
        val name:String,
        val type:String,
      //  val cause: String,
        val city:String

)





val adoptionname= arrayOf("baby home","Home for everyone","old age home","animals home")
val adoptiontype = arrayOf("old age ","young age","all age","dogs","cats","animal")
//val ngocause= arrayOf("help young people to develop a future","help old people","help every one")
val adoptioncity= arrayOf("delhi","haryana","punjab","chennai","jaipur")

fun generaterandomadoption():ArrayList<Adoption>
{ val ngo=ArrayList<Adoption>()
    var r=Random()
    for(i in 1..10)
    {
        ngo.add(Adoption(adoptionname[r.nextInt(4)],"age group: "+ adoptiontype[r.nextInt(3)], "city:"+adoptioncity[r.nextInt(5)]))
    }
    return ngo
}



