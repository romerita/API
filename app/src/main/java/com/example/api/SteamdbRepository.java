package com.example.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.api.api.SteamdbAPI;
import com.example.api.api.SteamdbModule;
import com.example.api.model.Achievement;
import com.example.api.model.Game;
import com.example.api.model.GameAchievements;
import com.example.api.model.OwnedGamesResponse;
import com.example.api.model.Stats;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SteamdbRepository {
    SteamdbAPI steamdbAPI;

    public SteamdbRepository(){
        steamdbAPI = SteamdbModule.getAPI();
    }

    public LiveData<List<Achievement>> getPlayerAchievements(int gameid){
        final MutableLiveData<List<Achievement>> lista = new MutableLiveData<>();

        steamdbAPI.getPlayerAchievements(gameid).enqueue(new Callback<GameAchievements>() {
            @Override
            public void onResponse(Call<GameAchievements> call, Response<GameAchievements> response) {
                lista.setValue(response.body().playerstats.achievements);
            }

            @Override
            public void onFailure(Call<GameAchievements> call, Throwable t) {
            }
        });

        return lista;
    }

    public LiveData<List<Stats>> getUserStatsForGame(int gameid){
        final MutableLiveData<List<Stats>> lista = new MutableLiveData<>();

        steamdbAPI.getUserStatsForGame(gameid).enqueue(new Callback<GameAchievements>() {
            @Override
            public void onResponse(Call<GameAchievements> call, Response<GameAchievements> response) {
                lista.setValue(response.body().playerstats.stats);
            }

            @Override
            public void onFailure(Call<GameAchievements> call, Throwable t) {

            }
        });

        return lista;
    }

    public LiveData<List<Game>> getOwnedGames(){
        final MutableLiveData<List<Game>> lista = new MutableLiveData<>();

        steamdbAPI.getOwnedGames().enqueue(new Callback<OwnedGamesResponse>() {
            @Override
            public void onResponse(Call<OwnedGamesResponse> call, Response<OwnedGamesResponse> response) {
                lista.setValue(response.body().response.games);
            }

            @Override
            public void onFailure(Call<OwnedGamesResponse> call, Throwable t) {

            }
        });

        return lista;
    }

}
