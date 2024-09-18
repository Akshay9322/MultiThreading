public class ThreadCreation{

    public static volatile int a = 10;

    public synchronized void updateA(){
        ThreadCreation.a = ThreadCreation.a + 5;
    }

    public synchronized int getA(){
        return ThreadCreation.a;
    }

    public static void main(String[] args) {

        ThreadCreation threadCreation = new ThreadCreation();
        
        Runnable runnable1 = () -> {
            System.out.println(Thread.currentThread().getName());
            try{
            Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            threadCreation.updateA();
        };
        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Value of a: "+threadCreation.getA());
        };
        
        Thread thread1 = new Thread(runnable1, "Akshay");
        Thread thread2 = new Thread(runnable2, "Akash");

        thread1.start();
         // Wait for thread1 to finish before starting thread2
         try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        

    }
}