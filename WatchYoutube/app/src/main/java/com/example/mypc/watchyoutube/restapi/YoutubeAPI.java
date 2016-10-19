package com.example.mypc.watchyoutube.restapi;

import com.example.mypc.watchyoutube.objectofyoutube.Youtube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MyPC on 14/10/2016.
 */

public interface YoutubeAPI {
    @GET("playlistItems?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<Youtube> loadChannel(@Query("playlistId") String playlistId);
}
