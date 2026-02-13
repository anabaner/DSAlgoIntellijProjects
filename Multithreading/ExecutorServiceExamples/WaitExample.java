package ExecutorServiceExamples;

public class WaitExample extends Thread {

    public static void main(String[] args) throws InterruptedException {
        GunFight gfi = new GunFight();

        new Thread() {
            @Override public void run() { gfi.fire(60); }
        }.start();

        new Thread() {
            @Override public void run() { gfi.reload(); }
        }.start();
    }
}

    class GunFight {
        int bullets= 40;
        public synchronized void fire(int bulletstoFire) {
            for(int i = 1;i<=bulletstoFire;i++){
            if(bullets == 0) {
                System.out.println(i - 1
                        + " bullets fired and "
                        + bullets + " remains");
                System.out.println(
                        "Invoking the wait() method");


                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.fillInStackTrace());
                }
                System.out.println(
                        "Continuing firing");
            }
            bullets --;
        }
            System.out.println(
                    "The firing process is complete");
        }

        public synchronized void reload() {
            System.out.println(
                    "Reloading the magazine and resuming "
                            + "the thread using notify()");
            bullets+=40;
            notify();
        }


}
