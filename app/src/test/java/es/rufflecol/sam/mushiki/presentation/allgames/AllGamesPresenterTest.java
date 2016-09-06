package es.rufflecol.sam.mushiki.presentation.allgames;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import es.rufflecol.sam.mushiki.data.interactor.Interactor;
import es.rufflecol.sam.mushiki.data.steam.community.model.SteamGame;
import es.rufflecol.sam.mushiki.data.steam.community.model.SteamGameBuilder;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AllGamesPresenterTest {

    @Mock
    Interactor.FetchSteamGames interactor;

    @Mock
    AllGamesMvp.View view;

    AllGamesPresenter presenter;

    @Before
    public void setUp() {
        presenter = new AllGamesPresenter(interactor);
        presenter.setView(view);
        presenter.onCreate();
    }

    @Test
    public void requestsSteamIdOnCreate() {
        verify(view).requestSteamId();
    }

    @Test
    public void displaysErrorWhenFetchSteamGamesFailsForSteamId() {
        doAnswer(new FetchSteamGamesInteractorListenerAnswer() {
            @Override
            protected void answer(Interactor.FetchSteamGames.Listener listener) {
                listener.onFetchSteamGamesFailure();
            }
        }).when(interactor).fetchForId(1234l, presenter);

        presenter.fetchGamesForUser("1234");

        verify(view).displayError();
    }

    @Test
    public void displaysGamesWhenFetchSteamGamesSucceedsForSteamUsername() {
        doAnswer(new FetchSteamGamesInteractorListenerAnswer() {
            @Override
            protected void answer(Interactor.FetchSteamGames.Listener listener) {
                listener.onFetchSteamGamesSuccess(testDataSteamGameList());
            }
        }).when(interactor).fetchForUsername("myUsername", presenter);

        presenter.fetchGamesForUser("myUsername");

        verify(view).displayGames(testDataSteamGameList());
    }

    private static List<SteamGame> testDataSteamGameList() {
        return Arrays.asList(new SteamGameBuilder().name("Game One").logo("http://fake.url").build(),
                new SteamGameBuilder().name("Game Two").logo("http://fake2.url").build(),
                new SteamGameBuilder().name("Game Three").logo("http://fake3.url").build());
    }

    private abstract static class FetchSteamGamesInteractorListenerAnswer implements Answer<Void> {
        @Override
        public Void answer(InvocationOnMock invocation) throws Throwable {
            Interactor.FetchSteamGames.Listener listener = (Interactor.FetchSteamGames.Listener) invocation.getArguments()[1];
            answer(listener);
            return null;
        }

        protected abstract void answer(Interactor.FetchSteamGames.Listener listener);
    }

}
