package com.example.mypc.watchyoutube.restapi;

import com.example.mypc.watchyoutube.objectofplaylist.PlayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MyPC on 14/10/2016.
 */

public interface PlayListAPI {
    @GET("playlists?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<PlayList> loadChannel(@Query("channelId") String channelId);
}
