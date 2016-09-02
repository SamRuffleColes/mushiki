package es.rufflecol.sam.mushiki.application.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import es.rufflecol.sam.mushiki.application.Cfg;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(Cfg.HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Cfg.HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

}
