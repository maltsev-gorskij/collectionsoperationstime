package ru.lyrian.collections_operations_time.presentation.collections;

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
import ru.lyrian.collections_operations_time.model.lists.creation.CreateCollectionsOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.ArrayListOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.CopyOnWriteArrayListOperations;
import ru.lyrian.collections_operations_time.model.lists.measurements.LinkedListOperations;
import ru.lyrian.collections_operations_time.util.Utility;
import ru.lyrian.collections_operations_time.presentation.BasePresenterTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionsPresenterTest extends BasePresenterTest {
    @Spy
    @InjectMocks
    private CollectionsPresenter collectionsPresenterSpy;

    @Before
    public void setupMocks() {
        MockitoAnnotations.openMocks(this);
        setupMeasurementsStorageMock();
        setupMeasurementMock();
        this.operations = this.collectionsPresenterSpy.getOperations(this.collectionSize);
        setupCollectionsPresenterSpy();
    }

    private void setupMeasurementsStorageMock() {
        Mockito.when(this.measurementsStorageMock.getMeasurementsObservable()).thenReturn(ReplaySubject.createWithSize(Utility.OPERATIONS_COUNT));
        Mockito.when(this.measurementsStorageMock.getOnCompleteSubject(this.collectionsPresenterSpy.getFragmentTag())).thenReturn(PublishSubject.create());
    }

    private void setupMeasurementMock() {
        Mockito.when(this.measurementMock.getViewTag()).thenReturn(ViewTag.TV_ARRAY_LIST_CREATE);
        Mockito.when(this.measurementMock.getExecutionTime()).thenReturn(this.executionTime);
    }

    private void setupCollectionsPresenterSpy() {
        Mockito.doReturn(this.operationsMock).when(this.collectionsPresenterSpy).getOperations(this.collectionSize);
        this.collectionsPresenterSpy.attach(viewMock);
    }

    @Test
    public void attach() {
        Mockito.verify(this.measurementsStorageMock).getMeasurementsObservable();
        Mockito.verify(this.measurementsStorageMock).getOnCompleteSubject(this.fragmentTagCaptor.capture());
        assertEquals(this.collectionsPresenterSpy.getFragmentTag(), this.fragmentTagCaptor.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void attachNullArgument() {
        this.collectionsPresenterSpy.attach(null);
    }

    @Test
    public void detach() {
        this.collectionsPresenterSpy.detach();
        this.collectionsPresenterSpy.publishChanges(this.measurementMock);
        Mockito.verify(this.measurementMock, Mockito.never()).getViewTag();
    }

    @Test
    public void publishChanges() {
        this.collectionsPresenterSpy.publishChanges(this.measurementMock);
        Mockito.verify(this.measurementMock).getViewTag();
        Mockito.verify(this.measurementMock).getExecutionTime();
        Mockito.verify(this.viewMock).setTextViewValue(viewTagCaptor.capture(), stringCaptor.capture());
        assertEquals(this.measurementMock.getViewTag(), this.viewTagCaptor.getValue());
        assertEquals(String.valueOf(this.measurementMock.getExecutionTime()), stringCaptor.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void publishChangesNullArgument() {
        this.collectionsPresenterSpy.publishChanges(null);
    }


    @Test
    public void prepareOperations() {
        this.collectionsPresenterSpy.prepareOperations(this.collectionSize);
        Mockito.verify(this.viewMock).onOperationsStart();
        Mockito.verify(this.collectionsPresenterSpy, Mockito.times(2)).getOperations(integerCaptor.capture());
        assertEquals(this.collectionSize, integerCaptor.getValue());
        Mockito.verify(this.measurementsStorageMock).executeOperations(this.operationsCaptor.capture());
        assertEquals(this.operationsMock, this.operationsCaptor.getValue());
    }

    @Test
    public void fragmentTag() {
        FragmentTag fragmentTag = this.collectionsPresenterSpy.getFragmentTag();
        assertEquals(FragmentTag.COLLECTIONS, fragmentTag);
    }

    @Test
    public void operationsObjectFragmentTag() {
        assertEquals(FragmentTag.COLLECTIONS, this.operations.getFragmentTag());
    }

    @Test
    public void operationsCreationClass() {
        assertTrue(this
                .operations
                .getCreationOperations() instanceof CreateCollectionsOperations);
    }

    @Test
    public void operationsObjectCreationClassListSize() {
        assertEquals(3, this
                .operations
                .getCreationOperations()
                .getOperationsList()
                .size());
    }

    @Test
    public void operationsObjectMeasurementMapSize() {
        assertEquals(3, this
                .operations
                .getMeasurementOperations().size());
    }

    @Test
    public void operationsObjectMeasurementMapClasses() {
        assertTrue(this
                .operations
                .getMeasurementOperations().containsKey(ViewTag.TV_ARRAY_LIST_CREATE));
        assertTrue(this
                .operations
                .getMeasurementOperations().containsKey(ViewTag.TV_LINKED_LIST_CREATE));
        assertTrue(this
                .operations
                .getMeasurementOperations().containsKey(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE));
        assertTrue(this
                .operations
                .getMeasurementOperations().get(ViewTag.TV_ARRAY_LIST_CREATE) instanceof ArrayListOperations);
        assertTrue(this
                .operations
                .getMeasurementOperations().get(ViewTag.TV_LINKED_LIST_CREATE) instanceof LinkedListOperations);
        assertTrue(this
                .operations
                .getMeasurementOperations().get(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE) instanceof CopyOnWriteArrayListOperations);
    }

    @Test
    public void operationsObjectMeasurementClassesListSizes() {
        assertEquals(7, this
                .operations
                .getMeasurementOperations()
                .get(ViewTag.TV_ARRAY_LIST_CREATE)
                .getOperationsList()
                .size());
        assertEquals(7, this
                .operations
                .getMeasurementOperations()
                .get(ViewTag.TV_LINKED_LIST_CREATE)
                .getOperationsList()
                .size());
        assertEquals(7, this
                .operations
                .getMeasurementOperations()
                .get(ViewTag.TV_COPY_ON_WRITE_ARRAY_LIST_CREATE)
                .getOperationsList()
                .size());
    }
}
