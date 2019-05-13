package com.example.inventario

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_lista.*
import android.app.Activity
import android.content.Intent
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

/*
*Sara Nohemi Zavala Gutierrez
 * Carnet: 18893
 * Laboratorio 7
 * Aplicaciones Mobiles
  * */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)


        var productos = Inventario.globalInventario

        var cajasCerveza= Producto("Cajas de Cerveza", "Cajas de Cerveza")
        var producto1 = Carta(cajasCerveza,0)
        productos.add(producto1)

        var papaplinas= Producto("Papalinas", "Papalinas")
        var producto2 = Carta(papaplinas,8)
        productos.add(producto2)

        var gaseosas = Producto("Gaseosa", "Gaseosas")
        var producto3 = Carta(gaseosas ,25)
        productos.add(producto3)




        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)




    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                val intento: Intent = Intent(this, Hola::class.java)
                startActivity(intento)

            }
            R.id.nav_gallery -> {
                val intento: Intent = Intent(this, Hola::class.java)
                startActivity(intento)

            }


        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


  //Flechita para regresar
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController((R.id.myNavHostFragment))
        return navController.navigateUp()
    }
}
