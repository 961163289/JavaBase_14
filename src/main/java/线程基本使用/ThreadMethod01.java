package 线程基本使用;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo01 td = new ThreadDemo01();
        td.setName("小笼包");
        td.setPriority(Thread.MIN_PRIORITY);
        td.start();
        //测试优先级
        System.out.println("默认优先级 = " + Thread.currentThread().getPriority());
        //测试 interrupt
        Thread.sleep(3000);
        td.interrupt();

    }
}

class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 吃包子~~~" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            //当该线程执行到一个 interrupt 方法时,就会 catch 一个 异常,可以加入自己的业务代码
            System.out.println(Thread.currentThread().getName() + " 被 interrupt 了");
        }
    }
}
