package com.example.mypc.watchyoutube.retrofit;

import android.support.v7.widget.RecyclerView;
import com.example.mypc.watchyoutube.adapter.YoutubeItemRecycleViewAdapter;
import com.example.mypc.watchyoutube.objectofplaylist.Item;
import com.example.mypc.watchyoutube.objectofplaylist.PlayList;
import com.example.mypc.watchyoutube.objectofyoutube.Youtube;
import com.example.mypc.watchyoutube.restapi.YoutubeAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 17/10/2016.
 */

public class YoutubeRetrofit {
    private List<Item> itemPlayLists;
    private List<String> playListIDs;
    private RecyclerView recyclerView;
    private ArrayList<Youtube> itemYoutubes;
    private ArrayList<com.example.mypc.watchyoutube.objectofyoutube.Item> itemsOfYoutube;

    public YoutubeRetrofit(RecyclerView recyclerView) {
        this.recyclerView      = recyclerView;
        itemPlayLists          = new ArrayList<>();
        playListIDs            = new ArrayList<>();
        itemYoutubes           = new ArrayList<>();
        itemsOfYoutube         = new ArrayList<>();
    }

    public void execute(String channelIDs){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                // Sử dụng GSON cho việc parse và maps JSON data tới Object
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo các cuộc gọi cho Retrofit 2.0
        final YoutubeAPI youtubeAPI = retrofit.create(YoutubeAPI.class);

        Call<PlayList> call = youtubeAPI.loadPlayList(channelIDs);
        call.enqueue(new Callback<PlayList>() {
            @Override
            public void onResponse(Call<PlayList> call, Response<PlayList> response) {
                if (response != null){
                    itemPlayLists = response.body().getItems();

                    int size = itemPlayLists.size();

                    for (int i = 0; i < size; i++){
                        playListIDs.add(itemPlayLists.get(i).getId());
                    }

                    executeForYoutube((ArrayList<String>) playListIDs);
                }
            }

            @Override
            public void onFailure(Call<PlayList> call, Throwable t) {

            }
        });

    }

    private void executeForYoutube(ArrayList<String> playListIDs){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                // Sử dụng GSON cho việc parse và maps JSON data tới Object
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo các cuộc gọi cho Retrofit 2.0
        YoutubeAPI youtubeAPI = retrofit.create(YoutubeAPI.class);

        final int size = playListIDs.size();

        for(int i = 0; i < size; i++){
            Call<Youtube> call = youtubeAPI.loadYoutube(playListIDs.get(i));

            call.enqueue(new Callback<Youtube>() {
                @Override
                public void onResponse(Call<Youtube> call, Response<Youtube> response) {
                    if (response != null){
                        itemYoutubes.add(response.body());

                        int numberOfPlayList = itemYoutubes.size();

                        for (int i = 0; i < numberOfPlayList; i++){
                            Youtube youtubeCurrent = itemYoutubes.get(i);
                            int numberOfYoutube = youtubeCurrent.getItems().size();

                            for (int j = 0; j < numberOfYoutube; j++){
                                itemsOfYoutube.add(youtubeCurrent.getItems().get(j));
                            }
                        }

                        recyclerView.setAdapter(new YoutubeItemRecycleViewAdapter(itemsOfYoutube));
                    }
                }

                @Override
                public void onFailure(Call<Youtube> call, Throwable t) {

                }
            });
        }

    }
}
