package es.rufflecol.sam.mushiki.data.interactor;

import javax.inject.Inject;

import es.rufflecol.sam.mushiki.data.steam.community.SteamCommunityAPI;

public class FetchSteamGamesInteractor implements Interactor.FetchSteamGames {

    private SteamCommunityAPI client;

    @Inject
    public FetchSteamGamesInteractor(SteamCommunityAPI client) {
        this.client = client;
    }

    @Override
    public void fetchForId(long steamId64) {

    }

    @Override
    public void fetchForUsername(String username) {

    }
}
