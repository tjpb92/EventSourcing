package eventsourcing;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe pour l'identifiant unique de l'agrégat DistributionInscription.
 * 
 * TODO : Implémenter Serializable et Comparable
 *
 * @author Thierry Baribaud
 * @version 0.1.11
 */
public final class DistributionInscriptionUuid {
    
    UUID uuid;
    
    public DistributionInscriptionUuid(UUID uuid) {
        this.uuid = uuid;
    }
    
    public DistributionInscriptionUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }
    
    public DistributionInscriptionUuid() {
        this(UUID.randomUUID());
    }
    
    public static DistributionInscriptionUuid fromString(String uuid) {
        return new DistributionInscriptionUuid(uuid);
    }
    
    public static DistributionInscriptionUuid randomUUID() {
        return new DistributionInscriptionUuid();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.uuid);
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
        final DistributionInscriptionUuid other = (DistributionInscriptionUuid) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return uuid.toString();
    }
}
