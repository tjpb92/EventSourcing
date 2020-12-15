package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant un événement générique de l'agrégat
 * DistributionInscription.
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.1
 */
public abstract class DistributionInscriptionEvent extends Event {

    public DistributionInscriptionEvent(UUID uuid) {
        super(uuid);
    }

    public DistributionInscriptionEvent() {
        super();
    }
}
