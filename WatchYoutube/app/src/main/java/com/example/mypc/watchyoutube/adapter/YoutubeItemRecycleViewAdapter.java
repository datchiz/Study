package com.example.mypc.watchyoutube.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.watchyoutube.R;
import com.example.mypc.watchyoutube.activity.ItemPlayActivity;
import com.example.mypc.watchyoutube.fragment.ItemDetailFragment;
import com.example.mypc.watchyoutube.objectofyoutube.Item;
import com.example.mypc.watchyoutube.objectofyoutube.Snippet;
import com.example.mypc.watchyoutube.objectofyoutube.Youtube;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MyPC on 15/10/2016.
 */

public class YoutubeItemRecycleViewAdapter extends RecyclerView.Adapter<YoutubeItemRecycleViewAdapter.ViewHolder> {

    private final ArrayList<Item> mValues;

    public YoutubeItemRecycleViewAdapter(ArrayList<Item> items) {
        mValues           = items;
    }

    @Override
    public YoutubeItemRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_youtube_content, parent, false);
        return new YoutubeItemRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final YoutubeItemRecycleViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        final String tilte       = holder.mItem.getSnippet().getTitle().toString();
        final String description = holder.mItem.getSnippet().getDescription().toString();
        final String id          = holder.mItem.getSnippet().getResourceId().getVideoId().toString();

        if (!tilte.equals("Deleted video") && !tilte.equals("Private video")){
            final String icon        = holder.mItem.getSnippet().getThumbnails().getDefault()
                    .getUrl()
                    .toString();

            Picasso.with(holder.mView.getContext())
                    .load(icon)
                    .into(holder.ivIcon);
        }

        holder.tvTitle.setText(tilte);
        holder.tvDescription.setText(description);
        holder.mView.setBackgroundResource(R.drawable.item_youtube_state);
        holder.mView.setClickable(true);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mTwoPane) {
//                    Bundle arguments = new Bundle();
//                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, tilte);
//                    ItemDetailFragment fragment = new ItemDetailFragment();
//                    fragment.setArguments(arguments);
//                    mFragmentActivity.getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.item_detail_container, fragment)
//                            .commit();
//                } else {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, ItemDetailActivity.class);
//                    intent.putExtra(ItemDetailFragment.CHANNEL_ID, id);
//
//                    context.startActivity(intent);
//                }
                Context context = v.getContext();
                Intent intent = new Intent(context, ItemPlayActivity.class);
                intent.putExtra(ItemDetailFragment.PLAY_ITEM_ID, id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvTitle;
        public final TextView tvDescription;
        public final ImageView ivIcon;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView         = view;
            tvTitle       = (TextView) view.findViewById(R.id.tvTitle);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            ivIcon        = (ImageView) view.findViewById(R.id.ivIcon);
        }

//        @Override
//        public String toString() {
////            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
