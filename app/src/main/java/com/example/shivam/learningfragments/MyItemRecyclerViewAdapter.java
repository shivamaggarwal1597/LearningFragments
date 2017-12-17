package com.example.shivam.learningfragments;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.shivam.learningfragments.ItemFragment.OnListFragmentInteractionListener;
import com.example.shivam.learningfragments.dummy.CategoryContent;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.example.shivam.learningfragments.dummy.CategoryContent.CategoryItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<CategoryContent.CategoryItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<CategoryContent.CategoryItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        if (mValues.get(position).isActive){
            holder.radioButton.setChecked(true);
        } else {
            holder.radioButton.setChecked(false);
        }
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mItem.isActive()){
                    holder.mItem.setActive(false);
                    Log.e("My Tag Again: ",String.valueOf(holder.mItem.isActive()));
                }
                else {
                holder.mItem.setActive(true);
                Log.e("My Tag Again: ",String.valueOf(holder.mItem.isActive()));
            }
            }
        });
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                   // holder.radioButton.;

                    mListener.onListFragmentInteraction(holder.mItem);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ToggleButton radioButton;
        public CategoryContent.CategoryItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            radioButton = (ToggleButton) view.findViewById(R.id.toggleBtn);
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
