package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant l'événement d'inscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.1
 */
public abstract class DistributorRegistered extends DistributionInscriptionEvent {
    
    private Distributor distributor;

    public DistributorRegistered(UUID uuid, Distributor distributor) {
        super(uuid);

        if (distributor == null) {
            throw new NullPointerException("Distributor cannot be null");
        }
        this.distributor = distributor;
    }

    public DistributorRegistered(Distributor distributor) {
        this(UUID.randomUUID(), distributor);
    }

    public Distributor getDistributor() {
        return distributor;
    }
    
}
