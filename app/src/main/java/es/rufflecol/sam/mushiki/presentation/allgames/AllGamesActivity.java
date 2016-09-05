package es.rufflecol.sam.mushiki.presentation.allgames;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.EditText;
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
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this)
                .setCancelable(false);
        LayoutInflater inflater = LayoutInflater.from(this);
        final EditText input = (EditText) inflater.inflate(R.layout.dialog_basic_editext, null);
        dialogBuilder.setView(input);
        dialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String steamIdOrUsername = input.getText().toString();
                presenter.fetchGamesForUser(steamIdOrUsername);
            }
        });
        dialogBuilder.show();
    }

}
