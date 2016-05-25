package info.basic.hsdf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;
import java.util.List;

public class homeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private SliderLayout sliderShow;
    public final static String EXTRA_MESSAGE = "info.basic.hsdf.MESSAGE";
    static int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feedback", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = null; Class fragmentClass=Home.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout container = (LinearLayout) findViewById(R.id.content_frame);
        createHome(inflater,container);
    }
    public void createHome(LayoutInflater inflater, LinearLayout container)
    {
        inflater.inflate(R.layout.home, container);
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Prosperous Communities", "http://www.hlfppt.org/images/banner1.jpg");
        url_maps.put("Reproductive & Child Healthcare", "http://www.hlfppt.org/images/banner2.jpg");
        url_maps.put("Safe Motherhood", "http://www.hlfppt.org/images/banner3.jpg");
        url_maps.put("First Five Years", "http://www.hlfppt.org/images/banner4.jpg");
        url_maps.put("Healthy Future", "http://www.hlfppt.org/images/banner5.jpg");
        sliderShow = (SliderLayout) findViewById(R.id.slider);
        for(String name : url_maps.keySet()){
            DefaultSliderView sliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            sliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sliderShow.addSlider(sliderView);
            sliderShow.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        //   Toast toast = Toast.makeText(getApplicationContext(), "loding"+name, Toast.LENGTH_SHORT);
            //   toast.show();
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.infoTabs1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        List<InformationHome> informationHome=InformationHome.initializeData();
        InformationHomeAdapter informationHomeAdapter = new InformationHomeAdapter(informationHome);
        recyclerView.setAdapter(informationHomeAdapter);


        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.partners);
        recyclerView1.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);
        List<InformationHomePartner> informationHomePartner=InformationHomePartner.initializeData();
        InformationHomePartnersAdapter informationHomePartnerAdapter = new InformationHomePartnersAdapter(informationHomePartner);
        recyclerView1.setAdapter(informationHomePartnerAdapter);
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
       Fragment fragment = null; Class fragmentClass=Home.class;
        LayoutInflater inflater = getLayoutInflater();
       LinearLayout container = (LinearLayout) findViewById(R.id.content_frame);
        if (id == R.id.nav_home) {
            Toast toast = Toast.makeText(getApplicationContext(), "home", Toast.LENGTH_SHORT);
            toast.show();
        // fragmentClass=Home.class;
            container.removeAllViews();
             createHome(inflater,container);
             toast = Toast.makeText(getApplicationContext(), "loded", Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.nav_aboutus) {
            Toast toast = Toast.makeText(getApplicationContext(), "aboutus", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=AboutUs.class;
            container.removeAllViews();
         //   inflater.inflate(R.layout.about_us, container);
        } else if (id == R.id.nav_presence) {
            Toast toast = Toast.makeText(getApplicationContext(), "presence", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Presence.class;
           container.removeAllViews();
          //  inflater.inflate(R.layout.presence, container);
        } else if (id == R.id.nav_work) {
            Toast toast = Toast.makeText(getApplicationContext(), "our work", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Work.class;
            container.removeAllViews();
           // inflater.inflate(R.layout.work, container);
        } else if (id == R.id.nav_services) {
            Toast toast = Toast.makeText(getApplicationContext(),"service", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Services.class;
            container.removeAllViews();
            //inflater.inflate(R.layout.service, container);
        } else if (id == R.id.nav_photo) {
            Toast toast = Toast.makeText(getApplicationContext(), "photo", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=PhotoAndMedia.class;
            container.removeAllViews();
            //inflater.inflate(R.layout.photo, container);
        }else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "share data");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            Toast toast = Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Home.class;
            container.removeAllViews();

        } else if (id == R.id.nav_send) {
            Toast toast = Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_SHORT);
            toast.show();
            fragmentClass=Home.class;
            container.removeAllViews();

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
       Intent intent = new Intent(this, Work_Details.class);

        switch(i%5)
        {
            case 0:   intent.putExtra(EXTRA_MESSAGE,"0");break;
            case 1:   intent.putExtra(EXTRA_MESSAGE,"1");break;
            case 2:   intent.putExtra(EXTRA_MESSAGE,"2");break;
            case 3:   intent.putExtra(EXTRA_MESSAGE,"3");break;
            case 4:   intent.putExtra(EXTRA_MESSAGE,"4");break;
        }
        startActivity(intent);

    }
    public void slidePrevious(View v)
    {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.infoTabs1);
        i++;
        recyclerView.smoothScrollToPosition(i%5);

    }
    public void slideNext(View v)
    {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.infoTabs1);
        i--;
        recyclerView.smoothScrollToPosition(i%5);

    }
    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
