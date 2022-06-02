package 线程基本使用;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {

        MyDaemonThread dt = new MyDaemonThread();
        //将dt设置为守护线程,当所有线程结束后,dt就自动结束
        //如果没有设置,那么 即使main线程执行完毕, dt也不退出,可以体验一下
        dt.setDaemon(true);
        dt.start();
        for (int i = 1; i <= 100; i++) {
            Thread.sleep(50);
            System.out.println("宝强辛苦工作-----------" + i);
        }

    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天, 哈哈哈~~~");
        }
    }
}
