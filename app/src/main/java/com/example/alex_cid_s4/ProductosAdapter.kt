package com.example.alex_cid_s4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductosAdapter(private val context: Context, private val productos: List<Producto>) : BaseAdapter() {

    // Devuelve la cantidad de productos en la lista
    override fun getCount(): Int {
        return productos.size
    }

    // Devuelve el producto en una posición específica
    override fun getItem(position: Int): Any {
        return productos[position]
    }

    // Devuelve el ID del ítem en una posición específica (en este caso, la posición misma)
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Devuelve la vista para un ítem en una posición específica
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            // Inflamos el layout para el ítem de la lista
            view = LayoutInflater.from(context).inflate(R.layout.producto_item, parent, false)
            viewHolder = ViewHolder()
            // Referencias a las vistas del layout
            viewHolder.imageView = view.findViewById(R.id.image)
            viewHolder.nombreTextView = view.findViewById(R.id.nombre)
            viewHolder.precioTextView = view.findViewById(R.id.precio)
            // Guardamos el ViewHolder en la vista
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        // Obtenemos el producto en la posición actual
        val producto = getItem(position) as Producto
        // Asignamos los datos del producto a las vistas
        viewHolder.imageView.setImageResource(producto.imagen)
        viewHolder.nombreTextView.text = producto.nombre
        viewHolder.precioTextView.text = "$${producto.precio}"

        return view
    }

    // ViewHolder para almacenar referencias a las vistas de un ítem
    private class ViewHolder {
        lateinit var imageView: ImageView
        lateinit var nombreTextView: TextView
        lateinit var precioTextView: TextView
    }
}

