package com.example.myapplication

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){


    val input1 = ObservableField<String>()
    val input2 = ObservableField<String>()
    val input3 = ObservableField<String>()
    val result = ObservableField<String>()

    fun calculate() {
        val input1List = input1.get()?.split(",")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
        val input2List = input2.get()?.split(",")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
        val input3List = input3.get()?.split(",")?.mapNotNull { it.toIntOrNull() } ?: emptyList()

        if (input1List.isNotEmpty() && input2List.isNotEmpty() && input3List.isNotEmpty()) {
            val intersect = input1List.intersect(input2List).intersect(input3List)
            val union = input1List.union(input2List).union(input3List)
            val highestNumber =
                listOf(input1List.max(), input2List.max(), input3List.max()).maxOrNull()

            result.set(
                "Intersection: ${intersect.joinToString(", ")}\n" +
                        "Union: ${union.joinToString(", ")}\n" +
                        "Highest Number: $highestNumber"
            )
        }else{
            result.set("Fill All the text boxes")
        }
    }

}