package ru.lyrian.collections_operations_time.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.lyrian.collections_operations_time.enumerations.Collections;

public class Utility {
    public static final String APP_LOG_TAG = "mylogtag";
    public static final int OPERATIONS_COUNT = 32;
    public static List<Integer> arrayList;
    public static List<Integer> linkedList;
    public static List<Integer> copyOnWriteArrayList;
    public static Map<Integer, Integer> hashMap = new HashMap<>();
    public static Map<Integer, Integer> treeMap = new TreeMap<>();

    public static void getFilledCollection(Collections collections, int size) {
        if (collections == Collections.ARRAY_LIST) {
            List<Integer> newArrayList = new ArrayList<>();
            fillList(size, newArrayList);
            Utility.arrayList = newArrayList;
        } else if (collections == Collections.LINKED_LIST) {
            List<Integer> newLinkedList = new LinkedList<>();
            fillList(size, newLinkedList);
            Utility.linkedList = newLinkedList;
        } else if (collections == Collections.COPY_ON_WRITE_ARRAY_LIST) {
            List<Integer> newCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
            fillList(size, newCopyOnWriteArrayList);
            Utility.copyOnWriteArrayList = newCopyOnWriteArrayList;
        } else if (collections == Collections.HASH_MAP) {
            Map<Integer, Integer> newHashMap = new HashMap<>();
            fillMap(size, newHashMap);
            Utility.hashMap = newHashMap;
        } else if (collections == Collections.TREE_MAP) {
            Map<Integer, Integer> newTreeMap = new HashMap<>();
            fillMap(size, newTreeMap);
            Utility.treeMap = newTreeMap;
        } else {
            throw new IllegalArgumentException("Invalid Collections enum type");
        }
    }

    private static void fillList(int size, List<Integer> list) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    private static void fillMap(int size, Map<Integer, Integer> map) {
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
    }

    public static void emptyLists() {
        Utility.arrayList = null;
        Utility.linkedList = null;
        Utility.copyOnWriteArrayList = null;
    }

    public static void emptyMaps() {
        Utility.hashMap = null;
        Utility.treeMap = null;
    }
}
