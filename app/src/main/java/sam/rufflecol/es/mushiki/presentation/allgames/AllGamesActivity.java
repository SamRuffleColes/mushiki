package sam.rufflecol.es.mushiki.presentation.allgames;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sam.rufflecol.es.mushiki.R;

public class AllGamesActivity extends AppCompatActivity implements AllGamesMvp.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);
    }

}
