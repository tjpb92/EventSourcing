package eventsourcing;

/**
 * Constantes pour les jeux d'essais
 *
 * @author Thierry Baribaud
 * @version 0.1.12
 */
public class JeuxDEssais {

    public static final DistributorUuid DISTRIBUTOR_UUID = new DistributorUuid();
    public static final DistributionInscriptionUuid AGGREGATE_UUID = DistributionInscriptionUuid.randomUUID();
    public static final DistributionInscriptionUuid AGGREGATE_UUID2 = DistributionInscriptionUuid.randomUUID();
    public static final String NAME = "totolito";
    public static final String EMAIL = NAME + "@mail.com";
    public static final Distributor DISTRIBUTOR = new Distributor(NAME, EMAIL);

}
