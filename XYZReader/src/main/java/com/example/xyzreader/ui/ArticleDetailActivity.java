package com.example.xyzreader.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ItemsContract;

/**
 * An activity representing a single Article detail screen, letting you swipe between articles.
 */
public class ArticleDetailActivity extends AppCompatActivity {
    //    implements LoaderManager.LoaderCallbacks<Cursor> {

    //private Cursor mCursor;
    private long mStartId;
    public static final String ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            ArticleDetailFragment fragment = new ArticleDetailFragment();
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            if (getIntent() != null && getIntent().getData() != null) {
                Bundle arguments = new Bundle();
                arguments.putLong(ITEM_ID, ItemsContract.Items.getItemId(getIntent().getData()));
                fragment.setArguments(arguments);
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, fragment)
                    .commit();
        }
    }
}

