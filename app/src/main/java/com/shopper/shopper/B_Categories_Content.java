package com.shopper.shopper;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class B_Categories_Content extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_categories_content);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);

        title = (TextView) findViewById(R.id.title);

        tabLayout.addTab(tabLayout.newTab().setText("Fresh"));
        tabLayout.addTab(tabLayout.newTab().setText("Personal Care"));
        tabLayout.addTab(tabLayout.newTab().setText("Grocery"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        final CategoryPagerAdapter adapter = new CategoryPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                switch (tab.getPosition()){

                    case 0 :

                        title.setText("FRESH");

                        break;


                    case 1 :

                        title.setText("PERSONAL CARE");

                        break;


                    case 2 :

                        title.setText("GROCERY");

                        break;


                    case 3 :

                        title.setText("HOME");

                        break;


                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
