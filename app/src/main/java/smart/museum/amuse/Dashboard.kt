package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFaM = findViewById<Button>(R.id.btnFaM)
        val btnMNav = findViewById<Button>(R.id.btnMNav)
        val btnQrScanner = findViewById<Button>(R.id.btnQrScanner)
        val btnMYAMUSE = findViewById<Button>(R.id.btnMYAMUSE)

        btnFaM.setOnClickListener{
            val goto_MFinder = Intent(this, MuseumFinder::class.java)
            startActivity(goto_MFinder)
        }

        btnMNav.setOnClickListener{
            val goto_MNav = Intent(this, MuseumNavigator::class.java)
            startActivity(goto_MNav)
        }

        btnQrScanner.setOnClickListener{
            val goto_QR = Intent(this, QrScanner::class.java)
            startActivity(goto_QR)
        }

        btnMYAMUSE.setOnClickListener{
            val goto_MYAMUSE = Intent(this, MyAMUSE::class.java)
            startActivity(goto_MYAMUSE)
        }
    }
}