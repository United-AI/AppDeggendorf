package com.example.deggendorfapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RecyclerViewContents extends AppCompatActivity {
    private String[] recyclerViewList;
    private int position;
    private AppCompatActivity appCompatActivity;


    RecyclerViewContents(int position) {
        recyclerViewList = new String[]{"Option 0", "Option 1", "Option 2", "Option 3", "Option 4", "Option 5",
                "Option 6", "Option 7", "Option 8", "Option 9"};
        this.position = position;
    }

    public RecyclerViewContents(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public String returnRecyclerViewListItemAtIndex() {
        return recyclerViewList[position];
    }

    void actionWhenClicked(int clickedParameter) {
        switch (clickedParameter) {
            case 0:
                appCompatActivity.setContentView(R.layout.distance_from_bars);
                break;
            case 1:
                appCompatActivity.setContentView(R.layout.activity_maps);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
