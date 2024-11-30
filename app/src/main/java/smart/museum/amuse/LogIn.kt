package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogIn : AppCompatActivity() {

    lateinit var uInput : EditText
    lateinit var pInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLoginFP = findViewById<Button>(R.id.btnLoginFP)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnLoginFP.setOnClickListener{
            val goto_MDashboard = Intent(this, Dashboard::class.java)
            startActivity(goto_MDashboard)
        }

        btnSignUp.setOnClickListener{
            val goto_Register = Intent(this, Register::class.java)
            startActivity(goto_Register)
        }

        val username = uInput.text.toString()
            val password = pInput.text.toString()
            Log.i("Credentials", "Username : $username and Password : $password")

        }
    }