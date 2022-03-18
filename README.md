## Application
Create an application that will run various operations on collections and maps, count and display the execution time.

## Required functionality
- One Activity with ViewPager, which contains 2 screens with Fragments. Each screen for work with particular collections group.

### Fragment #1

Collection Interface
- ArrayList
- LinkedList
- CopyOnWriteArrayList

Required operations
- Adding in the beginning;
- Adding in the middle;
- Adding in the end;
- Search by value;
- Removing in the beginning;
- Removing in the middle;
- Removing in the end.

### Fragment #2

Map Interface
- TreeMap
- HashMap

Required operations
- Adding new;
- Search by key;
- Removing;

### General
- Text Entry field for specifying collection size.
- Table. Displays results of various operations on collections. Interface realization - row, execution time - colons.
  - Collection table 7 colons and 3 rows;
  - Map table 3 colons and 2 rows;
- The value of each cell is calculated asynchronously. During the calculation, progress bar is displayed inside cell.
- Button which starts calculation.
  - Fills collection with specified amount of elements.
  - Starts asynchronous calculation of each cell value in currently active Fragment.
  - Calculation must be activity independent in case of screen rotation.

## Technology stack
- Language - Java
- Architecture pattern - MVP
- [ViewPager](https://developer.android.com/reference/androidx/viewpager/widget/ViewPager)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
    - [View Binding](https://developer.android.com/topic/libraries/view-binding)
- [Dagger2](https://github.com/google/dagger)
- [RxJava2](https://github.com/ReactiveX/RxJava)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [JUnit](https://github.com/junit-team/junit4)
- [Mockito](https://github.com/mockito/mockito)
- [Espresso](https://developer.android.com/training/testing/espresso?hl=ru)
