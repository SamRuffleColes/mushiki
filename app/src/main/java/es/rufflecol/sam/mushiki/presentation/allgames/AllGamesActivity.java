package es.rufflecol.sam.mushiki.presentation.allgames;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.rufflecol.sam.mushiki.R;
import es.rufflecol.sam.mushiki.application.App;

public class AllGamesActivity extends AppCompatActivity implements AllGamesMvp.View {

    @BindView(R.id.rv_games)
    RecyclerView recyclerView;

    @BindView(R.id.test)
    TextView t;

    @Inject
    AllGamesMvp.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);
        ButterKnife.bind(this);
        App.get().getAppComponent().inject(this);
        presenter.setView(this);
        presenter.onCreate();
    }


    @Override
    public void requestSteamId() {

    }

}
