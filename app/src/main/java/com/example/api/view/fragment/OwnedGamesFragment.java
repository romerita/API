package com.example.api.view.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api.MainViewModel;
import com.example.api.R;
import com.example.api.model.Game;
import com.example.api.view.SteamListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnedGamesFragment extends Fragment {


    public OwnedGamesFragment() {
        // Required empty public constructor
    }

    MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_owned_games, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ownedGamesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SteamListAdapter steamListAdapter = new SteamListAdapter();
        recyclerView.setAdapter(steamListAdapter);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getOwnedGames().observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(@Nullable List<Game> games) {
                steamListAdapter.steamListGames = games;
                steamListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

}
