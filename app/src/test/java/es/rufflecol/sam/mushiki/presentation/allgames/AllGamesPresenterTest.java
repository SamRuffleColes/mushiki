package es.rufflecol.sam.mushiki.presentation.allgames;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.rufflecol.sam.mushiki.data.interactor.Interactor;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class AllGamesPresenterTest {

    @Mock
    Interactor.FetchSteamGames interactor;

    @Mock
    AllGamesMvp.View view;

    AllGamesMvp.Presenter presenter;

    @Before
    public void setUp() {
        presenter = new AllGamesPresenter(interactor);
        presenter.setView(view);
        presenter.onCreate();
    }

    @Test
    public void requestsSteamIdOnCreate() {
        verify(view, times(1)).requestSteamId();
    }

}
