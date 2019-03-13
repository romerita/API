package com.example.api.view.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.api.MainViewModel;
import com.example.api.R;
import com.example.api.model.Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserStatsForGameFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private UserStatsForGameFragment.UserStatsForGameAdapter mUserStatsForGameAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player_achievements, container, false);

        mRecyclerView = view.findViewById(R.id.playerAchievementsList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mUserStatsForGameAdapter = new UserStatsForGameFragment.UserStatsForGameAdapter();
        mRecyclerView.setAdapter(mUserStatsForGameAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getUserStatsForGame(730).observe(this, new Observer<List<Stats>>() {
            @Override
            public void onChanged(@Nullable List<Stats> stats) {
                mUserStatsForGameAdapter.statsList = stats;
                mUserStatsForGameAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public static class UserStatsForGameAdapter extends RecyclerView.Adapter<UserStatsForGameAdapter.UserStatsForGameViewHolder> {
        public List<Stats> statsList = new ArrayList<>();

        @NonNull
        @Override
        public UserStatsForGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stats, parent, false);
            return new UserStatsForGameViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserStatsForGameViewHolder holder, int position) {
            Stats stats = statsList.get(position);

            holder.name.setText(stats.name);
            holder.value.setText(String.valueOf(stats.value));
        }

        @Override
        public int getItemCount() {
            return statsList.size();
        }

        class UserStatsForGameViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView value;

            public UserStatsForGameViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                value = itemView.findViewById(R.id.value);
            }
        }
    }
}
