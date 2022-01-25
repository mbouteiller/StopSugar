package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.InfoManagement.InfoAdapter;
import com.example.stopsugar.fragments.SelectedRecipeManagement.IngredientsAdapter;

import java.util.ArrayList;

public class InfoFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_info, container, false);

        configureRecyclerView();
        return rootView;
    }

    private void configureRecyclerView() {
        ArrayList<String> infos = new ArrayList<>();
        infos.add("Types de sucres");
        infos.add("Alternatives au sucre raffiné");
        infos.add("Les types de stévia");
        infos.add("Les effets du sucre sur le corps");
        infos.add("Comment réduire la consommation de sucre");
        infos.add("Alimentation et émotions");

        RecyclerView recyclerViewInfos = rootView.findViewById(R.id.infosRecycler);
        recyclerViewInfos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        InfoAdapter infoAdapter = new InfoAdapter(this.getContext(), infos);
        recyclerViewInfos.setAdapter(infoAdapter);
    }
}
