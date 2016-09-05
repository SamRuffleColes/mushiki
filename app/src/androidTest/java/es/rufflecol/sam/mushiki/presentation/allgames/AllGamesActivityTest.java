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
import org.mockito.Mockito;

import es.rufflecol.sam.mushiki.application.MockApp;
import es.rufflecol.sam.mushiki.application.di.DaggerAppComponent;
import es.rufflecol.sam.mushiki.application.di.MockPresenterModule;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AllGamesActivityTest {

    @Rule
    public ActivityTestRule<AllGamesActivity> activityRule = new ActivityTestRule<>(AllGamesActivity.class, true, false);

    private AllGamesMvp.Presenter presenter;
    private AllGamesMvp.View view;

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MockApp app = (MockApp) instrumentation.getTargetContext().getApplicationContext();

        presenter = Mockito.mock(AllGamesMvp.Presenter.class);
        MockPresenterModule mockPresenterModule = new MockPresenterModule();
        mockPresenterModule.setAllGamesPresenter(presenter);

        app.setAppComponent(DaggerAppComponent.builder()
                .presenterModule(mockPresenterModule)
                .build());
    }

    @Test
    public void testNothing() {
        launchActivity();
    }

    private void launchActivity() {
        activityRule.launchActivity(new Intent());
        view = activityRule.getActivity();
    }

}
