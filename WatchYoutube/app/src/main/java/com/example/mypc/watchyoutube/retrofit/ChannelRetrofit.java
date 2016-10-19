package com.example.mypc.watchyoutube.retrofit;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import com.example.mypc.watchyoutube.activity.ItemListActivity;
import com.example.mypc.watchyoutube.adapter.ChanneltemRecyclerViewAdapter;
import com.example.mypc.watchyoutube.objectsofchannel.Channel;
import com.example.mypc.watchyoutube.restapi.ChannelAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 17/10/2016.
 */

public class ChannelRetrofit {
    private ArrayList<Channel> mItems;
    private Boolean mTwoPane;
    private RecyclerView mRecyclerView;
    private FragmentActivity mFragmentActivity;

    public ChannelRetrofit(Boolean mTwoPane, RecyclerView mRecyclerView, FragmentActivity mFragmentActivity) {
        mItems = new ArrayList<>();
        this.mTwoPane = mTwoPane;
        this.mRecyclerView = mRecyclerView;
        this.mFragmentActivity = mFragmentActivity;
    }

    public void execute(ArrayList<String> channelIDs){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                // Sử dụng GSON cho việc parse và maps JSON data tới Object
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo các cuộc gọi cho Retrofit 2.0
        ChannelAPI channelAPI = retrofit.create(ChannelAPI.class);

        final int size = channelIDs.size();

        for(int i = 0; i < size; i++){
            Call<Channel> call = channelAPI.loadChannel(channelIDs.get(i));
            call.enqueue(new Callback<Channel>() {
                @Override
                public void onResponse(Call<Channel> call, Response<Channel> response) {
                    if (response != null){
                        mItems.add(response.body());
                    }

                    if(mItems.size() == size){
                        mRecyclerView.setAdapter(new ChanneltemRecyclerViewAdapter(mItems, mFragmentActivity, mTwoPane));
                    }
                }

                @Override
                public void onFailure(Call<Channel> call, Throwable t) {

                }
            });
        }

    }
}
