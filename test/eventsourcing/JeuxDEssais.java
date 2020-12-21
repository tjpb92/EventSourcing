package eventsourcing;

import java.util.UUID;

/**
 * Constantes pour les jeux d'essais
 *
 * @author Thierry Baribaud
 * @version 0.1.10
 */
public class JeuxDEssais {

    public static final DistributorUuid DISTRIBUTOR_UUID = new DistributorUuid();
    public static final UUID AGGREGATE_UUID = UUID.randomUUID();
    public static final UUID AGGREGATE_UUID2 = UUID.randomUUID();
    public static final String NAME = "totolito";
    public static final String EMAIL = NAME + "@mail.com";
    public static final Distributor DISTRIBUTOR = new Distributor(NAME, EMAIL);

}
