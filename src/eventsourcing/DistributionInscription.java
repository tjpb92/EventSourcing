package eventsourcing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Classe définissant l'aggrégat DistributionInscription
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.12
 */
public class DistributionInscription {

    private DistributionInscriptionUuid aggregateUuid;
    private ArrayList<Event> events;

    public DistributionInscription(DistributionInscriptionUuid aggregateUuid, ArrayList<Event> events) {
        if (aggregateUuid == null) {
            throw new NullPointerException("DistributionInscription's uuid cannot be null");
        }

        this.aggregateUuid = aggregateUuid;
        this.events = events;
    }

    public DistributionInscription(DistributionInscriptionUuid aggregateUuid) {
        this(aggregateUuid, new ArrayList<>());
    }

    public DistributionInscription() {
        this(DistributionInscriptionUuid.randomUUID());
    }

    public DistributionInscriptionUuid getAggregateUuid() {
        return aggregateUuid;
    }

    public InscriptionStarted startInscription(DistributionInscriptionUuid aggregateUuid) {
        InscriptionStarted inscriptionStarted = null;
        List<Event> inscriptionStartedList = events
                .stream()
                .filter(InscriptionStarted.class::isInstance)
                .collect(Collectors.toList());

        if (inscriptionStartedList.isEmpty()) {
            inscriptionStarted = new InscriptionStarted(aggregateUuid);
            events.add(inscriptionStarted);
        }
        
        return inscriptionStarted;
    }

    public DistributorRegistered registerDistributor(DistributionInscriptionUuid aggregateUuiduuid, DistributorAbstract distributorAbstract) {
        DistributorRegistered distributorRegistered = null;
        int nbRegistered = 0;
        boolean started = false;
        
        for(Event event: events) {
            if (event instanceof InscriptionStarted) {
                started = true;
            }
            if (event instanceof DistributorRegistered) {
                DistributorRegistered dr = (DistributorRegistered) event;
                if (dr.getDistributorAbstract().equals(distributorAbstract)) nbRegistered++;
            }
            if (event instanceof DistributorUnregistered) {
                DistributorUnregistered du = (DistributorUnregistered) event;
                if (du.getDistributorAbstract().equals(distributorAbstract)) nbRegistered--;
            }
        }
        if (started && nbRegistered == 0) {
            distributorRegistered = new DistributorRegistered(aggregateUuiduuid, this.events.size(), distributorAbstract);
            events.add(distributorRegistered);
        }
         
        return distributorRegistered;
    }

    public DistributorUnregistered unregisterDistributor(DistributionInscriptionUuid aggregateUuiduuid, DistributorAbstract distributorAbstract) {
        DistributorUnregistered distributorUnregistered = null;
        int nbRegistered = 0;
        boolean started = false;

        for(Event event: events) {
            if (event instanceof InscriptionStarted) {
                started = true;
            }
            if (event instanceof DistributorRegistered) {
                DistributorRegistered dr = (DistributorRegistered) event;
                if (dr.getDistributorAbstract().equals(distributorAbstract)) nbRegistered++;
            }
            if (event instanceof DistributorUnregistered) {
                DistributorUnregistered du = (DistributorUnregistered) event;
                if (du.getDistributorAbstract().equals(distributorAbstract)) nbRegistered--;
            }
        }
        if (started && nbRegistered == 0) {
            distributorUnregistered = new DistributorUnregistered(aggregateUuiduuid, this.events.size(), distributorAbstract);
            events.add(distributorUnregistered);
        }
        
        return distributorUnregistered;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.aggregateUuid);
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
        if (!Objects.equals(this.aggregateUuid, other.aggregateUuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DistributionInscription{" + "aggregateUuid=" + aggregateUuid + ", events=" + events + '}';
    }
}
