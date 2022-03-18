package ru.lyrian.collections_operations_time.presentation;

import org.junit.After;
import org.junit.BeforeClass;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import ru.lyrian.collections_operations_time.enumerations.FragmentTag;
import ru.lyrian.collections_operations_time.enumerations.ViewTag;
import ru.lyrian.collections_operations_time.model.IMeasurementContract;
import ru.lyrian.collections_operations_time.model.Measurement;
import ru.lyrian.collections_operations_time.model.operations.Operations;

public abstract class BasePresenterTest {
    protected final Integer collectionSize = 1000;
    protected final Integer executionTime = 100;
    protected Operations operations;

    @Mock
    protected Operations operationsMock;

    @Mock
    protected Measurement measurementMock;

    @Mock
    protected IFragmentContract.IView viewMock;

    @Mock
    protected IMeasurementContract.IMeasurementsStorage measurementsStorageMock;

    @Captor
    protected ArgumentCaptor<FragmentTag> fragmentTagCaptor;

    @Captor
    protected ArgumentCaptor<ViewTag> viewTagCaptor;

    @Captor
    protected ArgumentCaptor<String> stringCaptor;

    @Captor
    protected ArgumentCaptor<Integer> integerCaptor;

    @Captor
    protected ArgumentCaptor<Operations> operationsCaptor;

    @BeforeClass
    public static void setupThreads() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @After
    public void after() {
        this.operations = null;
    }
}
