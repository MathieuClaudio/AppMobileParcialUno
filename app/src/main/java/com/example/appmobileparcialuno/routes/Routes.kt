package com.example.appmobileparcialuno.routes

sealed class Routes(val routes: String) {
    object Page1: Routes("login")
    object Page2: Routes("welcome/{emailName}"){
        fun createRoute(email: String): String{
            return "welcome/$email"
        }
    }
}