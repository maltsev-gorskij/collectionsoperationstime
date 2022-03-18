package ru.lyrian.collections_operations_time.presentation.maps;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.lists.creation.CreateMapsOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.HashMapOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.TreeMapOperations;
import ru.lyrian.collections_operations_time.util.Utility;
import ru.lyrian.collections_operations_time.presentation.BasePresenterTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapsPresenterTest extends BasePresenterTest {
    @Spy
    @InjectMocks
    private MapsPresenter mapsPresenterSpy;

    @Before
    public void setupMocks() {
        MockitoAnnotations.openMocks(this);
        setupMeasurementsStorageMock();
        setupMeasurementMock();
        this.operations = this.mapsPresenterSpy.getOperations(this.collectionSize);
        setupMapsPresenterSpy();
    }

    private void setupMeasurementsStorageMock() {
        Mockito.when(this.measurementsStorageMock.getMeasurementsObservable()).thenReturn(ReplaySubject.createWithSize(Utility.OPERATIONS_COUNT));
        Mockito.when(this.measurementsStorageMock.getOnCompleteSubject(this.mapsPresenterSpy.getFragmentTag())).thenReturn(PublishSubject.create());
    }

    private void setupMeasurementMock() {
        Mockito.when(this.measurementMock.getViewTag()).thenReturn(ViewTag.TV_ARRAY_LIST_CREATE);
        Mockito.when(this.measurementMock.getExecutionTime()).thenReturn(this.executionTime);
    }

    private void setupMapsPresenterSpy() {
        Mockito.doReturn(this.operationsMock).when(this.mapsPresenterSpy).getOperations(this.collectionSize);
        this.mapsPresenterSpy.attach(viewMock);
    }

    @Test
    public void attach() {
        Mockito.verify(this.measurementsStorageMock).getMeasurementsObservable();
        Mockito.verify(this.measurementsStorageMock).getOnCompleteSubject(this.fragmentTagCaptor.capture());
        assertEquals(this.mapsPresenterSpy.getFragmentTag(), this.fragmentTagCaptor.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void attachNullArgument() {
        this.mapsPresenterSpy.attach(null);
    }

    @Test
    public void detach() {
        this.mapsPresenterSpy.detach();
        this.mapsPresenterSpy.publishChanges(this.measurementMock);
        Mockito.verify(this.measurementMock, Mockito.never()).getViewTag();
    }

    @Test
    public void publishChanges() {
        this.mapsPresenterSpy.publishChanges(this.measurementMock);
        Mockito.verify(this.measurementMock).getViewTag();
        Mockito.verify(this.measurementMock).getExecutionTime();
        Mockito.verify(this.viewMock).setTextViewValue(viewTagCaptor.capture(), stringCaptor.capture());
        assertEquals(this.measurementMock.getViewTag(), this.viewTagCaptor.getValue());
        assertEquals(String.valueOf(this.measurementMock.getExecutionTime()), stringCaptor.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void publishChangesNullArgument() {
        this.mapsPresenterSpy.publishChanges(null);
    }

    @Test
    public void prepareOperations() {
        this.mapsPresenterSpy.prepareOperations(this.collectionSize);
        Mockito.verify(this.viewMock).onOperationsStart();
        Mockito.verify(this.mapsPresenterSpy, Mockito.times(2)).getOperations(integerCaptor.capture());
        assertEquals(this.collectionSize, integerCaptor.getValue());
        Mockito.verify(this.measurementsStorageMock).executeOperations(this.operationsCaptor.capture());
        assertEquals(this.operationsMock, this.operationsCaptor.getValue());
    }

    @Test
    public void fragmentTag() {
        FragmentTag fragmentTag = this.mapsPresenterSpy.getFragmentTag();
        assertEquals(FragmentTag.MAPS, fragmentTag);
    }

    @Test
    public void operationsObjectFragmentTag() {
        assertEquals(FragmentTag.MAPS, this.operations.getFragmentTag());
    }

    @Test
    public void operationsObjectCreationClass() {
        assertTrue(this
                .operations
                .getCreationOperations() instanceof CreateMapsOperations);
    }

    @Test
    public void operationsObjectCreationClassListSize() {
        assertEquals(2, this
                .operations
                .getCreationOperations()
                .getOperationsList()
                .size());
    }

    @Test
    public void operationsObjectMeasurementMapSize() {
        assertEquals(2, this
                .operations
                .getMeasurementOperations().size());
    }

    @Test
    public void operationsObjectMeasurementMapClasses() {
        assertTrue(this
                .operations
                .getMeasurementOperations().containsKey(ViewTag.TV_HASH_MAP_CREATE));
        assertTrue(this
                .operations
                .getMeasurementOperations().containsKey(ViewTag.TV_TREE_MAP_CREATE));
        assertTrue(this
                .operations
                .getMeasurementOperations().get(ViewTag.TV_HASH_MAP_CREATE) instanceof HashMapOperations);
        assertTrue(this
                .operations
                .getMeasurementOperations().get(ViewTag.TV_TREE_MAP_CREATE) instanceof TreeMapOperations);
    }

    @Test
    public void operationsObjectMeasurementClassesListSizes() {
        assertEquals(3, this
                .operations
                .getMeasurementOperations()
                .get(ViewTag.TV_HASH_MAP_CREATE)
                .getOperationsList()
                .size());
        assertEquals(3, this
                .operations
                .getMeasurementOperations()
                .get(ViewTag.TV_TREE_MAP_CREATE)
                .getOperationsList()
                .size());
    }
}
