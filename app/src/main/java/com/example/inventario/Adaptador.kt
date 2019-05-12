package com.example.inventario

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Adaptador(var lista: ArrayList<Carta>): RecyclerView.Adapter<Adaptador.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var v = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: Adaptador.ViewHolder, p1: Int) {
        p0.bindItem(lista[p1])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItem(data:Carta){
            val nombre: TextView = itemView.findViewById(R.id.nomProducto)
            val cant: TextView = itemView.findViewById(R.id.cantidad)
            nombre.text = data.producto.nombre
            cant.text = data.cantidad.toString()
            val mas: Button = itemView.findViewById(R.id.Mas)
            val menos: Button = itemView.findViewById(R.id.Menos)
            /*
            Sumar al contador 1, independiente para cada cardview
             */
            mas.setOnClickListener(){
                var num = data.cantidad+1
                data.cantidad = num
                cant.text=num.toString()
            }
            /*
            Restar al contador 1, independiente para cada cardview
             */
            menos.setOnClickListener(){
                if(data.cantidad!=0){
                    var num = data.cantidad-1
                    data.cantidad = num
                    cant.text=num.toString()
                }
            }
        }
    }
}