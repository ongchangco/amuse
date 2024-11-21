package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogIn = findViewById<Button>(R.id.btnLogin)
        val btnReg = findViewById<Button>(R.id.btnRegister)

        btnLogIn.setOnClickListener{
            val goto_Login = Intent(this, LogIn::class.java)
            startActivity(goto_Login)
        }

        btnReg.setOnClickListener{
            val goto_Register = Intent(this, Register::class.java)
            startActivity(goto_Register)
        }
    }
}