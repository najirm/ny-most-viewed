package com.ny.mostviewed.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MostViewedArticleResponse {
    public List<MostViewedArticle> getMostViewedArticleList() {
        return mostViewedArticleList;
    }

    @SerializedName("results")
    private List<MostViewedArticle> mostViewedArticleList;
}
