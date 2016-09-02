package sam.rufflecol.es.mushiki.presentation.allgames;

import javax.inject.Inject;

public class AllGamesPresenter implements AllGamesMvp.Presenter {

    private AllGamesMvp.View view;

    @Inject
    public AllGamesPresenter() {

    }

    @Override
    public void setView(AllGamesMvp.View view) {
        this.view = view;
    }

}
