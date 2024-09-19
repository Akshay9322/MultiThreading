
// Using Atomic classes we can avoid race condition without explictly locking 
// Synchronized key work is use when to eliminate race condition using locking mechanism

public class RaceCondition {

    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return this.count;
    }
    public static void main(String[] args){
         RaceCondition raceCondition = new RaceCondition();
      Thread akshay =   new Thread(() -> {
            System.out.println("Thread Akshay started");
            // System.out.println(Thread.currentThread().getName());
             int i = 0;
             while(i < 500){
               raceCondition.increment();
               i++;
             }
             System.out.println("Thread Akshay completed");

        }, "Akshay");

       Thread akash = new Thread(() -> {
            System.out.println("Thread Akash started");
           // System.out.println(Thread.currentThread().getName());
            int i = 0;
            while(i < 500){
              raceCondition.increment();
              i++;
            }

            System.out.println("Thread Akash completed");
       }, "Akash");

       akshay.start();
       akash.start();

       try{
       akshay.join();
       akash.join();
       }catch(InterruptedException e){
        e.printStackTrace();
       }

       System.out.println("Value of count: "+raceCondition.getCount());
    }
}
