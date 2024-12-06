package smart.museum.amuse

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MuseumFinder : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var  googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_museum_finder)
        setSupportActionBar(findViewById(R.id.navBar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

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
            R.id.menuMNav -> {
                val intent = Intent(this, MuseumNavigator::class.java)
                startActivity(intent)
            }
            R.id.menuMYAMUSE -> {
                val intent = Intent(this, MyAMUSE::class.java)
                startActivity(intent)
            }
            R.id.menuLogOut -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Add a marker and move the camera
        val location = LatLng(14.5833, 120.9822)
        googleMap.addMarker(MarkerOptions().position(location).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
    }
}

