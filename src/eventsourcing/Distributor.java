package eventsourcing;

import java.util.Objects;

/**
 * Classe décrivant un distributeur
 *
 * @author Thierry Baribaud
 * @author Anthony Guerot
 * @version 0.1.6
 *
 */
public class Distributor {

    private DistributorUuid uuid;
    private String name;
    private String email;

    public Distributor(DistributorUuid uuid, String name, String email) {

        if (uuid == null) {
            throw new NullPointerException("Distributor's uuid cannot be null");
        }
//        if (uuid.isEmpty()) throw new IllegalArgumentException("Distributor's uuid cannot be empty");

        if (name == null) {
            throw new NullPointerException("Distributor's name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Distributor's name cannot be empty");
        }

        if (email == null) {
            throw new NullPointerException("Distributor's email cannot be null");
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Distributor's email cannot be empty");
        }

        this.uuid = uuid;
        this.name = name;
        this.email = email;
    }

    public Distributor(String name, String email) {
        this(new DistributorUuid(), name, email);
    }

    public DistributorUuid getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Distributor{" + "uuid=" + uuid + ", name=" + name + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.uuid);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.email);
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
        final Distributor other = (Distributor) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}
