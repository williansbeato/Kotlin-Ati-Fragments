package com.example.fragments.database

import com.example.fragments.model.Pokemon
import retrofit2.Call
import retrofit2.http.*

interface PokemonService {

    @GET("pokemons")
    fun getAll(): Call<List<Pokemon>>

    @GET("pokemons/{id}")
    fun get(@Path("id") id:Long): Call<Pokemon>


    @Headers("Content-Type: application/json")
    @POST("pokemons")
    fun insert(@Body pokemon: Pokemon): Call<Pokemon>

    @Headers("Content-Type: application/json")
    @PATCH("pokemons/{id}")
    fun update(@Path("id") id:Long, @Body pokemon: Pokemon): Call<Pokemon>

    @DELETE("pokemons/{id}")
    fun delete(@Path("id") id:Long): Call<Void>
}