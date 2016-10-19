package com.example.mypc.watchyoutube.objectsofchannel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class High {

    @SerializedName("url")
    @Expose
    private String url;

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}