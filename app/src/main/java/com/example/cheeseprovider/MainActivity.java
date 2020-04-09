package com.example.cheeseprovider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {
    public static final String AUTHORITY = "com.example.android.aplikasiuntukuts.provider";
    public static final Uri URI_CHEESE = Uri.parse(
            "content://" + AUTHORITY + "/" + Cheese.TABLE_NAME);

    private static final int LOADER_CHEESES = 1;
    private CheeseAdapter mCheeseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(list.getContext()));
        mCheeseAdapter = new CheeseAdapter(this);
        list.setAdapter(mCheeseAdapter);
        LoaderManager.getInstance(this).initLoader(LOADER_CHEESES, null, mLoaderCallbacks);
    }

    private final LoaderManager.LoaderCallbacks<Cursor> mLoaderCallbacks =
            new LoaderManager.LoaderCallbacks<Cursor>() {

                @Override
                @NonNull
                public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                    return new CursorLoader(getApplicationContext(),
                            URI_CHEESE,
                            new String[]{Cheese.COLUMN_NAME},
                            null, null, null);
                }

                @Override
                public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
                    mCheeseAdapter.setCheeses(data);
                }

                @Override
                public void onLoaderReset(@NonNull Loader<Cursor> loader) {
                    mCheeseAdapter.setCheeses(null);
                }

            };
}
