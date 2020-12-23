package eventsourcing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Projection donnant les noms des distributeurs inscrits
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class DistributeurNameList implements IEventHandler {

    private final HashMap<DistributionInscriptionUuid, ArrayList<String>> nameList = new HashMap<>();

    @Override
    public void handle(Event event) {
        ArrayList<String> names;

        if (event instanceof DistributorRegistered) {
            names = this.getNames(event.getAggregateUuid());
            names.add(((DistributorRegistered)event).getDistributorAbstract().getName());
            nameList.put(event.getAggregateUuid(), names);
        } else if (event instanceof DistributorUnregistered) {
            names = this.getNames(event.getAggregateUuid());
            names.remove(((DistributorUnregistered)event).getDistributorAbstract().getName());
            nameList.put(event.getAggregateUuid(), names);
        }        
    }

    public ArrayList<String> getNames(DistributionInscriptionUuid aggregateUuid) {
        return nameList.getOrDefault(aggregateUuid, new ArrayList<>());
    }

}
