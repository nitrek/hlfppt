package info.basic.hsdf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class homeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass=Home.class;
        if (id == R.id.nav_home) {
            Toast toast = Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Home.class;
        } else if (id == R.id.nav_aboutus) {
            Toast toast = Toast.makeText(getApplicationContext(), "aboutus", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=AboutUs.class;
        } else if (id == R.id.nav_presence) {
            Toast toast = Toast.makeText(getApplicationContext(), "presence", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Presence.class;
        } else if (id == R.id.nav_work) {
            Toast toast = Toast.makeText(getApplicationContext(), "our work", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Work.class;
        } else if (id == R.id.nav_services) {
            Toast toast = Toast.makeText(getApplicationContext(),"service", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Services.class;
        } else if (id == R.id.nav_photo) {
            Toast toast = Toast.makeText(getApplicationContext(), "photo", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=PhotoAndMedia.class;
        }else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "share data");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            Toast toast = Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Home.class;
        } else if (id == R.id.nav_send) {
            Toast toast = Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Home.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openSite(View v)
    {
        String url = "http://www.hlfppt.org/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
