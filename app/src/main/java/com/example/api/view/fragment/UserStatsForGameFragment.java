package com.example.api.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserStatsForGameFragment extends Fragment {


    public UserStatsForGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_stats_for_game, container, false);
    }

}