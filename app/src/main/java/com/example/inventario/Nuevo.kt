package com.example.inventario

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Nuevo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        val binding: com.example.inventario.databinding.FragmentNuevoBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_nuevo, container, false
        )
        //Se toman los datos ingresados y se utlizan para crear un nuevo Producto
        binding.add.setOnClickListener(){ view:View->

            var lista = Inventario.globalInventario
            //LISTA GLOBAL

            //SE PIDEN LOS DATOS DEL PRODUCTO
            val codigo = binding.IngresarCodigo.text.toString()
            val nombre = binding.IngresarNombre.text.toString()
            //SE PASAN A TEXTO Y LUEGO STRING

            //SE JUNTA EN UN PORDUCTO
            val productofinal = Producto(nombre,codigo)
            //Se agrega con la cantidad inicial 0
            var cartita = Carta(productofinal,0)
            //ADD
            lista.add(cartita)
            //Se regresa
            Navigation.findNavController(view).navigate(R.id.action_nuevo_to_fragmentoRegistro)
        }
        return binding.root
    }
}
