package com.example.alex_cid_s4

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listaProductos: MutableList<Producto>
    private lateinit var adapter: ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstraintLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val producto1 = Producto("Camara 1", 100.0, "Camara Año 2020", R.drawable.cam)
        val producto2 = Producto("Camara 2", 200.0, "Camara Año 2021", R.drawable.cam2)
        val producto3 = Producto("Camara 3", 300.0, "Camara Año 2022", R.drawable.cam3)
        val producto4 = Producto("Camara 4", 400.0, "Camara Año 2023", R.drawable.cam4)

        listaProductos = mutableListOf(producto1, producto2, producto3, producto4)

        adapter = ProductosAdapter(this, listaProductos)

        val listView: ListView = findViewById(R.id.lista)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

        // Registrar el ListView para el menú contextual
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: android.view.View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as android.widget.AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.eliminar -> {
                // Eliminar el producto seleccionado
                listaProductos.removeAt(info.position)
                adapter.notifyDataSetChanged()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}


