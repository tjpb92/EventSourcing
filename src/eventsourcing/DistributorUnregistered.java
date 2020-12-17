package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant l'événement de désinscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.7
 */
public class DistributorUnregistered extends DistributionInscriptionEvent {
    
    private DistributorAbstract distributorAbstract;

    public DistributorUnregistered(UUID uuid, DistributorAbstract distributorAbstract) {
        super(uuid);

        if (distributorAbstract == null) {
            throw new NullPointerException("Distributor abstract cannot be null");
        }
        this.distributorAbstract = distributorAbstract;
    }

    public DistributorUnregistered(DistributorAbstract distributor) {
        this(UUID.randomUUID(), distributor);
    }

    public DistributorAbstract getDistributorAbstract() {
        return distributorAbstract;
    }

    @Override
    public String toString() {
        return "DistributorUnregistered:{"
                + "uuid:" + getUuid()
                + ", " + distributorAbstract
                + '}';
    }
    
}
