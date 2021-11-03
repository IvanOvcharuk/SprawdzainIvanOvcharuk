package com.example.sprawdzainivanovcharuk

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sprawdzainivanovcharuk.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        var liczba1 = 0;
        var liczba2 = 0;
        var odpowiedz = 0;

        findViewById<Button>(R.id.zast).setOnClickListener {
            findViewById<TextView>(R.id.textView).text = findViewById<TextInputEditText>(R.id.wprowadzenie).text
        }
        findViewById<Button>(R.id.dod).setOnClickListener {
            findViewById<TextView>(R.id.textView).text = findViewById<TextView>(R.id.textView).text.toString() + findViewById<TextInputEditText>(R.id.wprowadzenie).text.toString()
        }
        findViewById<Button>(R.id.dodawanie).setOnClickListener {
            liczba1 = findViewById<EditText>(R.id.Pierwszaliczba).text.toString().toInt()
            liczba2 = findViewById<EditText>(R.id.Drugaliczba).text.toString().toInt()
            odpowiedz = liczba1 + liczba2
            findViewById<TextView>(R.id.textView).text = odpowiedz.toString()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}