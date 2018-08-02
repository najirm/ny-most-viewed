package com.ny.mostviewed.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ny.mostviewed.R;
import com.ny.mostviewed.adapter.MostViewedArticleAdapter;
import com.ny.mostviewed.model.MostViewedArticle;
import com.ny.mostviewed.presenter.MostViewedArticlePresenter;
import com.ny.mostviewed.view.MostViewedArticleView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MostViewedArticleView {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        MostViewedArticlePresenter mostViewedArticlePresenter = new MostViewedArticlePresenter(MainActivity.this, this);
        mostViewedArticlePresenter.getMostViewedArticles();
    }

    @Override
    public void populateArticle(List<MostViewedArticle> mostViewedArticleList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        MostViewedArticleAdapter mostViewedArticleAdapter = new MostViewedArticleAdapter(this, mostViewedArticleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mostViewedArticleAdapter);
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast() {
        Toast.makeText(MainActivity.this, "Something went wrong. Please try later.", Toast.LENGTH_LONG).show();
    }
}
