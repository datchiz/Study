package com.example.mypc.watchyoutube.restapi;

import com.example.mypc.watchyoutube.objectofplaylist.PlayList;
import com.example.mypc.watchyoutube.objectofyoutube.Youtube;
import com.example.mypc.watchyoutube.objectsofchannel.Channel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MyPC on 14/10/2016.
 */

public interface YoutubeAPI {
    @GET("playlistItems?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<Youtube> loadYoutube(@Query("playlistId") String playlistId);

    @GET("channels?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<Channel> loadChannel(@Query("id") String id);

    @GET("playlists?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<PlayList> loadPlayList(@Query("channelId") String channelId);
}
