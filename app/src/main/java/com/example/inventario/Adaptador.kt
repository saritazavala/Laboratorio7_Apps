package com.example.inventario

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/*
*Sara Nohemi Zavala Gutierrez
 * Carnet: 18893
 * Laboratorio 7
 * Aplicaciones Mobiles
  * */

class Adaptador(var arr: ArrayList<Carta>): RecyclerView.Adapter<Adaptador.ViewHolder>(){



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var holi = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)
        return ViewHolder(holi)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(p0: Adaptador.ViewHolder, p1: Int) {
        p0.bindItem(arr[p1])
    }

    //Este codigo fue basado en los ejemplos que se ven en las clases de video dadas
//Aqui se crea el recyclerView y se utiliza databinding


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItem(data:Carta){


            val Menos: Button = itemView.findViewById(R.id.quitar)
            val Mas: Button = itemView.findViewById(R.id.agregar)
            val cantidad: TextView = itemView.findViewById(R.id.cantidad)
            val nombre: TextView = itemView.findViewById(R.id.NombreN)
            cantidad.text = data.cantidad.toString()
            nombre.text = data.producto.nombre





            //Si se presiona el boton de mas se le resta uno al contador del prodcuto
            Menos.setOnClickListener(){
                if(data.cantidad!=0){
                    var num = data.cantidad-1
                    data.cantidad = num
                    cantidad.text=num.toString()
                }
            }


            //Si se presiona el boton de mas se le suma uno al contador del prodcuto
            Mas.setOnClickListener(){
                var num = data.cantidad+1
                data.cantidad = num
                cantidad.text=num.toString()
            }



        }
    }
}