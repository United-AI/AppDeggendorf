package com.example.deggendorfapp;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ListItemClickListener {

    /*This is the number of items in recycling list
     * If you want to change this, be sure to adapt the size of the array in class RecyclerViewContent
     * An exception for this has yet to be created*/
    private static final int NUMBER_OF_ITEMS_IN_RECYCLING_VIEW = 10;

    private RecyclerView mRecyclerView;
    private TextView distanceFromBars;

    //TextView mErrorMessageDisplay;
    ProgressBar mLoadingIndicator;

    private Adapter mAdapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_items);

        /* This TextView is used to display errors and will be hidden if there are no errors */
        // mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);
        //LinearLayoutManager can support HORIZONTAL or VERTICAL orientations.

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);


        mRecyclerView.setHasFixedSize(true);  //This allows recycler view to do some optimisations on our UI; help avoiding invalidating the whole layout when adapter content changes

        mAdapter = new Adapter(NUMBER_OF_ITEMS_IN_RECYCLING_VIEW, this); //mAdapter: displays each item in list
        mRecyclerView.setAdapter(mAdapter);

        mAdapter = new Adapter(NUMBER_OF_ITEMS_IN_RECYCLING_VIEW, this);
        mRecyclerView.setAdapter(mAdapter); //connecting our adapter to the recycler view

    }

    @Override
    public void onListItemClick(int clickedParameter) {
        if (toast != null) {
            toast.cancel();
        }
        String toastMessage = "Option " + clickedParameter + " was clicked";
        toast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        toast.show();

        //launching of layout distance_from_bars
        if (clickedParameter == 0) {
            distanceFromBars = findViewById(R.id.distance_from_bars);
            setContentView(R.layout.distance_from_bars);
        }
    }
}
/*
 * Use this setting to improve performance if you know that changes in content do not
 * change the child layout size in the RecyclerView
 */
      /*


        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        loadData();



    /*private void loadData() {
        showData();


    }

    private void showData() {
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
      /*  MenuInflater inflater = getMenuInflater();
        /* Use the inflate method to inflate our menu layout to this menu */
        /*inflater.inflate(R.menu.menu, menu);
        /* Return true so that the menu is displayed in the Toolbar */
//return true;
//}

