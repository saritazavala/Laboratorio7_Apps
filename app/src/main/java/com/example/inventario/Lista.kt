package com.example.inventario

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.fragment_lista.*
import android.R.attr.data
import android.support.annotation.NonNull
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.Toast
import androidx.navigation.ui.NavigationUI.*
import com.google.zxing.integration.android.IntentResult



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/*
*Sara Nohemi Zavala Gutierrez
 * Carnet: 18893
 * Laboratorio 7
 * Aplicaciones Mobiles
  * */
class Lista : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Se crea nuestra variable de databinding
        val binding:com.example.inventario.databinding.FragmentListaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista, container, false)
        
        
        
        //Se crea un array de cartas
        var array = Inventario.globalInventario //Variable Global

        //Nuestra Lista de Items ----> En un linnear Layout
        binding.listaItems.layoutManager= LinearLayoutManager(context, LinearLayout.VERTICAL,false)
        val adios = Adaptador(array)
        binding.listaItems.adapter = adios
        setHasOptionsMenu(true)
        

        //Si se selecciona el boton con el signo mas, se va a inicializar el scanner QR
        binding.boton.setOnClickListener(){
            val qr = IntentIntegrator(activity) //Actvity nueva
            qr.initiateScan()
        }
        return binding.root


        //Metodo para borrar cuando se desliza
        //Codigo referenciado de internet y documentacion de AndroidStudio

        var helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(@NonNull recyclerView: RecyclerView, @NonNull viewHolder: RecyclerView.ViewHolder, @NonNull viewHolder1: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(@NonNull target: RecyclerView.ViewHolder, p1:Int){
                val position = target.getAdapterPosition()
                array.removeAt(position)
                binding.listaItems.adapter?.notifyDataSetChanged()
            }
        })
        helper.attachToRecyclerView(binding.listaItems)
    }



    //QR: CODIGO QUE TRATA DE LEER EL CODIGO.
    //Esto lo saque del git que Oscar nos dio como ejemplo
    //https://github.com/kmvignesh/QRCodeScanner/blob/master/app/src/main/java/com/example/vicky/qrcodescanner/MainActivity.kt
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }


    // Menu de los tres puntitosde la parte de arriba derecha de la app

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //Si se selecciona la opcion de reiniciar la lista
        if(item?.itemId!!.equals(R.id.reiniciar)){
            var lista = Inventario.globalInventario
            lista.clear()
            listaItems.adapter?.notifyDataSetChanged()
        }

        //Si se pregunta El tamaño de nuestros productos
        if(item.itemId.equals(R.id.actual)){
            Toast.makeText(context, "Los productos Actuales son:", Toast.LENGTH_LONG).show()
        }

        //NavController
        return onNavDestinationSelected(
            item,
            view!!.findNavController()
        )
                || super.onOptionsItemSelected(item)
    }


}
