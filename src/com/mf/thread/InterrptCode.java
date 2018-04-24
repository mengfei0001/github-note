package com.mf.thread;

/**
 * 线程基础：中断
 *
 *
 */
public class InterrptCode {
    public static void main(String args[]) throws InterruptedException {
        interrpt();
    }

    private static void interrpt() throws InterruptedException {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.err.println("Thread.currentThread().isInterrupted() ......");
                        break;
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
