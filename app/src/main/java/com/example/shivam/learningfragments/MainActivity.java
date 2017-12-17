package com.example.shivam.learningfragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.shivam.learningfragments.dummy.CategoryContent;
import com.example.shivam.learningfragments.utils.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{

    TinyDB tinyDB;
    List<CategoryContent.CategoryItem> sports;

    //The main data would be stored in the shared preferences of the app
    //which would be updated from here
    //Basic Approach:
    //First Fragment shows the list of the catogaries, when the radio buttons in the catogaries are selected, each of those is added
    //
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Tweets");
                    FragmentOne fragmentOne = new FragmentOne();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame,fragmentOne,"First Fragment");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    setTitle("Second Fragment");
                    FragmentTwomain fragmenttwo = new FragmentTwomain();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame,fragmenttwo,"Second Fragment");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    setTitle("Third Fragment");
                   // FragmentThree fragmentthree = new FragmentThree();
                    //FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    //fragmentTransaction2.replace(R.id.frame,fragmentthree,"Third Fragment");
                    //fragmentTransaction2.commit();
                    ItemFragment itemFragment = new ItemFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame,itemFragment,"Third Fragment");
                    fragmentTransaction2.commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this,SplashScreen.class);
        startActivity(intent);
        setContentView(R.layout.activity_main);
        setTitle("First Fragment");
        tinyDB = new TinyDB(MainActivity.this);
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragmentOne,"First Fragment");
        fragmentTransaction.commit();
        sports = new ArrayList<>();
        sports.add(CategoryContent.CATEGORY_ITEMS.get(0));
        sports.add(CategoryContent.CATEGORY_ITEMS.get(12));
        sports.add(CategoryContent.CATEGORY_ITEMS.get(6));
        sports.add(CategoryContent.CATEGORY_ITEMS.get(5));
        mTextMessage = (TextView) findViewById(R.id.message);
        ArrayList<CategoryContent.CategoryItem> cti = new ArrayList<>();
        tinyDB.putObject("my_obj",CategoryContent.CATEGORY_ITEMS.get(0));
        MyModelTest my= new MyModelTest("shivam",13538l);
        my.setMp("sports",sports);
        tinyDB.putObject("my_model",my);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(CategoryContent.CategoryItem item) {
        Log.e("My tag : ",item.content);
        FragmentTwomain fragmentTwomain = new FragmentTwomain();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragmentTwomain,"Seconn Fragment Again");
        fragmentTransaction.commit();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the fragment, which will then pass the result to the login
        // button.
        Fragment fragment = getFragmentManager().findFragmentById(R.id.frame);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }


}
