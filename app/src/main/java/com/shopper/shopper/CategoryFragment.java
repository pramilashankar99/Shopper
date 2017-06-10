package com.shopper.shopper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {


    private GridView grid;
    private CategoryBaseAdapter categoryBaseAdapter;

    private ArrayList<Categories> categoriesArrayList;

    private Integer[] IMAGES = {R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple
    ,R.drawable.apple,R.drawable.apple,R.drawable.apple};

    private String[] TITLE = {"Oral Care","Both and Body","Hair Care","Men Care","Stayfree","Hair Care","Men Care","Stayfree"};
    private String[] QTY = {"42 Products","82 Products","142 Products","32 Products","77 Products","142 Products","32 Products","77 Products"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        grid = (GridView)rootView.findViewById(R.id.grid);

        categoriesArrayList = new ArrayList<Categories>();

        for (int i=0; i< TITLE.length; i++){

            Categories categories = new Categories(IMAGES[i],TITLE[i],QTY[i]);
            categoriesArrayList.add(categories);
        }


        categoryBaseAdapter = new CategoryBaseAdapter(getActivity(), categoriesArrayList);

        grid.setTranscriptMode(GridView.NO_STRETCH);

    //    grid.setTranscriptMode(GridView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        grid.setStackFromBottom(false);

        grid.setAdapter(categoryBaseAdapter);

   //     scrollMyListViewToBottom();


return rootView;


    }



    private void scrollMyListViewToBottom() {
        grid.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                grid.setSelection(categoryBaseAdapter.getCount() - 1);
            }
        });
    }




}
