package com.example.stopsugar.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stopsugar.R;
import com.example.stopsugar.fragments.FriendsManagement.FriendsAdapter;

import java.util.ArrayList;

public class FriendsFragment extends Fragment {

    private View rootView;

    FriendsAdapter friendsAdapter;

    ArrayList<String> friends;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_friends, container, false);

        configureRecyclerView();

        return rootView;
    }

    private void configureRecyclerView() {
        friends = new ArrayList<>();
        friends.add("Ryana");
        friends.add("Ludo");
        friends.add("Michelle");
        friends.add("Jessy");
        friends.add("Vivou");
        friends.add("Valentin");

        RecyclerView recyclerViewInfos = rootView.findViewById(R.id.friendsRecycler);
        recyclerViewInfos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        friendsAdapter = new FriendsAdapter(this.getContext(), friends);
        recyclerViewInfos.setAdapter(friendsAdapter);
    }
}
