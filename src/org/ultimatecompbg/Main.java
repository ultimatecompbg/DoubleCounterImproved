package org.ultimatecompbg;


import java.util.Scanner;

public class Main extends Thread {
    private int end;
    private int counter;
    private Object lock = new Object();

    public void setStart(int newStart){
        counter = newStart;
    }
    public void setEnd(int newEnd){
        end = newEnd;
    }
    public void count(){
        synchronized (lock){
            while(counter < end){
                try{

                    sleep(100);
                    counter++;
                    System.out.printf("%s : %s%n", Thread.currentThread().getName(), counter);
                    lock.notify();
                }
                catch(Exception e) {

                }
            }
        }
    }
    public static void main(String[] args){

        Main thread = new Main();
        Scanner firstStart = new Scanner(System.in);
        Scanner firstEnd = new Scanner(System.in);
        Scanner secondStart = new Scanner(System.in);
        Scanner secondEnd = new Scanner(System.in);
        thread.setStart(firstStart.nextInt());
        thread.setEnd(firstEnd.nextInt());
        Main thread2 = new Main();
        thread2.setStart(secondStart.nextInt());
        thread2.setEnd(secondEnd.nextInt());
        thread.start();
        thread2.start();

       /* while(true){
            if(!thread.isAlive()){
                thread2.interrupt();
                break;
            }else if(!thread2.isAlive()){
                thread.interrupt();
                break;
            }

        }*/

    }

    public void run() {
            count();
    }
}