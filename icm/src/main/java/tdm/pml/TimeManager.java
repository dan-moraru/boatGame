package tdm.pml;
import java.util.Timer;
import java.util.TimerTask;

public class TimeManager {
    private Timer timer;
    private TaskPerformer taskPerformer; 
    private int delay;

    /**
     * 
     * @param taskPerformer
     * @param delay
     */
    public TimeManager(TaskPerformer taskPerformer, int delay){
        this.taskPerformer = taskPerformer;
        this.timer = new Timer();
        this.delay = delay;
    }

    /**
     * Starts the timer and performs the task every x seconds
     */
    public void startTimer() {
        TimerTask task = new TimerTask() {
            public void run() {
                taskPerformer.performTask();
            }
        };
        this.timer.schedule(task, this.delay, this.delay);
    }

    /**
     * Stops the timer
     */
    public void stopTimer() {
        this.timer.cancel();
    }
}
