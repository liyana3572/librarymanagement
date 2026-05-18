package services;

public class NotificationService extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("📢 Reminder: Return borrowed books on time!");
            try {
                Thread.sleep(5000); // every 5 seconds
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
