package com.example.android.helpindia.`class`

import com.example.android.helpindia.R.layout.ngo
import java.security.cert.CertPathValidatorException
import java.util.*




data class Workshop(
        val name:String,
        val purpose:String,
        val city: String,
        val timedate:String,
        val reason: String,
val event:String

)





val worshopname= arrayOf("Rally","Workshop","Drama")
val workshoppurpose = arrayOf("river","women security","pollution")
val worshopcity= arrayOf("delhi","haryana","punjab","chennai","jaipur")
val worshoptimedate= arrayOf("13:30    12/10/2019","15:10    30/5/2018")
val  workshopreason= arrayOf("Bacon ipsum dolor amet sirloin cupim kevin pan turducken jerky pig strip steak short ribs boudinvenison tri-tip turkey short loin bacon",
                             "turducken jerky pig strip steak short ribs boudin beef ribs prosciutto brisket turvenison tri-tip turkey short loin bacon",
                              "Boudin salami chicken jerky doner pig sirloin kielbasa venison tri-tip turkey short loin baconvenison tri-tip turkey short loin bacon")
val eventname= arrayOf("event1","event2","event3")
fun generaterandomworshop():ArrayList<Workshop>
{ val worshop=ArrayList<Workshop>()
    var r= Random()
    for(i in 1..10)
    {
        worshop.add(Workshop(worshopname[r.nextInt(3)], "topic: "+workshoppurpose[r.nextInt(3)],
                "city:"+worshopcity[r.nextInt(4)], worshoptimedate[r.nextInt(2)],
                "  Reason to join:\n"+workshopreason[r.nextInt(2)], eventname[r.nextInt(3)]))
    }
    return worshop
}



