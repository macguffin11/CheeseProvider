package com.example.cheeseprovider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private Cursor mCursor;

    public CheeseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mCursor.moveToPosition(position)) {
            holder.mText.setText(mCursor.getString(
                    mCursor.getColumnIndexOrThrow(Cheese.COLUMN_NAME)));
        }
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }


    void setCheeses(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView mText;

        ViewHolder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(android.R.id.text1);
        }

    }
}
