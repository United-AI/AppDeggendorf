package com.example.deggendorfapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deggendorfapp.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.NumberViewHolder> {

    private static final String TAG = Adapter.class.getSimpleName();
    private int mNumberItems; //number of items to display in list

    private final ListItemClickListener listItemClickListener;
    private ArrayList<String> files;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public Adapter(int mNumberItems, ListItemClickListener listItemClickListener, ArrayList<String> files) {
        this.files = files;
        this.listItemClickListener = listItemClickListener;
        this.mNumberItems = mNumberItems;
    }


    /*
    viewGroup:  The ViewGroup that these ViewHolders are contained within.
    viewType:   If your RecyclerView has more than one type of item (which ours doesn't) you
                can use this viewType integer to provide a different layout. See
                {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
                for more details.
    return:     A new NumberViewHolder that holds the View for each list item
    */

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.items_for_recycler_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        RecyclerViewContents recyclerViewContents = new RecyclerViewContents(position, files);
        holder.bind(recyclerViewContents.returnRecyclerViewListItemAtIndex());
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView listItemNumberView;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.tv_item_number);
            itemView.setOnClickListener(this);
        }

        void bind(String listIndex) {
            listItemNumberView.setText(listIndex);
        }

        @Override //had to override because onClick is implemented
        public void onClick(View view) {
            int clickedPosition = getAbsoluteAdapterPosition();
            listItemClickListener.onListItemClick(clickedPosition);
        }

    }

}
