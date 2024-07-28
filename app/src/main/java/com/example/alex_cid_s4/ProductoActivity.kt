package com.example.alex_cid_s4

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_producto)

        // Ajuste de padding para los insets del sistema (barra de estado, navegación, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtención del producto desde el intent
        val producto = intent.getSerializableExtra("producto") as Producto

        // Referencias a las vistas del layout
        val nombreTextView: TextView = findViewById(R.id.nombre_producto)
        val precioTextView: TextView = findViewById(R.id.precio_producto)
        val detallesTextView: TextView = findViewById(R.id.detalles_producto)
        val imagenView: ImageView = findViewById(R.id.imagen)

        // Asignación de los datos del producto a las vistas
        nombreTextView.text = producto.nombre
        precioTextView.text = "$${producto.precio}"
        detallesTextView.text = producto.descripcion
        imagenView.setImageResource(producto.imagen)

        // Manejo del clic en el botón de regresar
        val botonRegresar: Button = findViewById(R.id.boton_regresar)
        botonRegresar.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior
        }
    }
}

