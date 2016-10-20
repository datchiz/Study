package com.example.mypc.watchyoutube.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.watchyoutube.activity.ItemDetailActivity;
import com.example.mypc.watchyoutube.activity.ItemDetailFragment;
import com.example.mypc.watchyoutube.R;
import com.example.mypc.watchyoutube.objectsofchannel.Channel;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by MyPC on 11/10/2016.
 */

public class ChanneltemRecyclerViewAdapter extends RecyclerView.Adapter<ChanneltemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Channel> mValues;
    private FragmentActivity mFragmentActivity;
    private Boolean mTwoPane;

    public ChanneltemRecyclerViewAdapter(ArrayList<Channel> items, FragmentActivity fragmentActivity, Boolean twoPane) {
        mValues           = items;
        mFragmentActivity = fragmentActivity;
        mTwoPane          = twoPane;
    }

    @Override
    public ChanneltemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ChanneltemRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ChanneltemRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        final String tilte       = holder.mItem.getItems().get(0).getSnippet().getTitle().toString();
        final String description = holder.mItem.getItems().get(0).getSnippet().getDescription().toString();
        final String icon        = holder.mItem.getItems().get(0).getSnippet().getThumbnails().getDefault()
                .getUrl()
                .toString();
        final String id          = holder.mItem.getItems().get(0).getId().toString();

        Picasso.with(holder.mView.getContext())
                .load(icon)
                .into(holder.ivIcon);
        holder.tvTitle.setText(tilte);
        holder.tvDescription.setText(description);
        holder.mView.setBackgroundResource(R.drawable.item_channel_state);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
//                    Bundle arguments = new Bundle();
//                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
//                    ItemDetailFragment fragment = new ItemDetailFragment();
                    EventBus.getDefault().post(id);
//                    fragment.setArguments(arguments);
//                    mFragmentActivity.getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.item_detail_container, fragment)
//                            .commit();

                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
                    context.startActivity(intent);
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
        public final TextView tvTitle;
        public final TextView tvDescription;
        public final ImageView ivIcon;
        public Channel mItem;

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


