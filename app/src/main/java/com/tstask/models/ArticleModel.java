package com.tstask.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArticleModel implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private Object column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("asset_id")
    @Expose
    private long assetId;
    @SerializedName("views")
    @Expose
    private long views;

    private ArrayList<String> desFacet = null;

    private ArrayList<String> orgFacet;

    private ArrayList<String> perFacet = null;

    private ArrayList<String> geoFacet;

    @SerializedName("media")
    @Expose
    private List<MediaModel> media = null;

    @SerializedName("uri")
    @Expose
    private String uri;
    public final static Parcelable.Creator<ArticleModel> CREATOR = new Creator<ArticleModel>() {

        @SuppressWarnings({
                "unchecked"
        })
        public ArticleModel createFromParcel(Parcel in) {
            return new ArticleModel(in);
        }

        public ArticleModel[] newArray(int size) {
            return (new ArticleModel[size]);
        }

    };

    protected ArticleModel(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.adxKeywords = ((String) in.readValue((String.class.getClassLoader())));
        this.column = ((Object) in.readValue((Object.class.getClassLoader())));
        this.section = ((String) in.readValue((String.class.getClassLoader())));
        this.byline = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this._abstract = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((long) in.readValue((long.class.getClassLoader())));
        this.assetId = ((long) in.readValue((long.class.getClassLoader())));
        this.views = ((long) in.readValue((long.class.getClassLoader())));
        in.readList(this.desFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.orgFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.geoFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.perFacet, (java.lang.String.class.getClassLoader()));
        in.readList(this.media, (MediaModel.class.getClassLoader()));
        this.uri = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ArticleModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public ArrayList<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(ArrayList<String> desFacet) {
        this.desFacet = desFacet;
    }

    public ArrayList<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(ArrayList<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public ArrayList<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(ArrayList<String> perFacet) {
        this.perFacet = perFacet;
    }

    public ArrayList<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(ArrayList<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<MediaModel> getMedia() {
        return media;
    }

    public void setMedia(List<MediaModel> media) {
        this.media = media;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(adxKeywords);
        dest.writeValue(column);
        dest.writeValue(section);
        dest.writeValue(byline);
        dest.writeValue(type);
        dest.writeValue(title);
        dest.writeValue(_abstract);
        dest.writeValue(publishedDate);
        dest.writeValue(source);
        dest.writeValue(id);
        dest.writeValue(assetId);
        dest.writeValue(views);
        dest.writeList(desFacet);
        dest.writeValue(orgFacet);
        dest.writeList(perFacet);
        dest.writeValue(geoFacet);
        dest.writeList(media);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return 0;
    }

    public static class FacetsDeserilizer implements JsonDeserializer<ArticleModel> {

        @Override
        public ArticleModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson gson = new Gson();
            ArticleModel articleModel = gson.fromJson(json, ArticleModel.class);
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.has("des_facet")) {
                JsonElement elem = jsonObject.get("des_facet");
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        String valuesString = elem.getAsString();
                        if (!TextUtils.isEmpty(valuesString)) {
                            ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                            }.getType());
                            articleModel.setDesFacet(values);
                        }
                    } else if (elem.isJsonArray()) {
                        ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                        }.getType());
                        articleModel.setDesFacet(values);
                    }
                }
            }
            if (jsonObject.has("org_facet")) {
                JsonElement elem = jsonObject.get("org_facet");
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        String valuesString = elem.getAsString();
                        if (!TextUtils.isEmpty(valuesString)) {
                            ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                            }.getType());
                            articleModel.setOrgFacet(values);
                        }
                    } else if (elem.isJsonArray()) {
                        ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                        }.getType());
                        articleModel.setOrgFacet(values);
                    }
                }
            }
            if (jsonObject.has("per_facet")) {
                JsonElement elem = jsonObject.get("per_facet");
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        String valuesString = elem.getAsString();
                        if (!TextUtils.isEmpty(valuesString)) {
                            ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                            }.getType());
                            articleModel.setPerFacet(values);
                        }
                    } else if (elem.isJsonArray()) {
                        ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                        }.getType());
                        articleModel.setPerFacet(values);
                    }
                }
            }
            if (jsonObject.has("geo_facet")) {
                JsonElement elem = jsonObject.get("geo_facet");
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        String valuesString = elem.getAsString();
                        if (!TextUtils.isEmpty(valuesString)) {
                            ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                            }.getType());
                            articleModel.setGeoFacet(values);
                        }
                    } else if (elem.isJsonArray()) {
                        ArrayList<String> values = gson.fromJson(elem, new TypeToken<ArrayList<String>>() {
                        }.getType());
                        articleModel.setGeoFacet(values);
                    }
                }
            }
            return articleModel;
        }

    }

}



