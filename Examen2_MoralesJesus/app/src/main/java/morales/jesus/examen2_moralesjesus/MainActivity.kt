package morales.jesus.examen2_moralesjesus

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var llave:Boolean = true

    companion object {
        var canciones = ArrayList<cancion>()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (llave){
            carrgarCanciones(canciones)
        }

        var adaptador = GridAdapter(this, canciones)

        var panelPrincipal:LinearLayout = findViewById(R.id.main)

        var grid:GridView = findViewById(R.id.GridPrincipal)

        grid.adapter = adaptador

        var btnAgregar:Button = findViewById(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            val intent = Intent(this, NuevaCancion::class.java)
            startActivity(intent)

        }

    }

    fun carrgarCanciones(items: ArrayList<cancion>){

        items.add(cancion("Rise", "LOL", "3:12", "Worls2018"))
        items.add(cancion("Soñador eterno", "Intocable", "2:57", "Rezare"))
        items.add(cancion("Sentimental", "Joan sebastian", "3:00", "Afortunado"))
    }

    class GridAdapter(val context: Context, val items: ArrayList<cancion>) :
        BaseAdapter() {

        override fun getCount(): Int = items.size

        override fun getItem(position: Int): Any = items[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view =
                convertView ?: LayoutInflater.from(context)
                    .inflate(R.layout.itemgrid, parent, false)
            val txttitulo = view.findViewById<TextView>(R.id.txtNombreItem)
            val txtNombre = view.findViewById<TextView>(R.id.txtArtistaItem)

            txttitulo.text = items[position].nombre
            txtNombre.text = items[position].nombreArtista

            view.setOnClickListener {
                val intent = Intent(context, DetalleCancion::class.java)
                intent.putExtra("nombre", items[position].nombre)
                intent.putExtra("artista", items[position].nombreArtista)
                intent.putExtra("duracion", items[position].duracion)
                intent.putExtra("album", items[position].album)

                context.startActivity(intent)
            }

            return view
        }
    }
}