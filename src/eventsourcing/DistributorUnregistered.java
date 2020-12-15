package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant l'événement de désinscription d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.1
 */
public abstract class DistributorUnregistered extends DistributionInscriptionEvent {
    
    private Distributor distributor;

    public DistributorUnregistered(UUID uuid, Distributor distributor) {
        super(uuid);

        if (distributor == null) {
            throw new NullPointerException("Distributor cannot be null");
        }
        this.distributor = distributor;
    }

    public DistributorUnregistered(Distributor distributor) {
        this(UUID.randomUUID(), distributor);
    }

    public Distributor getDistributor() {
        return distributor;
    }
    
}
