package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.adapter.PokemonAdapter
import com.example.fragments.database.PokemonService
import com.example.fragments.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PokemonAdapter
    private lateinit var pokemons : MutableList<Pokemon>
    private lateinit var service : PokemonService
    private lateinit var retrofit : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        retrofit()

        navBottom.setupWithNavController(findNavController(R.id.navHostFragment))

//        carregador()

    }
//
//    private fun retrofit() {
//        retrofit =Retrofit.Builder()
//            .baseUrl("http://192.168.0.102:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        service = retrofit.create(PokemonService::class.java)
//        pokemons = mutableListOf()
//
//        service.getAll().enqueue(object : Callback<List<Pokemon>> {
//            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
//                Log.e("API error", t.message, t)
//            }
//
//            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
//                pokemons= response.body()!!.toMutableList()
//                carregador()
//            }
//        })

//    }


//    fun carregador (){
//        adapter = PokemonAdapter(pokemons.toMutableList(),this, applicationContext)
//        rvLista.adapter = adapter
//        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//
//    }

//    fun pokemonSalvar(pokemon: Pokemon) {
//        service.insert(pokemon).enqueue(object : Callback<Pokemon>{
//
//            override fun onFailure(call: Call<Pokemon>, t: Throwable) {   }
//
//            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
//                val inserirPokemon = response.body()!!
//                pokemon.id = inserirPokemon.id
//                pokemons.add(0, pokemon)
//            }
//        })
//
//        carregador()
//    }
//
//     fun pokemonExcluir(pokemon: Pokemon) {
//        carregador()
//    }
//
//     fun pokemonEditar(pokemon: Pokemon) {
//        carregador()
//    }
//
//    override fun pokemonCompart(pokemon: Pokemon) {
//        val compartilha = Intent(Intent.ACTION_SEND)
//
//        with(compartilha){
//            type = "text/plain"
//            putExtra(Intent.EXTRA_SUBJECT, msgPrincipal)
//            putExtra(Intent.EXTRA_TEXT, msgSecundaria+task.title)
//        }
//        startActivity(compartilha)
//    }

}