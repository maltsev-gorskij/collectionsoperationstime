package ru.lyrian.collections_operations_time;

import android.app.Application;
import android.content.Context;

import androidx.test.runner.AndroidJUnitRunner;

import ru.lyrian.collections_operations_time.di.app.TestApp;

public class TestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestApp.class.getName(), context);
    }
}

