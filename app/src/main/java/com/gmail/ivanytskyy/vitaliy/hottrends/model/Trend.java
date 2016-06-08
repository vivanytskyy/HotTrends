package com.gmail.ivanytskyy.vitaliy.hottrends.model;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Vitaliy Ivanytskyy on 07.06.2016.
 */
public class Trend {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("creator")
    private String creator;
    @SerializedName("image_blur")
    private String imageBlur;
    @SerializedName("image_thumbnail")
    private String imageThumbnail;
    public Trend (){};
    public Trend(String id, String title, String creator, String imageBlur, String imageThumbnail) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.imageBlur = imageBlur;
        this.imageThumbnail = imageThumbnail;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getImageBlur() {
        return imageBlur;
    }
    public void setImageBlur(String imageBlur) {
        this.imageBlur = imageBlur;
    }
    public String getImageThumbnail() {
        return imageThumbnail;
    }
    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }
    @Override
    public String toString() {
        return "Trend{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", imageBlur='" + imageBlur + '\'' +
                ", imageThumbnail='" + imageThumbnail + '\'' +
                '}';
    }
}