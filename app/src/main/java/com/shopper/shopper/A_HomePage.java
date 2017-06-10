package com.shopper.shopper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

public class A_HomePage extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    private ExpandableHeightListView listview;
    private ArrayList<OffersBean> Bean;
    private OffersBaseAdapter baseAdapter;
    private SliderLayout mDemoSlider;
    private Context context;

    //    *****offers near you*******
    private int[] discount_image = {R.drawable.offer_img, R.drawable.offer_img, R.drawable.offer_img, R.drawable.offer_img, R.drawable.offer_img, R.drawable.offer_img};
    private String[] rest_name = {"Hotel Surya", "Hotel Surya", "Hotel Surya", "Hotel Surya", "Hotel Surya", "Hotel Surya"};
    private String[] condi_text = {"On Billing Ammount", "On Billing Ammount", "On Billing Ammount", "On Billing Ammount", "On Billing Ammount", "On Billing Ammount"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_home_page);


        //        ********quick return a_homepage_toolbar***********
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ObservableScrollView mAObservableScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);
        View placeholderView = findViewById(R.id.placeholder);
        QuickReturnHandler.setup(toolbar, placeholderView, mAObservableScrollView);


        //        ********Slider Offer***********

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        // used when fetching from url
        // HashMap<String,String> url_maps = new HashMap<String, String>();
        // url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        // url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        // url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        // url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        //************************************OR*********************************

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("A", R.drawable.fix_img);
        file_maps.put("B", R.drawable.offer_img);
        file_maps.put("C", R.drawable.fix_img);
        file_maps.put("D", R.drawable.offer_img);
        file_maps.put("E", R.drawable.fix_img);
        file_maps.put("F", R.drawable.offer_img);


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);

            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
            mDemoSlider.setDuration(3000);
            mDemoSlider.addOnPageChangeListener(this);
        }


        //        ********LISTVIEW (Offer near you)***********
        listview = (ExpandableHeightListView) findViewById(R.id.listview);
        Bean = new ArrayList<OffersBean>();
        for (int i = 0; i < 3; i++) {
            OffersBean bean = new OffersBean(discount_image[i], rest_name[i], condi_text[i]);
            Bean.add(bean);
        }
        baseAdapter = new OffersBaseAdapter(A_HomePage.this, Bean) {
        };
        listview.setAdapter(baseAdapter);
    }



    public void freshcategoryOnClick(View view){
        Intent i= new Intent(this,B_Categories_Content.class);
        startActivity(i);
    }







    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}




}
