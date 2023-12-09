package com.example.cuciin_temp.model

data class Layanan(
    val harga: Int,
    val id: Int,
    val mesin: List<Mesin>,
    val nama: String
)