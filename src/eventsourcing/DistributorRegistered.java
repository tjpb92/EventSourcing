package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant l'événement d'inscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.7
 */
public class DistributorRegistered extends DistributionInscriptionEvent {

    private DistributorAbstract distributorAbstract;

    public DistributorRegistered(UUID uuid, DistributorAbstract distributorAbstract) {
        super(uuid);

        if (distributorAbstract == null) {
            throw new NullPointerException("Distributor abstract cannot be null");
        }
        this.distributorAbstract = distributorAbstract;
    }

    public DistributorRegistered(DistributorAbstract distributorAbstract) {
        this(UUID.randomUUID(), distributorAbstract);
    }

    public DistributorAbstract getDistributorAbstract() {
        return distributorAbstract;
    }

    @Override
    public String toString() {
        return "DistributorRegistered:{"
                + "uuid:" + getUuid()
                + ", " + distributorAbstract
                + '}';
    }

}
