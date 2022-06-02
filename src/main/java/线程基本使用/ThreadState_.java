package 线程基本使用;

public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {

        C c = new C();
        System.out.println(c.getName() + " 状态1: " + c.getState());
        c.start();
        while (Thread.State.TERMINATED != c.getState()) {
            System.out.println(c.getName() + " 状态2: " + c.getState());
            Thread.sleep(500);
        }
        System.out.println(c.getName() + " 状态3: " + c.getState());

    }
}

class C extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
