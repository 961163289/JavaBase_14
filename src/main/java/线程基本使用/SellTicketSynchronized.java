package 线程基本使用;

public class SellTicketSynchronized {
    public static void main(String[] args) {

        //测试一把
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程 - 窗口
        new Thread(sellTicket03).start();//第2个线程 - 窗口
        new Thread(sellTicket03).start();//第3个线程 - 窗口

    }
}

//实现接口方式,使用 Synchronized 实现线程同步
class SellTicket03 implements Runnable {

    private int ticketNum = 100; //让多个线程共享 ticketNum
    private boolean loop = true; //控制 run方法变量

    Object object = new Object();

    //同步方法(静态的)的锁为当前类本身
    //老韩解读
    //1. public synchronized static void m1() {}  锁是加在 SellTicket03.class
    //2. 如果在静态方法中,实现一个同步代码块
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    */
    public synchronized static void m1() {
    }

    public static void m2() {
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell(); //sell 方法是一个同步方法
        }
    }

    //老韩说明
    //1. private synchronized void sell() {}  就是一个同步方法
    //2. 这时锁在 this 对象
    //3. 也可以在代码块上写 synchronized, 同步代码块,互斥锁还是在 this 对象
    private synchronized void sell() { //同步方法,在同一时刻,只能有一个线程来执行 sell方法
        synchronized (/*this*/ object) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            //休眠 50毫秒,模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName()
                    + " 售出一张票, 剩余票数 = " + (--ticketNum));
        }
    }

}
