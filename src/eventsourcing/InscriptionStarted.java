package eventsourcing;

/**
 * Classe définissant l'événement de démarrage d'une inscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class InscriptionStarted extends Event {

    public InscriptionStarted(DistributionInscriptionUuid aggregateUuid, long version) {
        super(aggregateUuid, version);
    }

    public InscriptionStarted(DistributionInscriptionUuid aggregateUuid) {
        super(aggregateUuid, 0);
    }

    public InscriptionStarted() {
        this(DistributionInscriptionUuid.randomUUID(), 0);
    }

    @Override
    public String toString() {
        return "InscriptionStarted{"
                + "aggregateUuid:" + getAggregateUuid()
                + '}';
    }

}
