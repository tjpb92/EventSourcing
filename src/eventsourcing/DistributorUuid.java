package eventsourcing;

import java.util.UUID;

/**
 * Classe pour l'identifiant unique d'un distributeur.
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.6
 */
public final class DistributorUuid {

    UUID uuid;

    public DistributorUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public DistributorUuid() {
        this(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return uuid.toString();
    }
}
