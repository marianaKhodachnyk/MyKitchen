package com.example.mariana.kitchenassistant.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mariana.kitchenassistant.R;
import com.example.mariana.kitchenassistant.activity.RecipeInfoActivity;
import com.example.mariana.kitchenassistant.adapter.RecipesGridAdapter;
import com.example.mariana.kitchenassistant.events.LoadTrendingEvent;
import com.example.mariana.kitchenassistant.events.RecipeClickEvent;
import com.example.mariana.kitchenassistant.events.TrendingEvent;
import com.example.mariana.kitchenassistant.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class TrendingFragment extends Fragment{

    List<Recipe> recipeList = new ArrayList<>();
    RecipesGridAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().post(new TrendingEvent());
    }

    public void onEventMainThread(LoadTrendingEvent event) {
        if (event.getRecipes() != null) {
            recipeList.addAll(event.getRecipes());
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_grid, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.my_grid_view);
        mAdapter = new RecipesGridAdapter(getActivity(), recipeList);
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                EventBus.getDefault().post(new RecipeClickEvent(recipeList.get(position).getRecipe_id()));
                startActivity(new Intent(getActivity(), RecipeInfoActivity.class));
                recipeList.clear();
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
