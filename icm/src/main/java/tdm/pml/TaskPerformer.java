package tdm.pml;

/**
 * Interface that holds a method perform task which is used by the time manager class
 * The perform task method is used by the time manager class which executes the method every x seconds
 */
public interface TaskPerformer {
    public void performTask();
}
