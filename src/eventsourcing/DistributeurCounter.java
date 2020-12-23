package eventsourcing;

import java.util.HashMap;

/**
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class DistributeurCounter implements IEventHandler {

    private final HashMap<DistributionInscriptionUuid, Long> counters = new HashMap<>();

    @Override
    public void handle(Event event) {
        Long counter;

        if (event instanceof DistributorRegistered) {
            counter = this.getCounters(event.getAggregateUuid());
//            System.out.println("counter:"+counter);
            counter++;
            counters.put(event.getAggregateUuid(), counter);
        } else if (event instanceof DistributorUnregistered) {
            counter = this.getCounters(event.getAggregateUuid());
            counter--;
            counters.put(event.getAggregateUuid(), counter);
        }       
    }

    public long getCounters(DistributionInscriptionUuid aggregateUuid) {
        return counters.getOrDefault(aggregateUuid, 0L);
    }

}
