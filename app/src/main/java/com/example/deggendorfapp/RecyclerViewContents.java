package com.example.deggendorfapp;

import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewContents {
    private ArrayList<String> recyclerViewList;
    private int position;

    RecyclerViewContents(int position, ArrayList<String> files) {
        recyclerViewList = files;
        this.position = position;
    }



    public String returnRecyclerViewListItemAtIndex() {
        if(recyclerViewList.size() == 0){
            return "No bars";
        }
        else{
            return recyclerViewList.get(position);
        }
    }
}
