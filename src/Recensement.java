import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recensement {
    private List<Citoyen> citoyens;
    private List<Famille> familles;
    private List<ZoneGeographique> zonesGeographiques;

    // Constructeur
    public Recensement() {
        this.citoyens = new ArrayList<>();
        this.familles = new ArrayList<>();
        this.zonesGeographiques = new ArrayList<>();
    }

    // Gestion des Citoyens
    public void ajouterCitoyen(Citoyen citoyen) {
        citoyens.add(citoyen);
        System.out.println("Citoyen ajouté : " + citoyen.getNom());
    }

    public void modifierCitoyen(int id, Citoyen citoyenModifie) {
        for (int i = 0; i < citoyens.size(); i++) {
            if (citoyens.get(i).getId() == id) {
                citoyens.set(i, citoyenModifie);
                System.out.println("Citoyen modifié : " + citoyenModifie.getNom());
                return;
            }
        }
        System.out.println("Citoyen avec ID " + id + " non trouvé.");
    }

    public void supprimerCitoyen(int id) {
        citoyens.removeIf(citoyen -> citoyen.getId() == id);
        System.out.println("Citoyen supprimé avec ID : " + id);
    }

    public Citoyen rechercherCitoyenParNom(String nom) {
        for (Citoyen citoyen : citoyens) {
            if (citoyen.getNom().equalsIgnoreCase(nom)) {
                return citoyen;
            }
        }
        System.out.println("Citoyen avec nom " + nom + " non trouvé.");
        return null;
    }

    public List<Citoyen> filtrerParProfession(String profession) {
        return citoyens.stream()
                .filter(c -> c.getProfession().equalsIgnoreCase(profession))
                .collect(Collectors.toList());
    }

    public List<Citoyen> citoyensParZone(ZoneGeographique zone) {
        return citoyens.stream()
                .filter(c -> c.getAdresse().equals(zone.getNom()))
                .collect(Collectors.toList());
    }

    public void validerCitoyen(Citoyen citoyen) throws Exception {
        if (citoyen.getNom() == null || citoyen.getNom().isEmpty()) {
            throw new Exception("Le nom du citoyen est obligatoire.");
        }
        // Ajouter d'autres validations ici
    }


    // Gestion des Familles
    public void ajouterFamille(Famille famille) {
        familles.add(famille);
        System.out.println("Famille ajoutée : " + famille.getNomFamille());
    }

    public void modifierFamille(int id, Famille familleModifiee) {
        for (int i = 0; i < familles.size(); i++) {
            if (familles.get(i).getId() == id) {
                familles.set(i, familleModifiee);
                System.out.println("Famille modifiée : " + familleModifiee.getNomFamille());
                return;
            }
        }
        System.out.println("Famille avec ID " + id + " non trouvée.");
    }

    public void supprimerFamille(int id) {
        familles.removeIf(famille -> famille.getId() == id);
        System.out.println("Famille supprimée avec ID : " + id);
    }

    // Gestion des Zones Géographiques
    public void ajouterZoneGeographique(ZoneGeographique zone) {
        zonesGeographiques.add(zone);
        System.out.println("Zone ajoutée : " + zone.getNom());
    }

    public void modifierZoneGeographique(int id, ZoneGeographique zoneModifiee) {
        for (int i = 0; i < zonesGeographiques.size(); i++) {
            if (zonesGeographiques.get(i).getId() == id) {
                zonesGeographiques.set(i, zoneModifiee);
                System.out.println("Zone modifiée : " + zoneModifiee.getNom());
                return;
            }
        }
        System.out.println("Zone avec ID " + id + " non trouvée.");
    }

    public void supprimerZoneGeographique(int id) {
        zonesGeographiques.removeIf(zone -> zone.getId() == id);
        System.out.println("Zone supprimée avec ID : " + id);
    }
}
