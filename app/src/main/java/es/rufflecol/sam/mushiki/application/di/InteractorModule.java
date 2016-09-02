package es.rufflecol.sam.mushiki.application.di;

import dagger.Module;
import dagger.Provides;
import es.rufflecol.sam.mushiki.data.interactor.FetchSteamGamesInteractor;
import es.rufflecol.sam.mushiki.data.interactor.Interactor;
import es.rufflecol.sam.mushiki.data.steam.community.SteamCommunityAPI;

@Module
public class InteractorModule {

    @Provides
    public Interactor.FetchSteamGames provideFetchSteamGamesInteractor(SteamCommunityAPI client) {
        return new FetchSteamGamesInteractor(client);
    }

}
