package ru.lyrian.collections_operations_time;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class CollectionsFragmentTest {
    private final int collectionsSize = 1000;
    private final FragmentTag fragmentTag = FragmentTag.COLLECTIONS;
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
    }

    @Test
    public void viewsInitialState() {
        onView(withId(R.id.etCollectionsSizeHint)).check(matches(isDisplayed()));
        onView(withId(R.id.etCollectionsSize)).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_COLLECTIONS)))).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsObject)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsFillInTime)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsAddInBeginning)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsAddInMiddle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsAddInEnd)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsSearchByValue)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsRemoveFromBeginning)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsRemoveFromMiddle)).check(matches(isDisplayed()));
        onView(withId(R.id.tvRowCollectionsRemoveFromEnd)).check(matches(isDisplayed()));
        onView(withId(R.id.tvColumnArrayList)).check(matches(isDisplayed()));
        onView(withId(R.id.tvColumnLinkedList)).check(matches(isDisplayed()));
        onView(withId(R.id.tvColumnCowArrayList)).check(matches(isDisplayed()));

        onView(withId(R.id.tvArrayListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListAddInTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvArrayListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListAddInTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvLinkedListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.pbArrayListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListAddToBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbArrayListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListAddToBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbLinkedListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListCreate)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListAddToBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListAddInTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListAddInTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListSearchByValue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListRemoveFromTheBeginning)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListRemoveFromTheMiddle)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.pbCopyOnWriteArrayListRemoveFromTheEnd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(withId(R.id.etCollectionsSizeHint)).check(matches(withText(R.string.et_collection_size_hint)));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_COLLECTIONS)))).check(matches(withText(R.string.bt_evaluate_hint)));
        onView(withId(R.id.tvArrayListCreate)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListAddInTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListAddInTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListAddInTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListSearchByValue)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListRemoveFromTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListRemoveFromTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvArrayListRemoveFromTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListCreate)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListAddInTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListAddInTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListAddInTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListSearchByValue)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListRemoveFromTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListRemoveFromTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvLinkedListRemoveFromTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListCreate)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListAddInTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListSearchByValue)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheBeginning)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheMiddle)).check(matches(withText(R.string.tv_filling_hint)));
        onView(withId(R.id.tvCopyOnWriteArrayListRemoveFromTheEnd)).check(matches(withText(R.string.tv_filling_hint)));
    }

    @Test
    public void measurementsAppeared() {
        Observable<Measurement> measurementObservable = this.measurementsStorage
                .getMeasurementsObservable()
                .filter(measurement -> measurement.getViewTag() != null)
                .filter(measurement -> measurement.getViewTag().getFragmentTag() == this.fragmentTag)
                .observeOn(AndroidSchedulers.mainThread());

        onView(withId(R.id.etCollectionsSize)).perform(clearText());
        onView(withId(R.id.etCollectionsSize)).perform(typeText(String.valueOf(this.collectionsSize)));
        onView(allOf(withId(R.id.btEvaluate), withTagValue(is(ButtonTag.BT_COLLECTIONS)))).perform(click());

        List<Measurement> measurements = new ArrayList<>();
        measurementObservable
                .subscribe(measurement -> {
                    measurements.add(measurement);
                });

        measurementObservable
                .test()
                .awaitCount(24)
                .assertNotComplete();

        assertEquals(24, measurements.size());

        for (Measurement measurement : measurements) {
            ViewTag viewTag = measurement.getViewTag();
            int executionTime = measurement.getExecutionTime();
            onView(withTagValue(is(viewTag))).check(matches(withText(String.valueOf(executionTime))));
        }
    }
}
