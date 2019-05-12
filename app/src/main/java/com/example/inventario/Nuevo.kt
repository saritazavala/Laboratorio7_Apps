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





        /*
        Al presionar add se crea una nueva instancia de una fila que se añade a la lista global
         */
        binding.add.setOnClickListener(){ view:View->
            val nuenom = binding.editText.text.toString()
            val nueid = binding.editText2.text.toString()
            var lista = Inventario.globalInventario
            val pro = Producto(nuenom,nueid)
            var fi = Carta(pro,0)
            lista.add(fi)
            Navigation.findNavController(view).navigate(R.id.action_nuevo_to_fragmentoLista)
        }
        return binding.root
    }
}
