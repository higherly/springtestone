package studyThread.first.study.createThread;

import org.junit.Test;

/*
* 线程的两种实现方式:
* 1：继承Thread类
* 2：实现Runnable接口
*(待理解)
* 实现Runnable接口比继承Thread类所具有的优势：
1）：适合多个相同的程序代码的线程去处理同一个资源

2）：可以避免java中的单继承的限制

3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
*
*
* 线程的五种状态
* 1：新建状态
* 2：就绪状态
* 3：运行状态
* 4：阻塞状态
* 5：死亡状态：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
* */
public class CreateThread {
    /*第一种方法:继承Thread类的线程*/
    @Test
    public void test1 () {
        Thread1 t1 = new Thread1();
        t1.start();/*start()不是立即运行线程，而是使其处于就绪状态，什时候运行是有cpu决定的*/
        System.out.println(2222);
    }
    /*第二种方法:实现Runnable接口的线程*/
    @Test
    public void test2 () {
        Thread t = new Thread(new Thread2());
        t.start();
        System.out.println(2222);
    }
    /*join()方法 主线程需要等待子线程运行完后在结束*/
    @Test
    public void test3() throws InterruptedException{
        Thread1 t1 = new Thread1();
        t1.start();
        t1.join();/*join()是编译时异常，需要显示处理，两种方法，一是在方法中声明异常，而是通过try..catch{}捕获*/
        System.out.println("主线程运行结束");
    }
    /*yield()只是使当前线程重新回到就绪，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。*/
    @Test
    public void test4() {
    }
    /*interrupt() 发送一个中断信号，让无限等待的线程(如死锁)能抛出，从而结束*/
    @Test
    public void test5() {
    }
    /*wait()当前线程处于等待，直到其他线程调用此对象的notify()或者notifyAll()方法
    * notify() 唤醒在此对象上等待的单个线程
    * */
}
