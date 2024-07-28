package com.example.alex_cid_s4

import java.io.Serializable

data class Producto(
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagen: Int
) : Serializable
