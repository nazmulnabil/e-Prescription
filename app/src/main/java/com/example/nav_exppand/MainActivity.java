package com.example.nav_exppand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
   List<String> listDataHeader;
   List<Integer> listiconHeader;
   List<Drawable> listchildicon;
   private HashMap<String, List<String>> listDataChild;
   ExpandableListView expListView ;
   NavigationView navigationView;
    private List_Adapter list_adapter;


    DrawerLayout drawer;
ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        prepare_data();

        list_adapter = new List_Adapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(list_adapter);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        enableExpandableList();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                    new Dashboard()).commit();






        }




}

    private void prepare_data(){

        //adding group
        listDataHeader.add("Dashboard");
        listDataHeader.add("Prescription");
        listDataHeader.add("Readyymade Prescription");
        listDataHeader.add("Patient Info");


       //adding child
        List<String> first= new ArrayList<>();
        first.add(" ");
        List<String> top = new ArrayList<>();
        top.add("Prescription");
        top.add("Prescription History");



        List<String> mid = new ArrayList<String>();
        mid.add("Create Readymade Prescription");
        mid.add("Listing Readymade Prescription");


        List<String> bottom = new ArrayList<>();
        bottom.add("Add patient");
        bottom.add("View Patient");
        bottom.add("Create Patient Basic Info");
        bottom.add("Patient Basic History");



        listDataChild.put(listDataHeader.get(0),first);
        listDataChild.put(listDataHeader.get(1),top );
        listDataChild.put(listDataHeader.get(2), mid);
        listDataChild.put(listDataHeader.get(3),bottom);



        //adding group icon

         listiconHeader.add(R.drawable.dashboard);
         listiconHeader.add(R.drawable.notepad);
         listiconHeader.add(R.drawable.dashboard);
         listiconHeader.add(R.drawable.person_add_24);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        listiconHeader=new ArrayList<Integer>();
        listchildicon=new ArrayList<>();
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        expListView = (ExpandableListView) findViewById(R.id.explv);
       navigationView=findViewById(R.id.nav_view);













    }

    private void enableExpandableList() {




        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });



        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(groupPosition==0)
                    drawer.closeDrawer(GravityCompat.START);

                    return false;
            }
        });



        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {


            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                // Temporary code:

                String child = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                switch (listDataHeader.get(groupPosition)) {

                    case "Dashboard": {
                        if (child.equals("")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Dashboard()).commit();
                            Log.d("key","after click view ");
                        }

                    }
                    break;

                    case "Prescription" : {
                        if (child.equals("Prescription")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Prescription()).commit();
                            Log.d("key","after click view ");

                        } else if (child.equals("Prescription History")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new prescription_history()).commit();
                            Log.d("key","after click view ");
                        }

                    }
                    break;

                    case "Readyymade Prescription": {
                        if (child.equals("Create Patient Basic Info")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Create_readymade_prescription()).commit();

                        } else if (child.equals("Listing Readymade Prescription")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Listing_readymade()).commit();

                        }

                    }
                    break;

                    case "Patient Info": {
                        if (child.equals("Add patient")) {
                            Log.d("tag","before  click view ");

                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Add_patient()).commit();

                            Log.d("tag","before  click view ");


                        } else if (child.equals("View Patient")) {



                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new View_patient()).commit();
                            Log.d("key","after click view ");


                        } else if (child.equals("Create Patient Basic Info")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new Cpbi()).commit();
                        } else if (child.equals("Patient Basic History")) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameid,
                                    new patient_history()).commit();
                        }
                    }
                    break;


                }

                drawer.closeDrawer(GravityCompat.START);
                return false;

            }
        });






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    @Override
    public void onBackPressed() {
       if(drawer.isDrawerOpen(GravityCompat.START)){

           drawer.closeDrawer(GravityCompat.START);
       }
         else {

           super.onBackPressed();

       }
    }
}





