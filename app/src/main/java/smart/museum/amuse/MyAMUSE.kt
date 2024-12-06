package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyAMUSE : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_amuse)
        setSupportActionBar(findViewById(R.id.navBar))
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    val spinner = findViewById<Spinner>(R.id.spinner)
    val items = listOf("The National Museum","Museo de la Roma")
    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
    spinner.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_bar,menu)
        return true
    }
    //Menu Item event
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.btnQR -> {
                val intent = Intent(this, QrScanner::class.java)
                startActivity(intent)
            }
            R.id.menuDashboard -> {
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }
            R.id.menuMFinder -> {
                val intent = Intent(this, MuseumFinder::class.java)
                startActivity(intent)
            }
            R.id.menuMNav -> {
                val intent = Intent(this, MuseumNavigator::class.java)
                startActivity(intent)
            }
            R.id.menuLogOut -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}