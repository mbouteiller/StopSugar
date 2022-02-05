package com.example.stopsugar.fragments.FriendsManagement;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    public FriendsAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button button;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.infoName);

            button = view.findViewById(R.id.shareButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textView.getText() == "Michelle") {
                        button.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        button.setText("envoyé");
                    } else {
                        Toast.makeText(view.getContext(), "Ce n'est pas Michelle", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_friends, parent, false);
        return new FriendsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsAdapter.ViewHolder holder, int position) {
        String info = mData.get(position);
        holder.textView.setText(info);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}