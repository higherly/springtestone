package studyThread.first.study.createThread;

public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread类子线程开始运行");
    }
}
