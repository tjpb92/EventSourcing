package eventsourcing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Classe définissant l'aggrégat DistributionInscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.4
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
        InscriptionStarted inscriptionStarted = null;
        List<DistributionInscriptionEvent> inscriptionStartedList = events
                .stream()
                .filter(InscriptionStarted.class::isInstance)
                .collect(Collectors.toList());

        if (inscriptionStartedList.isEmpty()) {
            inscriptionStarted = new InscriptionStarted(uuid);
            events.add(inscriptionStarted);
        }
        
        return inscriptionStarted;
    }

    public DistributorRegistered registerDistributor(UUID uuid, Distributor distributor) {
        DistributorRegistered distributorRegistered = null;
        int nbRegistered = 0;
        boolean started = false;
        
        for(Event event: events) {
            if (event instanceof InscriptionStarted) {
                started = true;
            }
            if (event instanceof DistributorRegistered) {
                DistributorRegistered dr = (DistributorRegistered) event;
                if (dr.getDistributor().equals(distributor)) nbRegistered++;
            }
            if (event instanceof DistributorUnregistered) {
                DistributorUnregistered du = (DistributorUnregistered) event;
                if (du.getDistributor().equals(distributor)) nbRegistered--;
            }
        }
        if (started && nbRegistered == 0) {
            distributorRegistered = new DistributorRegistered(uuid, distributor);
            events.add(distributorRegistered);
        }
         
        return distributorRegistered;
    }

    public DistributorUnregistered unregisterDistributor(UUID uuid, Distributor distributor) {
        DistributorUnregistered distributorUnregistered = null;
        int nbRegistered = 0;
        boolean started = false;

        for(Event event: events) {
            if (event instanceof InscriptionStarted) {
                started = true;
            }
            if (event instanceof DistributorRegistered) {
                DistributorRegistered dr = (DistributorRegistered) event;
                if (dr.getDistributor().equals(distributor)) nbRegistered++;
            }
            if (event instanceof DistributorUnregistered) {
                DistributorUnregistered du = (DistributorUnregistered) event;
                if (du.getDistributor().equals(distributor)) nbRegistered--;
            }
        }
        if (started && nbRegistered == 0) {
            distributorUnregistered = new DistributorUnregistered(uuid, distributor);
            events.add(distributorUnregistered);
        }
        
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
