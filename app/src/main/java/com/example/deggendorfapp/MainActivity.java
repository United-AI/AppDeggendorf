package com.example.deggendorfapp;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    //TextView mErrorMessageDisplay;
    ProgressBar mLoadingIndicator;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_items);

        /* This TextView is used to display errors and will be hidden if there are no errors */
        // mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);

        /*
         * LinearLayoutManager can support HORIZONTAL or VERTICAL orientations. The reverse layout
         * parameter is useful mostly for HORIZONTAL layouts that should reverse for right to left
         * languages.
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);


        mRecyclerView.setLayoutManager(layoutManager);

    }
}
/*
 * Use this setting to improve performance if you know that changes in content do not
 * change the child layout size in the RecyclerView
 */
      /*  mRecyclerView.setHasFixedSize(true);


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

