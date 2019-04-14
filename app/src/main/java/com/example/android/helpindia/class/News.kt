package com.example.android.helpindia.`class`

import java.util.*

data class News(val phone:String,
                val emailid:String,
                val name: String,
                val new1:String,
                val heading:String
                ){
    constructor():this("","","","","")
}

val newname= arrayOf("Bacon ipsum dolor amet sirloin cupim kevin pancetta," +
        " turducken jerky pig strip steak short ribs boudin beef ribs prosciutto brisket turkey." +
        " Boudin salami chicken jerky doner pig sirloin kielbasa venison tri-tip turkey short loin bacon." +
        " Kevin meatball turducken chuck sirloin boudin ribeye shankle t-bone chicken tri-tip salami pork belly." +
        " Doner jerky burgdoggen shankle leberkas bresaola. Shank jerky sausage ball tip flank landjaeger. " +
        "Shank t-bone tenderloin pork belly pork capicola alcatra leberkas beef ribs tri-tip brisket boudin landjaeger cupim salami",
        "Pork belly tri-tip ground round brisket pork loin. Chicken frankfurter ball tip," +
                "  enderloin landjaeger burgdoggen cow tri-tip filet mignon. Flank kevin sausage chicken, doner strip steak pastrami." +
                " Corned beef buffalo filet mignon sirloin cow andouille tri-tip bacon jowl ham. " +
        "Porchetta picanha andouille, doner frankfurter cupim chuck tri-tip pork loin pork belly. Jowl filet mignon shank ribeye hamburger landjaeger sirloin prosciutto.")
val headingname= arrayOf("BLOOD DONATION","RALIES","DRAMA","SWATCH BHARAT","ADOPTION","ORGAN DONATION")



fun generaterandon():ArrayList<News>
{   val cust=ArrayList<News>()
    var  r= Random();
    for(i in 1..10)
    {
      //  cust.add(News(r.nextInt(10),newname[r.nextInt(2)], headingname[r.nextInt(6)]))
    }
return cust
}