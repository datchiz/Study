package com.example.mypc.watchyoutube.restapi;



import com.example.mypc.watchyoutube.objectsofchannel.Channel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MyPC on 12/10/2016.
 */

public interface ChannelAPI {
    @GET("channels?part=snippet&key=AIzaSyBKvuOce9X9M9jGSNjK22MjAMbhfwlqWiU")
    Call<Channel> loadChannel(@Query("id") String id);
}
