import java.lang.IllegalArgumentException

fun main(){
 var w:Wolf? = Wolf()

    if(w != null){
        w.eat()
    }

    var x = w?.hunger
    println("The value of x is $x")

    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hello","there",null)
    for (item in myArray) item?.let {
        println(it)
    }

    myFunction("bit")

    getAlphaWolf()?.let { it.eat() }
    fun newest(){
        try {
            val z = w!!.hunger
            println(z)
        }catch (e:NullPointerException){
            println("I caught this $e")
            e.printStackTrace()
        }

    }

    w = null
    newest()

    try {
        setWorkRatePercentage(1)
    }catch (e: IllegalArgumentException){
        e.printStackTrace()
    }
}

class Wolf {
    var hunger = 10
    val food = "meat"

    fun eat(){
        println("The Wolf is eating $food")
    }
}

class MyWolf {
    var wolf:Wolf? = Wolf()

    fun myFunction(){
        wolf?.eat()
    }
}

fun getAlphaWolf():Wolf?{
    return Wolf()
}

fun myFunction(str: String) {

    try {
        val x = str.toInt()

        println(x)
    }catch (e:NumberFormatException){
        println("Bummer")
        e.printStackTrace()
    }

    println("myFunction has ended")

}

fun setWorkRatePercentage(x:Int){
    if(x !in 0..100){
        throw IllegalArgumentException("Percentage no in range of 0 to 100: $x")
    }
}