package uy.edu.ude.mvp

import org.junit.Test

class ExampleUnitTest {
    class ExampleClass(val name:String){

    }
    data class ExampleDataClass(val name:String){}

    @Test
    fun dunno(){
        val exampleClass=ExampleClass("Name")
        println(exampleClass.toString())

        val exampleDataClass=ExampleDataClass("Name")
        println(exampleDataClass.toString())
    }
}