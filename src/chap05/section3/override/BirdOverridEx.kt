package chap05.section3.override

open class Bird(var name: String, var wing: Int, var beak: String, var color: String) {

    fun fly() = println("Fly wing: $wing")
    open fun sing(vol: Int) = println("Sing col: $vol")

}

class Parrot(name: String, wing:Int = 2, beak:String, color:String, var language: String = "natural") : Bird(name, wing, beak, color){

    fun speak() = println("Speak! $language")
    override fun sing(vol:Int){
        println("I'm a parrot! The volum level is $vol")
        speak()
    }

}
fun main(){

    val parrot = Parrot("myparrot", 2, "short", "multiple")
    parrot.language = "English"


    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    parrot.sing(5)
}