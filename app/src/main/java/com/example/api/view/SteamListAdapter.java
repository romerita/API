package com.example.api.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.api.R;
import com.example.api.model.Achievement;

import java.util.List;

public class SteamListAdapter extends RecyclerView.Adapter<SteamListAdapter.SteamListViewHolder>{
    public List<Achievement> steamListAchievements;

    @NonNull
    @Override
    public SteamListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_steam, parent, false);
        return new SteamListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SteamListViewHolder holder, int position) {
        Achievement achievement = steamListAchievements.get(position);

        holder.title.setText(achievement.apiname);
        holder.achieved.setText(String.valueOf(achievement.achieved));
        holder.unlocktime.setText(String.valueOf(achievement.unlocktime));
    }

    @Override
    public int getItemCount() {
        return steamListAchievements != null ? steamListAchievements.size() : 0;
    }

    class SteamListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView achieved;
        TextView unlocktime;

        public SteamListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.achievementApiname);
            achieved = itemView.findViewById(R.id.achievementAchieved);
            unlocktime = itemView.findViewById(R.id.achievementUnlocktime);
        }
    }
}
