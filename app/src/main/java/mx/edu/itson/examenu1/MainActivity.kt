package mx.edu.itson.examenu1

// Ruben Alejandro Saldaña Beltran
// ID: 00000216100
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de variables
    lateinit var etC: EditText
    lateinit var etF: EditText
    lateinit var etK: EditText
    lateinit var btnGC: Button
    lateinit var btnGF: Button
    lateinit var btnGK: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etC = findViewById(R.id.etC)
        etF = findViewById(R.id.etF)
        etK = findViewById(R.id.etK)
        btnGC = findViewById(R.id.btnGC)
        btnGF = findViewById(R.id.btnGF)
        btnGK = findViewById(R.id.btnGK)

        // Boton que nos servira para convertir los datos a celcius.
        btnGC.setOnClickListener {
            try {
                if (etF.text.isNotEmpty()) {
                    val f = etF.text.toString().toDouble()
                    val c = (f - 32) / 1.8
                    etC.setText(String.format("%.2f", c))
                    etF.text.clear() // borramos el dato que se ingreso en el origen para evitar confuciones.
                }
                else if (etK.text.isNotEmpty()) {
                    val k = etK.text.toString().toDouble()
                    val c = k - 273.15
                    etC.setText(String.format("%.2f", c))
                    etK.text.clear() // borramos el dato que se ingreso en el origen para evitar confuciones.
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }

        // --- Boton para convertir a farenheits ---
        btnGF.setOnClickListener {
            try {
                if (etC.text.isNotEmpty()) {
                    val c = etC.text.toString().toDouble()
                    val f = (c * 1.8) + 32
                    etF.setText(String.format("%.2f", f))
                    etC.text.clear()// borramos el dato que se ingreso en el origen para evitar confuciones.
                }
                else if (etK.text.isNotEmpty()) {
                    val k = etK.text.toString().toDouble()
                    val f = (9 * (k - 273.15) / 5) + 32
                    etF.setText(String.format("%.2f", f))
                    etK.text.clear() // borramos el dato que se ingreso en el origen para evitar confuciones.
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }

        // --- Boton para convertir a kelvin---
        btnGK.setOnClickListener {
            try {
                if (etC.text.isNotEmpty()) {
                    val c = etC.text.toString().toDouble()
                    val k = c + 273.15
                    etK.setText(String.format("%.2f", k))
                    etC.text.clear()
                }
                else if (etF.text.isNotEmpty()) {
                    val f = etF.text.toString().toDouble()
                    val k = (5 * (f - 32) / 9) + 273.15
                    etK.setText(String.format("%.2f", k))
                    etF.text.clear() // borramos el dato que se ingreso en el origen para evitar confuciones.
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}