package 线程基本使用;

public class SellTicket {
    public static void main(String[] args) {

//        System.out.println("===使用继承Thread类方式来售票===");
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里会出现超卖
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        System.out.println("===使用实现Runnable接口方式来售票===");
        SellTicket02 sellTicket04 = new SellTicket02();

        new Thread(sellTicket04).start(); //第1个线程-窗口
        new Thread(sellTicket04).start(); //第2个线程-窗口
        new Thread(sellTicket04).start(); //第3个线程-窗口

    }
}

//继承 Thread 方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100; //让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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

//实现 Runnable 接口方式
class SellTicket02 implements Runnable {
    private static int ticketNum = 100; //让多个线程共享 ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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
