package studyThread.first.study.synThread;

public class Thread1 implements Runnable {
    /*实现同步的两种方式，
    * 1：同步方法，会把整个方法都保护起来
    * 2：同步代码块，只同步需要的代码部分
    * */
    /*第一种*/
  /*  public synchronized void run() {
        for(int i=0;i<10;i++){
            System.out.print(i);
        }
    }*/
  /*第二种只同步需要保护的代码部分*/
    public  void run() {
        synchronized(this){
            for(int i=0;i<10;i++){
                System.out.print(i);
            }
        }
    }
}
