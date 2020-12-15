package eventsourcing;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe définissant l'aggrégat DistributionInscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.1
 */
public class DistributionInscription {
    
    private UUID uuid;

    public DistributionInscription(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("DistributionInscription's uuid cannot be null");
        }
        
        this.uuid = uuid;
    }

    public DistributionInscription() {
        this(UUID.randomUUID());
    }

    public UUID getUuid() {
        return uuid;
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
    
    
}
