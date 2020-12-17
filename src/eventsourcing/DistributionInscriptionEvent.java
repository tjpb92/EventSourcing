package eventsourcing;

import java.util.UUID;

/**
 * Classe d�finissant un �v�nement g�n�rique de l'agr�gat
 * DistributionInscription.
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.8
 */
public abstract class DistributionInscriptionEvent extends Event {

    public DistributionInscriptionEvent(UUID uuid, long version) {
        super(uuid, version);
    }

    public DistributionInscriptionEvent() {
        super();
    }
}
