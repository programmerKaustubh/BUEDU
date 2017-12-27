package com.kmema.android.buedu;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.kmema.android.buedu.Courses.CourseFragment;
import com.kmema.android.buedu.Information.InformationFragment;
import com.kmema.android.buedu.Suggestion.SuggestionFragment;

public class MainActivity extends AppCompatActivity {


    private FragmentManager mFragmentManager = getFragmentManager();
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch(item.getItemId())
            {
                case R.id.navInformation:
                    InformationFragment informationFragment = new InformationFragment();
                    mFragmentManager.beginTransaction().replace(R.id.containerLayout, informationFragment, informationFragment.getTag()).commit();
                    return true;

                case R.id.navListCourses:
                    CourseFragment courseFragment = new CourseFragment();
                    mFragmentManager.beginTransaction().replace(R.id.containerLayout, courseFragment, courseFragment.getTag()).commit();
                    return true;

                case R.id.navSuggestion:
                    SuggestionFragment suggestionFragment = new SuggestionFragment();
                    mFragmentManager.beginTransaction().replace(R.id.containerLayout,suggestionFragment, suggestionFragment.getTag()).commit();
                    Toast.makeText(MainActivity.this, "Suggestion", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navBottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        InformationFragment informationFragment = new InformationFragment();
        mFragmentManager.beginTransaction().replace(R.id.containerLayout, informationFragment, informationFragment.getTag()).commit();
    }
}
