
public class Citoyen extends Personne {
    private int id;  // Identifiant unique
    private String profession;
    private String etatCivil;
    private String adresse;

    // Constructeur
    public Citoyen(int id, String nom, int age, String sexe, String profession, String etatCivil, String adresse) {
        super(nom, age, sexe);  // Appel du constructeur de Personne
        this.id = id;
        this.profession = profession;
        this.etatCivil = etatCivil;
        this.adresse = adresse;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Méthode d'affichage
    @Override
    public String toString() {
        return "Citoyen{" +
                "id=" + id +
                ", nom=" + getNom() +
                ", age=" + getAge() +
                ", sexe=" + getSexe() +
                ", profession='" + profession + '\'' +
                ", etatCivil='" + etatCivil + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
