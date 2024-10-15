

public class ZoneGeographique {
    private int id;
    private String nom;
    private int nombreHabitants;

    // Constructeur
    public ZoneGeographique(int id, String nom, int nombreHabitants) {
        this.id = id;
        this.nom = nom;
        this.nombreHabitants = nombreHabitants;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreHabitants() {
        return nombreHabitants;
    }

    public void setNombreHabitants(int nombreHabitants) {
        this.nombreHabitants = nombreHabitants;
    }

    // Méthode d'affichage
    @Override
    public String toString() {
        return "ZoneGeographique{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nombreHabitants=" + nombreHabitants +
                '}';
    }
}
