# Formation Impl�menter DDD avec CQRS / Event Sourcing

Contenu des exercices de la formation "Impl�menter DDD avec CQRS / Event Sourcing" du 14 au 17 d�cembre 2020


## Premier jour de la formation : 14/12/2020

Ajouter ici les photos ...

## Second jour de la formation : 15/12/2020

### Agr�gat de suivi des inscriptions

L'agr�gat `DistributionInscription` servira � suivre les inscriptions et les d�sinscriptions.

On pr�voira les cas suivants :

- D�marrage des inscriptions,
- Abonnement d'un distributeur,
- D�sabonnement d'un distributeur.

## Troisi�me jour de la formation : 16/12/2020

### Projections `DistributeurCounter` et `DistributeurNameList`

On r�alise deux projections pour  : 

- `DistributeurCounter` : compter les distributeurs enregistr�s,
- `DistributeurNameList` : lister les distributeurs enregistr�s.

#### Projection `DistributeurCounter`

- Quand le handler re�oit un �v�nement `DistributorRegistered`, un compteur est incr�ment� d'une unit�,
- Quand le hanlder re�oit un �v�nement `DistributorUnregistered`, un compteur est d�cr�ment� d'une unit�.

ATTENTION : on prendra soin d'avoir un compteur par agr�gat.

#### Projection `DistributeurNameList`

- Quand le handler re�oit un �v�nement `DistributorRegistered`, une liste re�oit le nom du distributeur concern�,
- Quand le hanlder re�oit un �v�nement `DistributorUnregistered`, le nom du distributeur concern� est retir� d'une liste.

ATTENTION : on prendra soin d'avoir une liste par agr�gat.

### Publisher / Subscriber

Le publisher doit :

- enregistrer les �v�nements lorsqu'ils sont publi�s,
- appeler les handlers ad�quats pour chaque �v�nement,
- doit afficher les projections lorsqu'une commande est invoqu�e.

## Quatri�me jour de la formation : 17/12/2020

- Impl�mentation d'une r�pr�sention de l'EventStore
- Contr�le du versionning des �v�nements

## R�f�rences:

- [Impl�menter DDD avec CQRS / Event Sourcing](https://formation.hackyourjob.com/catalogue/ddd-cqrs-eventsourcing.html)
