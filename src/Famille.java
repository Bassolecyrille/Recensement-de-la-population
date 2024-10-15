

public class Famille {
    private int id;
    private String nomFamille;
    private int nombreMembres;
    private Citoyen chefFamille;

    // Constructeur
    public Famille(int id, String nomFamille, int nombreMembres, Citoyen chefFamille) {
        this.id = id;
        this.nomFamille = nomFamille;
        this.nombreMembres = nombreMembres;
        this.chefFamille = chefFamille;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public int getNombreMembres() {
        return nombreMembres;
    }

    public void setNombreMembres(int nombreMembres) {
        this.nombreMembres = nombreMembres;
    }

    public Citoyen getChefFamille() {
        return chefFamille;
    }

    public void setChefFamille(Citoyen chefFamille) {
        this.chefFamille = chefFamille;
    }

    // Méthode d'affichage
    @Override
    public String toString() {
        return "Famille{" +
                "id=" + id +
                ", nomFamille='" + nomFamille + '\'' +
                ", nombreMembres=" + nombreMembres +
                ", chefFamille=" + chefFamille +
                '}';
    }
}
