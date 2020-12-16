package eventsourcing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.5
 */
public class DistributeurNameList implements IEventHandler {

    private HashMap<UUID, ArrayList<String>> nameList = new HashMap<>();

    public void handle(Event event) {
        ArrayList<String> names;

        if (event instanceof DistributorRegistered) {
            names = this.getNames(event.getUuid());
            names.add(((DistributorRegistered)event).getDistributor().getName());
            nameList.put(event.getUuid(), names);
        } else if (event instanceof DistributorUnregistered) {
            names = this.getNames(event.getUuid());
            names.remove(((DistributorUnregistered)event).getDistributor().getName());
            nameList.put(event.getUuid(), names);
        }
        
    }

    public ArrayList<String> getNames(UUID uuid) {
        return nameList.getOrDefault(uuid, new ArrayList<String>());
    }

}
