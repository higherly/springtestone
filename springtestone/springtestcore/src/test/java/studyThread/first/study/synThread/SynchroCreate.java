package studyThread.first.study.synThread;

import org.junit.Test;

/*
* 线程的同步实现方式，通过synchronized关键字，
* 分为同步方法和同步代码块，同步的是对象
*
* */
public class SynchroCreate {
    @Test
    public void test1() {
        /*同一个对象的多个线程，只有一个线程可以访问*/
        Thread1 r = new Thread1();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
    @Test
    public void test2() {
        Thread1 r1= new Thread1();
        Thread1 r2= new Thread1();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
