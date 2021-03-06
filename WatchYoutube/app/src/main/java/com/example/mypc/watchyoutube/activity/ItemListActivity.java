package com.example.mypc.watchyoutube.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;


import com.example.mypc.watchyoutube.R;
import com.example.mypc.watchyoutube.retrofit.ChannelRetrofit;

import java.util.ArrayList;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private ArrayList<String> channelID;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        findViewByIds();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle(getTitle());
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        creatListChannel();
        new ChannelRetrofit(mTwoPane, recyclerView, this).execute(channelID);

    }

    private void findViewByIds(){
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
    }

    private void creatListChannel(){
        channelID = new ArrayList<String>();
        channelID.add("UCe0C_ErjrieB8OLztQYMvXA");
        channelID.add("UCsaMa3VD1I9G952DDlOX7aw");
        channelID.add("UCIC-BC__0U0lsdi3F1sjIOg");
        channelID.add("UCF7pi1D0S9x8hjgYB68cZSA");
        channelID.add("UCiLJiGv78dLGXmSv6Vnl3uQ");
    }


}
