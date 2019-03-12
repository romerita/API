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
import com.example.api.model.Stats;
import com.example.api.view.SteamListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserStatsForGameFragment extends Fragment {


    public UserStatsForGameFragment() {
        // Required empty public constructor
    }

    MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_player_achievements, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.userStatsForGameList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final SteamListAdapter steamListAdapter = new SteamListAdapter();
        recyclerView.setAdapter(steamListAdapter);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getUserStatsForGame(730).observe(this, new Observer<List<Stats>>() {
            @Override
            public void onChanged(@Nullable List<Stats> stats) {
                steamListAdapter.steamListStats = stats;
                steamListAdapter.notifyDataSetChanged();
            }
        });

        return inflater.inflate(R.layout.fragment_user_stats_for_game, container, false);
    }

}
