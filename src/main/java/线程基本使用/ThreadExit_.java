package 线程基本使用;

public class ThreadExit_ {
    public static void main(String[] args) {
        AThread st = new AThread();
        new Thread(st).start();
        for (int i = 1; i <= 60; i++) {
            try {
                Thread.sleep(50); //让main线程休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main线程 运行中 " + i);
            if (i == 30) {
                //中断 StopThread
                st.setLoop(false);
            }
        }
    }
}

class AThread implements Runnable {
    boolean loop = true; //步骤1: 定义标记变量,默认为true

    @Override
    public void run() {
        while (loop) { //步骤2: 将loop作为循环条件
            try {
                Thread.sleep(10); //让当前线程休眠10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AThread 运行中...");
        }
    }

    //步骤3: 提供公共的set方法,用于更新loop
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
