package eventsourcing;

import java.util.UUID;

/**
 * Classe d�finissant l'�v�nement de d�marrage d'une inscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.2
 */
public class InscriptionStarted extends DistributionInscriptionEvent {
    
    public InscriptionStarted(UUID uuid) {
        super(uuid);
    }

    public InscriptionStarted() {
        this(UUID.randomUUID());
    }
    
}
