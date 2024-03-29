package com.tstask.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaModel implements Parcelable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private long approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private ArrayList<MediaMetadatum> mediaMetadata = null;

    public final static Parcelable.Creator<MediaModel> CREATOR = new Creator<MediaModel>() {

        @SuppressWarnings({
                "unchecked"
        })
        public MediaModel createFromParcel(Parcel in) {
            return new MediaModel(in);
        }

        public MediaModel[] newArray(int size) {
            return (new MediaModel[size]);
        }

    };

    protected MediaModel(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.subtype = ((String) in.readValue((String.class.getClassLoader())));
        this.caption = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((String) in.readValue((String.class.getClassLoader())));
        this.approvedForSyndication = ((long) in.readValue((long.class.getClassLoader())));
        in.readList(this.mediaMetadata, (MediaMetadatum.class.getClassLoader()));
    }

    public MediaModel() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public long getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(long approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public ArrayList<MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(ArrayList<MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(subtype);
        dest.writeValue(caption);
        dest.writeValue(copyright);
        dest.writeValue(approvedForSyndication);
        dest.writeList(mediaMetadata);
    }

    public int describeContents() {
        return 0;
    }

}