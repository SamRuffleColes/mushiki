package es.rufflecol.sam.mushiki.presentation.allgames;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Collections;
import java.util.List;

import es.rufflecol.sam.mushiki.data.interactor.Interactor;
import es.rufflecol.sam.mushiki.data.steam.community.model.SteamGame;

import static junit.framework.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
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

    @Test
    public void showsErrorWhenFetchSteamGamesFailsForSteamId() {
        doAnswer(new FetchSteamGamesInteractorListenerAnswer() {
            @Override
            protected void answer(Interactor.FetchSteamGames.Listener listener) {
                listener.onFetchSteamGamesFailure();
            }
        }).when(interactor).fetchForId(any(Long.class));

        fail("not finished");
    }

    @Test
    public void showsGamesWhenFetchSteamGamesSucceedsForSteamUsername() {
        doAnswer(new FetchSteamGamesInteractorListenerAnswer() {
            @Override
            protected void answer(Interactor.FetchSteamGames.Listener listener) {
                listener.onFetchSteamGamesSuccess(mockGamesList());
            }
        }).when(interactor).fetchForUsername(any(String.class));

        fail("not finished");
    }

    private static List<SteamGame> mockGamesList() {
        return Collections.EMPTY_LIST;
    }

    private abstract static class FetchSteamGamesInteractorListenerAnswer implements Answer<Void> {
        @Override
        public Void answer(InvocationOnMock invocation) throws Throwable {
            Interactor.FetchSteamGames.Listener listener = (Interactor.FetchSteamGames.Listener) invocation.getArguments()[2];
            answer(listener);
            return null;
        }

        protected abstract void answer(Interactor.FetchSteamGames.Listener listener);
    }

}
