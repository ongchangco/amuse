package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogIn : AppCompatActivity() {

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
            val goto_Login = Intent(this, Dashboard::class.java)
            startActivity(goto_Login)
        }
        btnSignUp.setOnClickListener{
            val goto_Register = Intent(this, Register::class.java)
            startActivity(goto_Register)
        }
    }
}