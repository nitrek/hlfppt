package info.basic.hsdf;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;

import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Work_Details extends AppCompatActivity {

    private static String gSectionNumber;
    private static String sectionList[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__details);

        Intent intent = getIntent();
       // intent.getIntExtra(homeScreen.EXTRA_MESSAGE,sectionNumber);
        gSectionNumber=intent.getStringExtra(homeScreen.EXTRA_MESSAGE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Toast.makeText(this,gSectionNumber,Toast.LENGTH_LONG).show();
        sectionList= new String[]{
                "Maternal and Child health",
                "Adolescent Health",
                "Family Planning",
                "HIV/AIDS",
                "Wellness(Nutrition/DIC)",
                "Corporate Social Responsibility(CSR)",
                "Strategic Partnership",
                "Knowledge Management"
        };
        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),sectionList
                ));
        spinner.setSelection(Integer.parseInt(gSectionNumber));
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(Integer.parseInt(gSectionNumber)))
                        .commit();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text");
                int sectionData[] = new int[]{R.raw.maternal,R.raw.adolecent,R.raw.family,R.raw.hiv,R.raw.family,R.raw.csr,R.raw.strategic,R.raw.knowledge};
                try{
                    sendIntent.putExtra(Intent.EXTRA_TEXT, sectionList[Integer.parseInt(gSectionNumber)-1]+"\n"+Html.fromHtml(readFromAssets(getApplicationContext(),sectionData[Integer.parseInt(gSectionNumber)-1]))+"\nRead More at http://www.hlfppt.org/");
                }
                catch (Exception e)
                {
                    sendIntent.putExtra(Intent.EXTRA_TEXT,getPackageName());

                }
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_work__details, menu);
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


    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            gSectionNumber = Integer.toString(sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_work__details, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_heading);
            int sectionData[] = new int[]{R.raw.maternal,R.raw.adolecent,R.raw.family,R.raw.hiv,R.raw.family,R.raw.csr,R.raw.strategic,R.raw.knowledge};
            textView.setText(sectionList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            textView.setAllCaps(true);
            textView.setTextSize(20);
            textView = (TextView) rootView.findViewById(R.id.section_content);
            try{
                textView.setText(Html.fromHtml(readFromAssets(getContext(),sectionData[getArguments().getInt(ARG_SECTION_NUMBER)-1])));
            }
            catch (Exception e)
            {
            }
            int sectionImages[] = new int[]{R.drawable.maternal_child_health_1,R.drawable.adolescent_health_1,R.drawable.family_planning_1,R.drawable.hiv_control_1,R.drawable.wellness,R.drawable.csr_1,R.drawable.strategic_partnership_1,R.drawable.knowledge_management_1};
            ImageView imageView = (ImageView) rootView.findViewById(R.id.section_photo);
            imageView.setBackgroundResource(sectionImages[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            return rootView;
        }

    }
    public static String readFromAssets(Context context,int resourceId) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(resourceId)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
