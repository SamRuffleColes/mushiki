package es.rufflecol.sam.mushiki.presentation.allgames;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.inject.Singleton;

import dagger.Component;
import es.rufflecol.sam.mushiki.R;
import es.rufflecol.sam.mushiki.application.MockApp;
import es.rufflecol.sam.mushiki.application.di.AppComponent;
import es.rufflecol.sam.mushiki.application.di.MockPresenterModule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AllGamesActivityTest {

    @Singleton
    @Component(modules = MockPresenterModule.class)
    public interface TestApplicationComponent extends AppComponent {
        void inject(AllGamesActivity activity);
    }

    @Rule
    public ActivityTestRule<AllGamesActivity> activityRule = new ActivityTestRule<>(AllGamesActivity.class, true, false);

    private AllGamesMvp.Presenter presenter;
    private AllGamesMvp.View view;

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MockApp app = (MockApp) instrumentation.getTargetContext().getApplicationContext();

        createMockPresenter();
        MockPresenterModule mockPresenterModule = new MockPresenterModule();
        mockPresenterModule.setAllGamesPresenter(presenter);

        app.setAppComponent(DaggerAllGamesActivityTest_TestApplicationComponent.builder()
                .mockPresenterModule(mockPresenterModule)
                .build());

        activityRule.launchActivity(new Intent());
    }

    private void createMockPresenter() {
        presenter = mock(AllGamesMvp.Presenter.class);
        captureViewArgumentWhenPresenterSetView();
        requestSteamIdWhenPresenterOnCreate();
    }

    private void captureViewArgumentWhenPresenterSetView() {
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                view = (AllGamesMvp.View) invocation.getArguments()[0];
                return null;
            }
        }).when(presenter).setView(any(AllGamesMvp.View.class));
    }

    private void requestSteamIdWhenPresenterOnCreate() {
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                view.requestSteamId();
                return null;
            }
        }).when(presenter).onCreate();
    }

    @Test
    public void requestSteamIdDialogCallsFetchGamesForUserWithInputUsername() {
        onView(withId(R.id.editext)).perform(typeText("myUsername"), closeSoftKeyboard());
        onView(withText(R.string.ok)).perform(click());
        verify(presenter, times(1)).fetchGamesForUser("myUsername");
    }

}
