package edu.msudenver.cs3013.navigationdrawer;
import android.os.Bundle;
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.*;
import com.google.android.material.navigation.NavigationView;


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment;
        val navController = navHostFragment.navController;
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_recent, R.id.nav_favorites,
                R.id.nav_archive, R.id.nav_bin, R.id.nav_chromatic_tuner
            ),
            findViewById(R.id.drawer_layout));
        setupActionBarWithNavController(navController, appBarConfiguration);
        findViewById<NavigationView>(R.id.nav_view)?.setupWithNavController(navController);

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment);
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp();
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }


}
