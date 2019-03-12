package com.example.api.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.api.R;
import com.example.api.model.Achievement;
import com.example.api.model.Game;
import com.example.api.model.Stats;

import org.w3c.dom.Text;

import java.util.List;

public class SteamListAdapter extends RecyclerView.Adapter<SteamListAdapter.SteamListViewHolder>{
    public List<Achievement> steamListAchievements;
    public List<Stats> steamListStats;
    public List<Game> steamListGames;

    @NonNull
    @Override
    public SteamListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_steam, parent, false);
        return new SteamListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SteamListViewHolder holder, int position) {
        Achievement achievement = steamListAchievements.get(position);
        Stats stats = steamListStats.get(position);
        Game game = steamListGames.get(position);

        holder.title.setText(achievement.apiname);
        holder.achieved.setText(String.valueOf(achievement.achieved));
        holder.unlocktime.setText(String.valueOf(achievement.unlocktime));

        holder.name.setText(stats.name);
        holder.value.setText(stats.value);

        holder.appid.setText(game.appid);
        holder.playtime_forever.setText(game.playtime_forever);
    }

    @Override
    public int getItemCount() {
        return steamListAchievements != null ? steamListAchievements.size() : 0;
    }

    class SteamListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView achieved;
        TextView unlocktime;

        TextView name;
        TextView value;

        TextView appid;
        TextView playtime_forever;


        public SteamListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.achievementApiname);
            achieved = itemView.findViewById(R.id.achievementAchieved);
            unlocktime = itemView.findViewById(R.id.achievementUnlocktime);

            name = itemView.findViewById(R.id.name);
            value = itemView.findViewById(R.id.value);

            appid = itemView.findViewById(R.id.appid);
            playtime_forever = itemView.findViewById(R.id.playtime_forever);
        }
    }
}
