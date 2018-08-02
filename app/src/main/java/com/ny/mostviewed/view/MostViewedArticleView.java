package com.ny.mostviewed.view;

import com.ny.mostviewed.model.MostViewedArticle;

import java.util.List;

public interface MostViewedArticleView {
    void populateArticle(List<MostViewedArticle> mostViewedArticles);

    void hideProgress();

    void showToast();
}
