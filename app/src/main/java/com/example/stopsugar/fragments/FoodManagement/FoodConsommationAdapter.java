package com.example.stopsugar.fragments.FoodManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.HomeFragment;

import java.util.List;

public class FoodConsommationAdapter extends RecyclerView.Adapter<FoodConsommationAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private HomeFragment homeFragment;

    public FoodConsommationAdapter(Context context, List<String> data, HomeFragment homeFragment) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.homeFragment = homeFragment;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.foodName);

            button = view.findViewById(R.id.deleteButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textView.getText() == "Banane") {
                        Toast.makeText(view.getContext(), "Suppression de l'aliment " + textView.getText(), Toast.LENGTH_SHORT).show();
                        homeFragment.removeFood(textView.getText().toString());
                        homeFragment.changeImageStat(0);
                    } else {
                        Toast.makeText(view.getContext(), "Vous ne supprimez pas une banane", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_food, parent, false);
        return new FoodConsommationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodConsommationAdapter.ViewHolder holder, int position) {
        String info = mData.get(position);
        holder.textView.setText(info);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}