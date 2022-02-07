package com.example.stopsugar.fragments.InfoManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.SelectInfoFragment;
import com.example.stopsugar.fragments.SelectRecipeFragment;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    private SelectInfoFragment selectInfoFragment = new SelectInfoFragment();

    public InfoAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.infoName);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textView.getText() == "Alternatives au sucre raffiné") {
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectInfoFragment).commit();
                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_info, parent, false);
        return new InfoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String info = mData.get(position);
        holder.textView.setText(info);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filterList(List<String> filteredList) {
        mData = filteredList;
        notifyDataSetChanged();
    }
}
