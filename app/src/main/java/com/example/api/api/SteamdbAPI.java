package com.example.api.api;

import com.example.api.model.GameAchievements;
import com.example.api.model.OwnedGamesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SteamdbAPI {
    @GET("/ISteamUserStats/GetPlayerAchievements/v0001/")
    Call<GameAchievements> getPlayerAchievements(@Query(value="appid") int gameid);

    @GET("/ISteamUserStats/GetUserStatsForGame/v0002/")
    Call<GameAchievements> getUserStatsForGame(@Query(value="appid") int gameid);

    @GET("IPlayerService/GetOwnedGames/v0001/")
    Call<OwnedGamesResponse> getOwnedGames();
}
