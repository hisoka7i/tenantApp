package com.demo.tenant.Scheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//This service is created which will send tenants, whatsapp message, when they have due date
public class ScheduledService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void startService() {
        // Schedule the task to run every 24 hours
        scheduler.scheduleAtFixedRate(this::executeTask, Long.valueOf(0), Long.valueOf(24), TimeUnit.HOURS);
    }

    private void executeTask() {
        // Implement the logic to be executed periodically
        System.out.println("Executing task...");
        // Your logic here...
    }

    public void stopService() {
        // Shutdown the scheduler when the service is no longer needed
        scheduler.shutdown();
    }
}
