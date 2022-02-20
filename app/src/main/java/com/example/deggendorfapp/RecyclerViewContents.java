package com.example.deggendorfapp;

public class RecyclerViewContents {
    private String[] recyclerViewList;
    private int position;

    RecyclerViewContents(int position) {
        recyclerViewList = new String[]{"Option 0", "Option 1", "Option 2", "Option 3", "Option 4", "Option 5",
                "Option 6", "Option 7", "Option 8", "Option 9"};
        this.position = position;
    }

    public String returnRecyclerViewListItemAtIndex() {
        return recyclerViewList[position];
    }
}
