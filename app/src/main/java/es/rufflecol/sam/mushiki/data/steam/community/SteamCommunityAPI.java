package es.rufflecol.sam.mushiki.data.steam.community;

import es.rufflecol.sam.mushiki.data.steam.community.model.GamesListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SteamCommunityAPI {

    @GET("id/{steamId}/games?tab=all&xml=1")
    Call<GamesListResponse> getGamesList(@Path("steamId") String steamId);

    @GET("profiles/{steamId64}/games?tab=all&xml=1")
    Call<GamesListResponse> getGamesList(@Path("steamId64") long steamId64);

}
