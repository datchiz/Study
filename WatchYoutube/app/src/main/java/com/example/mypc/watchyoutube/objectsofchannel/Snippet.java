package com.example.mypc.watchyoutube.objectsofchannel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Snippet {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("customUrl")
    @Expose
    private String customUrl;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("thumbnails")
    @Expose
    private Thumbnails thumbnails;
    @SerializedName("localized")
    @Expose
    private Localized localized;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The customUrl
     */
    public String getCustomUrl() {
        return customUrl;
    }

    /**
     * @param customUrl The customUrl
     */
    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    /**
     * @return The publishedAt
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * @param publishedAt The publishedAt
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    /**
     * @return The thumbnails
     */
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    /**
     * @param thumbnails The thumbnails
     */
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    /**
     * @return The localized
     */
    public Localized getLocalized() {
        return localized;
    }

    /**
     * @param localized The localized
     */
    public void setLocalized(Localized localized) {
        this.localized = localized;
    }

}