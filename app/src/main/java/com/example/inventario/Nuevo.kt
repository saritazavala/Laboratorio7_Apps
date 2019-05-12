package com.example.inventario

import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import  com.example.inventario.databinding.FragmentNuevoBinding

import kotlinx.android.synthetic.main.fragment_nuevo.view.*



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Nuevo : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentNuevoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_nuevo, container, false)

        binding.aAdir.setOnClickListener(){ view:View->
            val nuenom = binding.NuevoNombre.text.toString()
            val nueid = binding.NuevoCodigo.text.toString()
            var lista = Registro.globalRegistro
            val pro = Producto(nuenom,nueid)
            var fi = Carta(pro,0)
            lista.add(fi)
            Navigation.findNavController(view).navigate(R.id.action_lista_fragment_to_mainActivity)
        }
        return binding.root
    }
}
