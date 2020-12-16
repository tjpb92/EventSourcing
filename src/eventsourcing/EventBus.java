package eventsourcing;

import java.util.ArrayList;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.5
 */
public class EventBus {

    ArrayList<Event> events = new ArrayList<>();
    ArrayList<IEventHandler> readModels = new ArrayList<>();

    public EventBus(ArrayList<Event> events) {
        this.events = events;
    }

    public void publish(ArrayList<Event> events) {
        this.events.addAll(events);

        for (IEventHandler readModel : this.readModels) {
            for (Event event : this.events) {
                readModel.handle(event);
            }
        }
    }

    public void subscribe(IEventHandler readModel) {
        this.readModels.add(readModel);
    }

}
