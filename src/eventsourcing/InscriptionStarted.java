package eventsourcing;

import java.util.UUID;

/**
 * Classe d�finissant l'�v�nement de d�marrage d'une inscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.8
 */
public class InscriptionStarted extends DistributionInscriptionEvent {
    
    public InscriptionStarted(UUID uuid, long version) {
        super(uuid, version);
    }

    public InscriptionStarted(UUID uuid) {
        super(uuid, 0);
    }

    public InscriptionStarted() {
        this(UUID.randomUUID(), 0);
    }

    @Override
    public String toString() {
        return "InscriptionStarted{" + '}';
    }

}
