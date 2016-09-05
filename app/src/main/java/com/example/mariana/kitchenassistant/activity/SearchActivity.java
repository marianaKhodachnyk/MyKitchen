package com.example.mariana.kitchenassistant.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mariana.kitchenassistant.R;
import com.example.mariana.kitchenassistant.adapter.RecipesGridAdapter;
import com.example.mariana.kitchenassistant.events.LoadTrendingEvent;
import com.example.mariana.kitchenassistant.events.RecipeClickEvent;
import com.example.mariana.kitchenassistant.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class SearchActivity extends AppCompatActivity {

    List<Recipe> recipeList = new ArrayList<>();
    RecipesGridAdapter mAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(LoadTrendingEvent event) {
        if (event.getRecipes() != null) {
            recipeList.addAll(event.getRecipes());
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridView = (GridView) findViewById(R.id.my_grid_view);
        mAdapter = new RecipesGridAdapter(getApplicationContext(), recipeList);
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                EventBus.getDefault().post(new RecipeClickEvent(recipeList.get(position).getRecipe_id()));
                startActivity(new Intent(getApplicationContext(), RecipeInfoActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
