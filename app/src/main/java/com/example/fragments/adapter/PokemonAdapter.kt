package com.example.fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.MainActivity
import com.example.fragments.R
import com.example.fragments.fragments.fragment_home
import com.example.fragments.model.Pokemon
import kotlinx.android.synthetic.main.cartao_edit.view.*
import kotlinx.android.synthetic.main.cartao_view.view.*

class PokemonAdapter(var pokemons: MutableList<Pokemon>, val listener: fragment_home, context: Context):
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    var pokemonSelecionado: Pokemon? = null


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun fillView(pokemon: Pokemon){
            var cartao = itemView as CardView

            if(pokemon == pokemonSelecionado){
                itemView.txtName.setText(pokemon.name)
                itemView.txtimage.setText(pokemon.imageurl)
                itemView.txtType.setText(pokemon.typeofpokemon)

                itemView.btSave.setOnClickListener {

                    if (pokemonSelecionado != null && pokemonSelecionado!!.id == 0L){
                        pokemon.name = itemView.txtName.text.toString()
                        pokemon.imageurl = itemView.txtimage.text.toString()
                        pokemon.typeofpokemon = itemView.txtType.text.toString()
                        with(this@PokemonAdapter){
                            listener.pokemonSalvar(pokemon)
                        }

                        pokemonSelecionado = null
                        notifyItemChanged(pokemons.indexOf(pokemon))
                    }else{

                        pokemon.name = itemView.txtName.text.toString()
                        pokemon.imageurl = itemView.txtimage.text.toString()
                        pokemon.typeofpokemon = itemView.txtType.text.toString()

                        with(this@PokemonAdapter){
                            listener.pokemonEditar(pokemon)
                        }
                        notifyItemChanged(pokemons.indexOf(pokemon))
                    }
                }
                itemView.btDelete.setOnClickListener {
                    pokemonSelecionado = null

                    with(this@PokemonAdapter){
                        listener.pokemonExcluir(pokemon)
                    }
                    notifyItemRemoved(pokemons.indexOf(pokemon))

                }
            }
            else{
                itemView.txtitulo.text = pokemon.name
                itemView.setOnClickListener {
                    pokemonSelecionado=pokemon
                    notifyItemChanged(pokemons.indexOf(pokemon))
                }
            }
        }
    }

    fun addPokemon(pokemon: Pokemon){
        pokemonSelecionado = pokemon
        pokemons.add(0, pokemon)
        notifyItemInserted(0)
    }

    override fun getItemViewType(position: Int): Int {

        var pokemon=pokemons[position]
        return if(pokemon==pokemonSelecionado)
            R.layout.cartao_edit
        else
            R.layout.cartao_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.fillView(pokemon)
    }

    override fun getItemCount() = pokemons.size

}