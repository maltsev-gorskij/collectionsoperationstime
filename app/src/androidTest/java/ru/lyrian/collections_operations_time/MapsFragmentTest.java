package ru.lyrian.collections_operations_time;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.ReplaySubject;
import ru.lyrian.collections_operations_time.di.app.TestApp;
import ru.lyrian.collections_operations_time.enumerations.ButtonTag;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.Measurement;
import ru.lyrian.collections_operations_time.model.MeasurementsStorage;
import ru.lyrian.collections_operations_time.util.Utility;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.ViewPagerActions.scrollRight;
import static androidx.test.espresso.matcher.ViewMatchers.Visibility;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class MapsFragmentTest {
    private final int mapsSize = 1_000_000;
    private final FragmentTag fragmentTag = FragmentTag.MAPS;
    private MeasurementsStorage measurementsStorage;

    @Rule
    public final ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        TestApp testApp = ApplicationProvider.getApplicationContext();
        this.measurementsStorage = testApp.getIAppComponent().measurementsStorage();
        ReplaySubject<Measurement> measurementsObservable = (ReplaySubject<Measurement>) this.measurementsStorage.getMeasurementsObservable();
        Measurement measurement = new Measurement(null, 0);
        for (int i = 0; i < Utility.OPERATIONS_COUNT; i++)
            measurementsObservable.onNext(measurement);
        onView(withId(R.id.vpMainActivity)).perform(scrollRight());
    }

    @Test
    public void viewsInitialState() {
        onView(withId(R.id.etMapsSizeHint)).check(matches(isDisplayed()));
        onView(withId(R.id.etMapsSize)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_MAPS)))).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowMapsObject)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowMapsFillInTime)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowMapsAddNew)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowMapsSearchByKey)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowMapsRemoving)).check(matches(isDisplayed()));
        onView(withId(R.id.tvColumnHashMap)).check(matches(isDisplayed()));
        onView(withId(R.id.tvColumnTreeMap)).check(matches(isDisplayed()));

        onView(withId(R.id.tvHashMapCreate)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvHashMapAddNew)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvHashMapSearchByKey)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvHashMapRemoving)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvTreeMapCreate)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvTreeMapAddNew)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvTreeMapSearchByKey)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.tvTreeMapRemoving)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
        onView(withId(R.id.pbHashMapCreate)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbHashMapAddNew)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbHashMapSearchByKey)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbHashMapRemoving)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbTreeMapCreate)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbTreeMapAddNew)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbTreeMapSearchByKey)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));
        onView(withId(R.id.pbTreeMapRemoving)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)));

        onView(withId(R.id.etMapsSizeHint)).check(matches(withText(R.string.et_map_size_hint)));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_MAPS)))).check(matches(withText(R.string.bt_evaluate_hint)));
        onView(withId(R.id.tvHashMapCreate)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvHashMapAddNew)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvHashMapSearchByKey)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvHashMapRemoving)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvTreeMapCreate)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvTreeMapAddNew)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvTreeMapSearchByKey)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvTreeMapRemoving)).check(matches(withText(R.string.tv_filling_hint)));
    }

    @Test
    public void measurementsAppeared() {
        Observable<Measurement> measurementObservable = this.measurementsStorage
                .getMeasurementsObservable()
                .filter(measurement -> measurement.getViewTag() != null)
                .filter(measurement -> measurement.getViewTag().getFragmentTag() == this.fragmentTag)
                .observeOn(AndroidSchedulers.mainThread());

        onView(withId(R.id.etMapsSize)).perform(clearText());
        onView(withId(R.id.etMapsSize)).perform(typeText(String.valueOf(this.mapsSize)));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_MAPS)))).perform(click());

        List<Measurement> measurements = new ArrayList<>();
        measurementObservable
                .subscribe(measurement -> {
                    measurements.add(measurement);
                });

        measurementObservable
                .test()
                .awaitCount(8)
                .assertNotComplete();

        assertEquals(8, measurements.size());

        for (Measurement measurement : measurements) {
            ViewTag viewTag = measurement.getViewTag();
            int executionTime = measurement.getExecutionTime();
            onView(withTagValue(is(viewTag))).check(matches(withText(String.valueOf(executionTime))));
        }
    }
}