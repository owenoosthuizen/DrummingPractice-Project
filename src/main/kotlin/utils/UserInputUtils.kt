package utils

fun readUserInt(UserInt: String): Int{
    while (true){
        print(UserInt)
        val input = readlnOrNull()
        try{
            return input!!.toInt()
        }catch (e: Exception){
            println("Please enter a valid number. ")
        }
    }
}

fun readUserDouble(UserD: String): Double{
    while (true){
        print(UserD)
        val input = readlnOrNull()
        try{
            return input!!.toDouble()
        }catch (e: NumberFormatException){
            println("Please enter a valid decimal number.")
        }
    }
}

fun readUserBoolean(UserBoo: String): Boolean{
    while (true){
        print(UserBoo)
        val input = readlnOrNull()
        if (input == "true" || input == "false")return input.toBoolean()
        println("Please type true OR false")
    }
}

fun readUserString(UserPromt: String): String{
    print(UserPromt)
    return readln()
}