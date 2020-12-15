package eventsourcing;

import java.util.UUID;

/**
 * Classe définissant un événement générique
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.1
 */
public abstract class Event {
    
    private UUID uuid;
    
    // TODO
    // private UUID aggregateUuid;

    public Event(UUID uuid) {
        if (uuid == null) {
            throw new NullPointerException("Events's uuid cannot be null");
        }
        
        this.uuid = uuid;
    }

    public Event() {
        this(UUID.randomUUID());
    }

    public UUID getUuid() {
        return uuid;
    }
}
