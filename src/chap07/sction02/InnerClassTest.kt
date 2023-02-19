package chap07.sction02

interface Switcher{
    fun on(): String
}

class Smartphone(val model:String){
    private val cpu = "Exynos"

    fun powerOn(): String{
        class Led(val color: String){
            fun blink(): String = "Blinking $color on $model"
        }
        val powerStatus = Led("Red")
        val powerSwitch = object: Switcher{
            override fun on(): String {
                return powerStatus.blink()
            }
        }
        //return powerStatus.blink()
        return powerSwitch.on()
    }

    inner class ExternalStorage(val size: Int){
        fun getInfo() = "${model}: Installed on $cpu with ${size}Gb"

    }
}

fun main(){
    val mySdcard = Smartphone("S7").ExternalStorage(32)
    println(mySdcard.getInfo())

    val myphone = Smartphone("Note9")
    myphone.ExternalStorage(128)
    println(myphone.powerOn())
}