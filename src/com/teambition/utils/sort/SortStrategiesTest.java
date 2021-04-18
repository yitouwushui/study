package com.teambition.utils.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.DATE;

/**
 * Created by yitouwushui on 2018/9/7.
 */
public class SortStrategiesTest {

    class SortData {
        Date created = null;
        Boolean isDone = false;
        Date accomplished = null;
        Float pos = 0f;

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public Boolean getDone() {
            return isDone;
        }

        public void setDone(Boolean done) {
            isDone = done;
        }

        public Date getAccomplished() {
            return accomplished;
        }

        public void setAccomplished(Date accomplished) {
            this.accomplished = accomplished;
        }

        public Float getPos() {
            return pos;
        }

        public void setPos(Float pos) {
            this.pos = pos;
        }
    }

    private SortData mMockTask1 = null;
    private SortData mMockTask2 = null;
    private SortData mMockTask3 = null;
    private SortData mMockTask4 = null;
    private SortData mMockTask5 = null;

    private ArrayList<SortData> mMockTasks = new ArrayList<>();

//    @BeforeEach
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH, DATE);
        Date created1 = calendar.getTime();
        calendar.set(YEAR, MONTH, DATE + 1);
        Date created2 = calendar.getTime();
        Date accomplished1 = calendar.getTime();
        calendar.set(YEAR, MONTH, DATE + 2);
        Date created3 = calendar.getTime();
        Date accomplished2 = calendar.getTime();
        calendar.set(YEAR, MONTH, DATE + 3);
        Date created4 = calendar.getTime();
        calendar.set(YEAR, MONTH, DATE + 4);
        Date created5 = calendar.getTime();
        mMockTask1 = new SortData();
        mMockTask2 = new SortData();
        mMockTask3 = new SortData();
        mMockTask4 = new SortData();
        mMockTask5 = new SortData();
        initTask(mMockTask1, false, 1f, created2, null);
        initTask(mMockTask2, true, 2f, created3, accomplished1);
        initTask(mMockTask3, false, 3f, created4, null);
        initTask(mMockTask4, true, 4f, created5, accomplished2);
        initTask(mMockTask5, false, 5f, created1, null);
        mMockTasks.add(mMockTask1);
        mMockTasks.add(mMockTask2);
        mMockTasks.add(mMockTask3);
        mMockTasks.add(mMockTask4);
        mMockTasks.add(mMockTask5);
    }

    private void initTask(SortData task, boolean isDone, float pos, Date created, Date accomplishedDate) {
        task.isDone = isDone;
        task.pos = pos;
        task.created = created;
        task.accomplished = accomplishedDate;
    }

    public static void main(String[] args) {
        SortStrategiesTest sortStrategiesTest = new SortStrategiesTest();
        sortStrategiesTest.setUp();

        Collections.sort(sortStrategiesTest.mMockTasks,
                SortStrategies.assemble(
                        SortStrategy.ascendant(SortData::getAccomplished),
                        SortStrategy.ascendant(SortData::getCreated)
                ).buildComparator());

        for (SortData mMockTask : sortStrategiesTest.mMockTasks) {
            System.out.println(mMockTask.getPos());
        }

    }

//    @BFSTraverse
//    public void ascendantDate() {
//        Collections.sort(mMockTasks,
//                SortStrategies.assemble(
////                        SortStrategy.ascendant(SortData::getAccomplished),
//                        SortStrategy.ascendant(SortData::getCreated)
//                ).buildComparator());
//
//        Assert.assertSame(mMockTask5, mMockTasks.get(0));
//        Assert.assertSame(mMockTask1, mMockTasks.get(1));
//        Assert.assertSame(mMockTask2, mMockTasks.get(2));
//        Assert.assertSame(mMockTask3, mMockTasks.get(3));
//        Assert.assertSame(mMockTask4, mMockTasks.get(4));
//    }

}
