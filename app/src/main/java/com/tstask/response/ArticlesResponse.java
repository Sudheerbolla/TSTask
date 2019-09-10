package com.tstask.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tstask.models.ArticleModel;

import java.util.List;

public class ArticlesResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private int numResults;
    @SerializedName("results")
    @Expose
    private List<ArticleModel> articleModels = null;

    public final static Parcelable.Creator<ArticlesResponse> CREATOR = new Creator<ArticlesResponse>() {

        @SuppressWarnings({
                "unchecked"
        })
        public ArticlesResponse createFromParcel(Parcel in) {
            return new ArticlesResponse(in);
        }

        public ArticlesResponse[] newArray(int size) {
            return (new ArticlesResponse[size]);
        }

    };

    protected ArticlesResponse(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.copyright = ((String) in.readValue((String.class.getClassLoader())));
        this.numResults = ((int) in.readValue((int.class.getClassLoader())));
        in.readList(this.articleModels, (ArticleModel.class.getClassLoader()));
    }

    public ArticlesResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public List<ArticleModel> getArticleModels() {
        return articleModels;
    }

    public void setArticleModels(List<ArticleModel> articleModels) {
        this.articleModels = articleModels;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(copyright);
        dest.writeValue(numResults);
        dest.writeList(articleModels);
    }

    public int describeContents() {
        return 0;
    }

}