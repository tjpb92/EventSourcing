package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant l'événement de désinscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.9
 */
public class DistributorUnregistered extends Event {
    
    private DistributorAbstract distributorAbstract;

    public DistributorUnregistered(UUID uuid, long version, DistributorAbstract distributorAbstract) {
        super(uuid, version);

        if (distributorAbstract == null) {
            throw new NullPointerException("Distributor abstract cannot be null");
        }
        this.distributorAbstract = distributorAbstract;
    }

    public DistributorUnregistered(long version, DistributorAbstract distributor) {
        this(UUID.randomUUID(), version, distributor);
    }

    public DistributorAbstract getDistributorAbstract() {
        return distributorAbstract;
    }

    @Override
    public String toString() {
        return "DistributorUnregistered:{"
                + "aggregateUuid:" + getAggregateUuid()
                + ", " + distributorAbstract
                + '}';
    }
    
}
