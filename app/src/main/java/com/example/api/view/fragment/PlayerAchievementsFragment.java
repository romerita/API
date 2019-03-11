package com.example.api.view.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api.MainViewModel;
import com.example.api.R;
import com.example.api.view.SteamListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerAchievementsFragment extends Fragment {


    public PlayerAchievementsFragment() {
        // Required empty public constructor
    }

    MainViewModel mainViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        return inflater.inflate(R.layout.fragment_player_achievements, container, false);
    }

}
