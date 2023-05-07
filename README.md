# 📝 Notes are so important


## Associations entre entités :
### One to One (1:1) - Unidirectionnelle
- Class have access: @OneToOne
- Class have no access: nothing
### One to One (1:1) - Bidirectionnelle
- Class 1: @OneToOne 
- Class 2: @OneToOne
- Chose one and add @MappedBy
### One to Many (1:N) - Unidirectionnelle
- Class have access (1): @OneToMany
- Class have no access (N): nothing
### One to Many (1:N) - Bidirectionnelle
- Class have access (1): @OneToMany + List + @MappedBy
- Class have access (N): @ManyToOne
### Many to One (N:1) - Unidirectionnelle
- Class have access (N): @ManyToOne
- Class have no access (1): nothing
### Many to One (N:1) - Bidirectionnelle
- Class have access (N): @ManyToOne
- Class have access (1): @OneToMany + List + @MappedBy
### Many to Many (N:M) - Unidirectionnelle
- Class have access (N): @ManyToMany + List
- Class have no access (N): nothing
### Many to Many (N:M) - Bidirectionnelle
- Class have access (N): @ManyToMany + List
- Class have access (N): @ManyToMany + List
- Chose one and add @MappedBy
## Annotations
- **@JsonIgnore:** permet d’ignorer une propriété ou une liste de propriétés dans l’objet JSON.
- La signification de CascadeType.ALL est que la persistance propagera (cascade) toutes les opérations EntityManager (PERSIST, REMOVE, REFRESH, MERGE, DETACH) aux entités associées. (LIST)


## Keywords
- Afficher la liste des projets qui ont une technologie précise.
```java
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
List<Projet> findByProjetDetailTechnologieContains(String technologie);
}
```
- Afficher la liste des projets d’une équipe.
```java
@Repository
public interface ProjetRepository
        extends JpaRepository<Projet, Long> {
    List<Projet> findByEquipesIdEquipe(Long equipeId);
}
```

- Afficher la liste des projets d’une équipe dont la description est non nulle.
```java
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
List<Projet>
findByEquipesIdEquipeAndProjetDetailDescriptionNotNull(Long equipeId);
}
```

- Afficher la liste des projets par équipe et entreprise.
```java
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findByEquipesIdEquipeAndEquipesEntrepriseIdEntreprise(Long equipeId, Long entrepriseId);
}
```

- Afficher la liste des projets par la spécialité d’une équipe et l’adresse de
l’entreprise.

```java
@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet>
    findByEquipesSpecialiteContainsAndEquipesEntrepriseAdresseContains(String specialite, String adresse);
}
```

## JPQL
- exemple 1: Ces méthodes permettent de récupérer les entreprises avec une adresse donnée
```SQL
@Query("SELECT e FROM Entreprise e WHERE e.adresse =:adresse")
List<Entreprise> retrieveEntreprisesByAdresse(@Param("adresse") String adresse);
```

Si nous souhaitons faire un UPDATE, DELETE et INSERT, nous devons ajouter
l’annotaion @Modifying pour activer la modification de la base de données.

- exemple 2: Cette méthode permet de mettre à jour l’adresse de l’entreprise.
```SQL
@Modifying
@Query("update Entreprise e set e.adresse = :adresse where e.idEntreprise =
:idEntreprise")
int updateEntrepriseByAdresse(@Param("adresse") String adresse,
@Param("idEntreprise")
Long idEntreprise);
```


## URL
[OpenAPI](http://localhost:8089/app/swagger-ui/index.html)