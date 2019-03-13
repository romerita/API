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
import com.example.api.model.Achievement;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerAchievementsFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private PlayerAchievementsFragment.PlayerAchievementsAdapter mPlayerAchievementsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player_achievements, container, false);

        mRecyclerView = view.findViewById(R.id.playerAchievementsList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mPlayerAchievementsAdapter = new PlayerAchievementsFragment.PlayerAchievementsAdapter();
        mRecyclerView.setAdapter(mPlayerAchievementsAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getPlayerAchievements(730).observe(this, new Observer<List<Achievement>>() {
            @Override
            public void onChanged(@Nullable List<Achievement> achievements) {
                mPlayerAchievementsAdapter.achievementList = achievements;
                mPlayerAchievementsAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public static class PlayerAchievementsAdapter extends RecyclerView.Adapter<PlayerAchievementsAdapter.PlayerAchievementsViewHolder>{
        public List<Achievement> achievementList = new ArrayList<>();

        @NonNull
         @Override
        public PlayerAchievementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_steam, parent, false);
            return new PlayerAchievementsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PlayerAchievementsViewHolder holder, int position) {
            Achievement achievement = achievementList.get(position);

            holder.title.setText(achievement.apiname);
            holder.achieved.setText(String.valueOf(achievement.achieved));
            holder.unlocktime.setText(String.valueOf(achievement.unlocktime));
        }

        @Override
        public int getItemCount() {
            return achievementList.size();
        }

        class PlayerAchievementsViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView achieved;
            TextView unlocktime;

            public PlayerAchievementsViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.achievementApiname);
                achieved = itemView.findViewById(R.id.achievementAchieved);
                unlocktime = itemView.findViewById(R.id.achievementUnlocktime);
            }
        }
    }
}
