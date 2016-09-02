package es.rufflecol.sam.mushiki.application.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.rufflecol.sam.mushiki.application.Cfg;
import es.rufflecol.sam.mushiki.data.steam.community.SteamCommunityAPI;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(Cfg.HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Cfg.HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public SteamCommunityAPI provideSteamCommunityAPI(OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(Cfg.STEAM_COMMUNITY_API_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(httpClient)
                .build()
                .create(SteamCommunityAPI.class);
    }

}
