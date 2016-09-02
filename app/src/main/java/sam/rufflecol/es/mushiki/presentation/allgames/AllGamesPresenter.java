package sam.rufflecol.es.mushiki.presentation.allgames;

public class AllGamesPresenter implements AllGamesMvp.Presenter {

    private AllGamesMvp.View view;

    @Override
    public void setView(AllGamesMvp.View view) {
        this.view = view;
    }

}
