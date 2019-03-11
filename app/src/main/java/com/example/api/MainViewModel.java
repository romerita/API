package com.example.api;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.api.model.Achievement;
import com.example.api.model.Game;
import com.example.api.model.Stats;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private SteamdbRepository steamdbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        steamdbRepository = new SteamdbRepository();
    }

    public LiveData<List<Achievement>> getPlayerAchievements(int gameid){
        return steamdbRepository.getPlayerAchievements(gameid);
    }
    public LiveData<List<Stats>> getUserStatsForGame(int gameid){
        return steamdbRepository.getUserStatsForGame(gameid);
    }
    public LiveData<List<Game>> getOwnedGames(){
        return steamdbRepository.getOwnedGames();
    }
}
