package eventsourcing;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.5
 */
public interface IEventHandler {
    
    public void handle(Event event);
    
}
