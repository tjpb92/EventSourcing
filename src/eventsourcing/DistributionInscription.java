package eventsourcing;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe définissant l'aggrégat DistributionInscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.3
 */
public class DistributionInscription {

    private UUID uuid;
    private ArrayList<DistributionInscriptionEvent> events;

    public DistributionInscription(UUID uuid, ArrayList<DistributionInscriptionEvent> events) {
        if (uuid == null) {
            throw new NullPointerException("DistributionInscription's uuid cannot be null");
        }

        this.uuid = uuid;
        this.events = events;
    }

    public DistributionInscription(UUID uuid) {
        this(uuid, new ArrayList<>());
    }

    public DistributionInscription() {
        this(UUID.randomUUID());
    }

    public UUID getUuid() {
        return uuid;
    }

    public InscriptionStarted startInscription(UUID uuid) {
        InscriptionStarted inscriptionStarted = new InscriptionStarted(uuid);
        events.add(inscriptionStarted);
        return inscriptionStarted;
    }

    public DistributorRegistered registerDistributor(UUID uuid, Distributor distributor) {
        DistributorRegistered distributorRegistered = new DistributorRegistered(uuid, distributor);
        events.add(distributorRegistered);
        return distributorRegistered;
    }

    public DistributorUnregistered unregisterDistributor(UUID uuid, Distributor distributor) {
        DistributorUnregistered distributorUnregistered = new DistributorUnregistered(uuid, distributor);
        events.add(distributorUnregistered);
        return distributorUnregistered;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DistributionInscription other = (DistributionInscription) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DistributionInscription{" + "uuid=" + uuid + ", events=" + events + '}';
    }
}
