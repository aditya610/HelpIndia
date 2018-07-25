package com.example.android.helpindia.`class`

import java.util.*
data class Army (val new1:String,
                val heading:String
)

val armynew= arrayOf("Bacon ipsum dolor amet sirloin cupim kevin pancetta," +
        " turducken jerky pig strip steak short ribs boudin beef ribs prosciutto brisket turkey." +
        " Boudin salami chicken jerky doner pig sirloin kielbasa venison tri-tip turkey short loin bacon." +
        " Kevin meatball turducken chuck sirloin boudin ribeye shankle t-bone chicken tri-tip salami pork belly." +
        " Doner jerky burgdoggen shankle leberkas bresaola. Shank jerky sausage ball tip flank landjaeger. " +
        "Shank t-bone tenderloin pork belly pork capicola alcatra leberkas beef ribs tri-tip brisket boudin landjaeger cupim salami",
        "Pork belly tri-tip ground round brisket pork loin. Chicken frankfurter ball tip," +
                "  enderloin landjaeger burgdoggen cow tri-tip filet mignon. Flank kevin sausage chicken, doner strip steak pastrami." +
                " Corned beef buffalo filet mignon sirloin cow andouille tri-tip bacon jowl ham. " +
                "Porchetta picanha andouille, doner frankfurter cupim chuck tri-tip pork loin pork belly. Jowl filet mignon shank ribeye hamburger landjaeger sirloin prosciutto.")
val armyheading= arrayOf("2 terrorist killed 1 soldier died","2 soldier died in a encounter","5 terrorist killed")



fun generaterandonarmy(): ArrayList<Army>
{   val army= ArrayList<Army>()
    var  r= Random();
    for(i in 1..10)
    {
        army.add(Army(armynew[r.nextInt(2)], armyheading[r.nextInt(3)]))
    }
    return army
}