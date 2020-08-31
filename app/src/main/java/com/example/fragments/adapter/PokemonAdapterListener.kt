package com.example.fragments.adapter

import com.example.fragments.model.Pokemon

interface PokemonAdapterListener {
    fun onTaskSelected(pokemon: Pokemon)
    fun pokemonSalvar(pokemon: Pokemon)
    fun pokemonExcluir(pokemon: Pokemon)
    fun pokemonEditar(pokemon: Pokemon)
    fun pokemonCompart(pokemon: Pokemon)
}