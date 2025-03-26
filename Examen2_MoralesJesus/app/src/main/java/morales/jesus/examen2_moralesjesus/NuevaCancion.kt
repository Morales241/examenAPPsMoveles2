package morales.jesus.examen2_moralesjesus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NuevaCancion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nueva_cancion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtTituloAgregarCancion: TextView = findViewById(R.id.txtTituloAgregarCancion)
        val txtArtistaAgregarCancion: EditText = findViewById(R.id.txtArtistaAgregarCancion)
        val txtNombreAgregarCancion: EditText = findViewById(R.id.txtNombreAgregarCancion)
        val txtAlbumAgregarCancion: EditText = findViewById(R.id.txtAlbumAgregarCancion)
        val txtDuracionAgregarCancion: EditText = findViewById(R.id.txtDuracionAgregarCancion)
        val btnagregar: Button = findViewById(R.id.btnagregarCancion)


        btnagregar.setOnClickListener {
            MainActivity.canciones.add(
                cancion(
                    txtNombreAgregarCancion.text.toString(),
                    txtArtistaAgregarCancion.text.toString(),
                    txtDuracionAgregarCancion.text.toString(),
                    txtAlbumAgregarCancion.text.toString(),
                )
            )
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}