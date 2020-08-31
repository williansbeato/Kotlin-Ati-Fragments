package com.example.fragments.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.adapter.PokemonAdapter
import com.example.fragments.database.PokemonService
import com.example.fragments.model.Pokemon
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import  com.example.fragments.MainActivity

class fragment_home : Fragment() {

    private lateinit var adapter: PokemonAdapter
    private lateinit var pokemons : MutableList<Pokemon>
    private lateinit var service : PokemonService
    private lateinit var retrofit : Retrofit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        retrofit()

//        navBottom.setupWithNavController(findNavController(R.id.navHostFragment))

        carregador()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        view.btGotoImages.setOnClickListener {
//            findNavController().navigate(R.id.navigateToImages)
//        }
        return view
    }




    private fun retrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.102:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
        pokemons = mutableListOf()

        service.getAll().enqueue(object : Callback<List<Pokemon>> {
            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                Log.e("API error", t.message, t)
            }

            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                pokemons= response.body()!!.toMutableList()
                carregador()
            }
        })

    }

    private fun carregador() {
//        adapter = PokemonAdapter(pokemons.toMutableList(),this, applicationContext)
        adapter = PokemonAdapter(pokemons.toMutableList(), this, applicationContext)
        rvLista.adapter = adapter
        rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }



}



