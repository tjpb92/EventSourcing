package eventsourcing;

/**
 * Classe définissant l'événement d'inscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class DistributorRegistered extends Event {

    private DistributorAbstract distributorAbstract;

    public DistributorRegistered(DistributionInscriptionUuid aggregateUuid, long version, DistributorAbstract distributorAbstract) {
        super(aggregateUuid, version);

        if (distributorAbstract == null) {
            throw new NullPointerException("Distributor abstract cannot be null");
        }
        this.distributorAbstract = distributorAbstract;
    }

    public DistributorRegistered(long version, DistributorAbstract distributorAbstract) {
        this(DistributionInscriptionUuid.randomUUID(), version, distributorAbstract);
    }

    public DistributorAbstract getDistributorAbstract() {
        return distributorAbstract;
    }

    @Override
    public String toString() {
        return "DistributorRegistered:{"
                + "aggregateUuid:" + getAggregateUuid()
                + ", " + distributorAbstract
                + '}';
    }

}
