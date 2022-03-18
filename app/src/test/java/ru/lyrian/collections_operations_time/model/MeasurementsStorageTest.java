package ru.lyrian.collections_operations_time.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.AbstractOperationsList;
import ru.lyrian.collections_operations_time.model.lists.creation.CreateMapsOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.HashMapOperations;
import ru.lyrian.collections_operations_time.model.operations.Operations;
import ru.lyrian.collections_operations_time.model.operations.creation.HashMapCreate;
import ru.lyrian.collections_operations_time.model.operations.operations.AbstractOperation;
import ru.lyrian.collections_operations_time.presentation.maps.MapsPresenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MeasurementsStorageTest {
    private final Integer collectionSize = 100;
    private final ViewTag haspMapCreationTag = ViewTag.TV_HASH_MAP_CREATE;
    private final String onCompleteMessage = "onComplete";

    @Spy
    private MeasurementsStorage measurementsStorageSpy;

    @Mock
    private MapsPresenter mapsPresenterMock;

    @Mock
    private CreateMapsOperations createMapsOperationsMock;

    @Mock
    private Operations operationsMock;

    @Mock
    Map<ViewTag, AbstractOperationsList> measurementOperationsMock;

    @Captor
    private ArgumentCaptor<ViewTag> viewTagCaptor;

    @BeforeClass
    public static void setupThreads() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        RxJavaPlugins.setComputationSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Before
    public void setupMocks() {
        MockitoAnnotations.openMocks(this);
        setupMapsPresenterMock();
        setupCreateMapsOperationsMock();
        setupMeasurementOperationsMock();
        setupOperationsMock();
    }

    private void setupMapsPresenterMock() {
        Mockito.when(this.mapsPresenterMock.getFragmentTag()).thenReturn(FragmentTag.MAPS);
    }

    private void setupCreateMapsOperationsMock() {
        Mockito.when(this.createMapsOperationsMock.getOperationsList()).thenReturn(new ArrayList<AbstractOperation>() {{
            add(new HashMapCreate(haspMapCreationTag, collectionSize));
        }});
    }

    private void setupMeasurementOperationsMock() {
        Mockito.when(this.measurementOperationsMock.get(this.haspMapCreationTag)).thenReturn(new HashMapOperations());
    }

    private void setupOperationsMock() {
        FragmentTag fragmentTag = this.mapsPresenterMock.getFragmentTag();
        Mockito.when(this.operationsMock.getFragmentTag()).thenReturn(fragmentTag);
        Mockito.when(this.operationsMock.getCreationOperations()).thenReturn(this.createMapsOperationsMock);
        Mockito.when(this.operationsMock.getMeasurementOperations()).thenReturn(this.measurementOperationsMock);
    }

    @Test
    public void getMeasurementsObservable() {
        ReplaySubject<Measurement> subject = (ReplaySubject<Measurement>) this.measurementsStorageSpy.getMeasurementsObservable();
        assertTrue(subject instanceof ReplaySubject);
    }

    @Test(expected = NullPointerException.class)
    public void getOnCompleteSubjectNullArgument() {
        this.measurementsStorageSpy.getOnCompleteSubject(null);
    }

    @Test
    public void getOnCompleteSubject() {
        Observable<String> newMapsSubject = this.measurementsStorageSpy.getOnCompleteSubject(this.mapsPresenterMock.getFragmentTag());
        Observable<String> existedMapsSubject = this.measurementsStorageSpy.getOnCompleteSubject(this.mapsPresenterMock.getFragmentTag());
        assertTrue(newMapsSubject instanceof PublishSubject);
        assertEquals(newMapsSubject, existedMapsSubject);
    }

    @Test(expected = NullPointerException.class)
    public void executeOperationsNullArgument() {
        this.measurementsStorageSpy.executeOperations(null);
    }

    @Test
    public void executeOperations() {
        this.measurementsStorageSpy.getOnCompleteSubject(this.mapsPresenterMock.getFragmentTag());
        this.measurementsStorageSpy.executeOperations(this.operationsMock);
        Mockito.verify(this.operationsMock).getFragmentTag();
        Mockito.verify(this.operationsMock).getCreationOperations();
        Mockito.verify(this.operationsMock.getMeasurementOperations()).get(this.viewTagCaptor.capture());
        assertEquals(this.haspMapCreationTag, this.viewTagCaptor.getValue());
    }

    @Test
    public void emittedByOnReplaySubject() {
        List<ViewTag> measurements = new ArrayList<>();
        Observable<Measurement> replaySubject = this.measurementsStorageSpy.getMeasurementsObservable();
        TestObserver<Measurement> testObserver = new TestObserver<>();
        replaySubject.subscribe(testObserver);
        this.measurementsStorageSpy.getOnCompleteSubject(this.mapsPresenterMock.getFragmentTag());
        this.measurementsStorageSpy.executeOperations(this.operationsMock);
        testObserver.awaitCount(4);
        testObserver.assertNotComplete();
        testObserver.dispose();
        Disposable disposable = replaySubject.subscribe(measurement -> measurements.add(measurement.getViewTag()));
        assertEquals(4, measurements.size());
        assertTrue(measurements.contains(ViewTag.TV_HASH_MAP_CREATE));
        assertTrue(measurements.contains(ViewTag.TV_HASH_MAP_ADD_NEW));
        assertTrue(measurements.contains(ViewTag.TV_HASH_MAP_SEARCH_BY_KEY));
        assertTrue(measurements.contains(ViewTag.TV_HASH_MAP_REMOVING));
        disposable.dispose();
    }

    @Test
    public void emittedByOnCompleteNotifiers() {
        Observable<String> publishSubject = this.measurementsStorageSpy.getOnCompleteSubject(this.mapsPresenterMock.getFragmentTag());
        TestObserver<String> testObserver = new TestObserver<>();
        publishSubject.subscribe(testObserver);
        this.measurementsStorageSpy.executeOperations(this.operationsMock);
        testObserver.awaitCount(1);
        testObserver.assertValue(this.onCompleteMessage);
        testObserver.dispose();
    }
}
