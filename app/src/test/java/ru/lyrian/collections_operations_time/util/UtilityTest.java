package ru.lyrian.collections_operations_time.util;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.lyrian.collections_operations_time.enumerations.Collections;

import static org.junit.Assert.assertEquals;

public class UtilityTest {
    private static final int COLLECTIONS_SIZE = 10;
    private static List<Integer> EXPECTED_ARRAY_LIST;
    private static List<Integer> EXPECTED_LINKED_LIST;
    private static List<Integer> EXPECTED_COPY_ON_WRITE_ARRAY_LIST;
    private static Map<Integer, Integer> EXPECTED_HASH_MAP;
    private static Map<Integer, Integer> EXPECTED_TREE_MAP;

    @BeforeClass
    public static void beforeClass() {
        UtilityTest.EXPECTED_ARRAY_LIST = new ArrayList<>();
        UtilityTest.EXPECTED_LINKED_LIST = new LinkedList<>();
        UtilityTest.EXPECTED_COPY_ON_WRITE_ARRAY_LIST = new CopyOnWriteArrayList<>();
        UtilityTest.EXPECTED_HASH_MAP = new HashMap<>();
        UtilityTest.EXPECTED_TREE_MAP = new TreeMap<>();

        for (int i = 0; i < UtilityTest.COLLECTIONS_SIZE; i++) {
            UtilityTest.EXPECTED_ARRAY_LIST.add(i);
            UtilityTest.EXPECTED_LINKED_LIST.add(i);
            UtilityTest.EXPECTED_COPY_ON_WRITE_ARRAY_LIST.add(i);
            UtilityTest.EXPECTED_HASH_MAP.put(i, i);
            UtilityTest.EXPECTED_TREE_MAP.put(i, i);
        }
    }

    @Before
    public void before() {
        Utility.emptyLists();
        Utility.emptyMaps();
    }

    @AfterClass
    public static void afterClass() {
        UtilityTest.EXPECTED_ARRAY_LIST = null;
        UtilityTest.EXPECTED_LINKED_LIST = null;
        UtilityTest.EXPECTED_COPY_ON_WRITE_ARRAY_LIST = null;
        UtilityTest.EXPECTED_HASH_MAP = null;
        UtilityTest.EXPECTED_TREE_MAP = null;
    }

    @Test
    public void arrayListFilling() {
        Utility.getFilledCollection(Collections.ARRAY_LIST, UtilityTest.COLLECTIONS_SIZE);
        assertEquals(UtilityTest.EXPECTED_ARRAY_LIST, Utility.arrayList);
    }
    @Test
    public void linkedListFilling() {
        Utility.getFilledCollection(Collections.LINKED_LIST, UtilityTest.COLLECTIONS_SIZE);
        assertEquals(UtilityTest.EXPECTED_LINKED_LIST, Utility.linkedList);
    }

    @Test
    public void copyOnWriteArrayListFilling() {
        Utility.getFilledCollection(Collections.COPY_ON_WRITE_ARRAY_LIST, UtilityTest.COLLECTIONS_SIZE);
        assertEquals(UtilityTest.EXPECTED_COPY_ON_WRITE_ARRAY_LIST, Utility.copyOnWriteArrayList);
    }

    @Test
    public void haspMapFilling() {
        Utility.getFilledCollection(Collections.HASH_MAP, UtilityTest.COLLECTIONS_SIZE);
        assertEquals(UtilityTest.EXPECTED_HASH_MAP, Utility.hashMap);
    }

    @Test
    public void treeMapFilling() {
        Utility.getFilledCollection(Collections.TREE_MAP, UtilityTest.COLLECTIONS_SIZE);
        assertEquals(UtilityTest.EXPECTED_TREE_MAP, Utility.treeMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongCollectionFilling() {
        Utility.getFilledCollection(null, UtilityTest.COLLECTIONS_SIZE);
    }

    @Test
    public void zeroLengthCollectionFilling() {
        Utility.getFilledCollection(Collections.ARRAY_LIST, 0);
        assertEquals(Utility.arrayList.size(), 0);
    }
}
