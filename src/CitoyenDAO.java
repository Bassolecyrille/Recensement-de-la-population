

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CitoyenDAO {
    private Connection connection;

    public CitoyenDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter un citoyen
    public void ajouterCitoyen(Citoyen citoyen) throws SQLException {
        String query = "INSERT INTO citoyens (nom, profession, adresse, etatCivil) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, citoyen.getNom());
            statement.setString(2, citoyen.getProfession());
            statement.setString(3, citoyen.getAdresse());
            statement.setString(4, citoyen.getEtatCivil());
            statement.executeUpdate();
            System.out.println("Citoyen ajouté avec succès : " + citoyen.getNom());
        }
    }

    // Méthode pour récupérer tous les citoyens
    public List<Citoyen> listerCitoyens() throws SQLException {
        List<Citoyen> citoyens = new ArrayList<>();
        String query = "SELECT * FROM citoyens";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Citoyen citoyen = new Citoyen();
                citoyen.setId(resultSet.getInt("id"));
                citoyen.setNom(resultSet.getString("nom"));
                citoyen.setProfession(resultSet.getString("profession"));
                citoyen.setAdresse(resultSet.getString("adresse"));
                citoyen.setEtatCivil(resultSet.getString("etatCivil"));
                citoyens.add(citoyen);
            }
        }
        return citoyens;
    }

    // Méthode pour modifier un citoyen
    public void modifierCitoyen(int id, Citoyen citoyen) throws SQLException {
        String query = "UPDATE citoyens SET nom = ?, profession = ?, adresse = ?, etatCivil = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, citoyen.getNom());
            statement.setString(2, citoyen.getProfession());
            statement.setString(3, citoyen.getAdresse());
            statement.setString(4, citoyen.getEtatCivil());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println("Citoyen modifié avec succès : " + citoyen.getNom());
        }
    }

    // Méthode pour supprimer un citoyen
    public void supprimerCitoyen(int id) throws SQLException {
        String query = "DELETE FROM citoyens WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Citoyen supprimé avec succès : ID " + id);
        }
    }

    // Méthode pour rechercher un citoyen par nom
    public Citoyen rechercherCitoyenParNom(String nom) throws SQLException {
        String query = "SELECT * FROM citoyens WHERE nom = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nom);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Citoyen citoyen = new Citoyen();
                    citoyen.setId(resultSet.getInt("id"));
                    citoyen.setNom(resultSet.getString("nom"));
                    citoyen.setProfession(resultSet.getString("profession"));
                    citoyen.setAdresse(resultSet.getString("adresse"));
                    citoyen.setEtatCivil(resultSet.getString("etatCivil"));
                    return citoyen;
                } else {
                    System.out.println("Aucun citoyen trouvé avec le nom : " + nom);
                    return null;
                }
            }
        }
    }
}

