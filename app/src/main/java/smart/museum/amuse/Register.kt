package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSignUpFP = findViewById<Button>(R.id.btnSignUpFP)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnSignUpFP.setOnClickListener{
            val goto_MLogin = Intent(this, LogIn::class.java)
            startActivity(goto_MLogin)
        }

        btnLogin.setOnClickListener{
            val goto_MLogin = Intent(this, LogIn::class.java)
            startActivity(goto_MLogin)
        }
    }
}