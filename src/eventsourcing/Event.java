package eventsourcing;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe définissant un événement générique
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.2
 */
public abstract class Event {
    
    private UUID uuid;
    private long version;
    
    // TODO
    // private UUID aggregateUuid;

    public Event(UUID uuid, long version) {
        if (uuid == null) {
            throw new NullPointerException("Events's uuid cannot be null");
        }
        
        this.uuid = uuid;
        this.version = version;
    }

    public Event() {
        this(UUID.randomUUID(), 0);
    }

    public UUID getUuid() {
        return uuid;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.uuid);
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        return true;
    }
    
}
