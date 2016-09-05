package com.example.mariana.kitchenassistant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mariana.kitchenassistant.R;

import java.util.List;

import com.example.mariana.kitchenassistant.model.Recipe;

public class RecipesGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<Recipe> recipeList;

    public RecipesGridAdapter(Context c, List<Recipe> list) {
        mContext = c;
        recipeList = list;
    }

    public int getCount() {
        return recipeList.size();
    }

    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;

        if (convertView == null) {
            grid = new View(mContext);
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.recipes_item, parent, false);
        } else {
            grid = (View) convertView;
        }

        ImageView imageView = (ImageView) grid.findViewById(R.id.image);
        Glide.with(mContext).load(recipeList.get(position).getImage_url())
               .into(imageView);

        TextView textView = (TextView) grid.findViewById(R.id.text);
        textView.setText(recipeList.get(position).getTitle());

        return grid;
    }
}
