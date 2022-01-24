package com.example.stopsugar.fragments.RecipesManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.FragmentChangeListener;
import com.example.stopsugar.R;
import com.example.stopsugar.activities.MainActivity;
import com.example.stopsugar.fragments.RecipeFragment;
import com.example.stopsugar.fragments.SelectRecipeFragment;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    // List with String type
    private List<String> list;
    private RecipeFragment recipeFragment = new RecipeFragment();
    private SelectRecipeFragment selectRecipeFragment = new SelectRecipeFragment();

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Text View
        TextView textView;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public ViewHolder(View view)
        {
            super(view);

            // initialise TextView with id
            textView = view.findViewById(R.id.recipeNameText);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textView.getText() == "Mousse au chocolat") {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectRecipeFragment).commit();
                    } else {
                        Toast.makeText(view.getContext(), "Ceci n'est pas une mousse au chocolat", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public RecipeAdapter(List<String> horizontalList)
    {
        this.list = horizontalList;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType)
    {

        // Inflate item.xml using LayoutInflator
        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_recipe,
                        parent,
                        false);

        // return itemView
        return new ViewHolder(itemView);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(final ViewHolder holder,
                                 final int position)
    {

        // Set the text of each item of
        // Recycler view with the list items
        holder.textView.setText(list.get(position));
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void filterList(List<String> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }
}
