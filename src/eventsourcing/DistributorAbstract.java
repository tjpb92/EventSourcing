package eventsourcing;

import java.util.Objects;

/**
 * Informations résumée d'un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.7
 */
public class DistributorAbstract {

    private final Distributor distributor;

    public DistributorAbstract(Distributor distributor) {
        this.distributor = distributor;
    }

    public DistributorUuid getUuid() {
        return this.distributor.getUuid();
    }

    public String getName() {
        return this.distributor.getName();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.distributor);
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
        final DistributorAbstract other = (DistributorAbstract) obj;
        if (!Objects.equals(this.distributor, other.distributor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DistributorAbstract:{"
                + "uuid:" + getUuid()
                + ", name:" + getName()
                + '}';
    }
}
