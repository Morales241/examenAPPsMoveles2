package morales.jesus.examen2_moralesjesus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleCancion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_cancion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contenedorDetalle: LinearLayout = findViewById(R.id.contenedorDetalle)
        val btnRegresar: Button = findViewById(R.id.btnRegresar)
        val txtTitulo: TextView = findViewById(R.id.txtTitulo)
        val txtNombre: TextView = findViewById(R.id.txtNombre)
        val txtAlbum: TextView = findViewById(R.id.txtAlbum)
        val txtDuracion: TextView = findViewById(R.id.txtDuracion)
        val btnPlay: Button = findViewById(R.id.btnPlay)
        val btnEliminar: Button = findViewById(R.id.btnEliminar)

        val titulo = intent.getStringExtra("nombre")
        val nombre = intent.getStringExtra("artista")
        val album = intent.getStringExtra("album")
        val duracion = intent.getStringExtra("duracion")

        txtTitulo.text = titulo
        txtNombre.text = nombre
        txtAlbum.text = album
        txtDuracion.text = duracion

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}