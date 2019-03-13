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
import com.example.api.model.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnedGamesFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private OwnedGamesFragment.OwnedGamesAdapter mOwnedGamesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_owned_games, container, false);

        mRecyclerView = view.findViewById(R.id.ownedGamesList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mOwnedGamesAdapter = new OwnedGamesFragment.OwnedGamesAdapter();
        mRecyclerView.setAdapter(mOwnedGamesAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getOwnedGames().observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(@Nullable List<Game> games) {
                mOwnedGamesAdapter.gameList = games;
                mOwnedGamesAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public class OwnedGamesAdapter extends RecyclerView.Adapter<OwnedGamesAdapter.OwnedGamesViewHolder>{
        public List<Game> gameList = new ArrayList<>();

        @NonNull
        @Override
        public OwnedGamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games, parent, false);
            return new OwnedGamesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OwnedGamesViewHolder holder, int position) {
            Game game = gameList.get(position);

            holder.appid.setText(String.valueOf(game.appid));
            holder.playtime_forever.setText(String.valueOf(game.playtime_forever));
        }

        @Override
        public int getItemCount() {
            return gameList.size();
        }

        class OwnedGamesViewHolder extends RecyclerView.ViewHolder {
            TextView appid;
            TextView playtime_forever;

            public OwnedGamesViewHolder(View itemView) {
                super(itemView);
                appid = itemView.findViewById(R.id.appid);
                playtime_forever = itemView.findViewById(R.id.playtime_forever);
            }
        }
    }
}
