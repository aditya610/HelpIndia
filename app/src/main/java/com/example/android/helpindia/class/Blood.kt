package com.example.android.helpindia.`class`

import com.example.android.helpindia.army
import java.util.*

data class Blood(val campname:String,
                 val place:String,
                 val date:String,
                 val time:String){
    constructor():this("","","","")
}



val bloodcampname= arrayOf("BLOOD DONATION","ORGAN DONATION AFTER DEATH")
val bloodplace= arrayOf("jawaharlal nehru satdium delhi","indra gandhi stadium delhi")
val blooddate= arrayOf("15/01/2018","20/10/2018","30/5/2018")
val bloodtime= arrayOf("5pm","4am","12pm")

fun generaterandomblood():ArrayList<Blood>
{
    var blood=ArrayList<Blood>()
    var r=Random()
    for(i in 1..10)
    {
        blood.add(Blood(bloodcampname[r.nextInt(2)], bloodplace[r.nextInt(2)],blooddate[r.nextInt(3)], bloodtime[r.nextInt(3)]))
    }
    return blood
}

