import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FamilleDAO {
    private Connection connection;

    public FamilleDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter une famille
    public void ajouterFamille(Famille famille) throws SQLException {
        String query = "INSERT INTO familles (nomFamille, nombreMembres, chefFamille) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, famille.getNomFamille());
            statement.setInt(2, famille.getNombreMembres());
            statement.setInt(3, famille.getChefFamille().getId()); // ID du chef de famille (Citoyen)
            statement.executeUpdate();
            System.out.println("Famille ajoutée avec succès : " + famille.getNomFamille());
        }
    }

    // Méthode pour lister toutes les familles
    public List<Famille> listerFamilles() throws SQLException {
        List<Famille> familles = new ArrayList<>();
        String query = "SELECT * FROM familles";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Famille famille = new Famille();
                famille.setId(resultSet.getInt("id"));
                famille.setNomFamille(resultSet.getString("nomFamille"));
                famille.setNombreMembres(resultSet.getInt("nombreMembres"));
                // Ajoute ici la logique pour récupérer le chef de famille (Citoyen) si nécessaire
                familles.add(famille);
            }
        }
        return familles;
    }

    // Méthode pour modifier une famille
    public void modifierFamille(int id, Famille famille) throws SQLException {
        String query = "UPDATE familles SET nomFamille = ?, nombreMembres = ?, chefFamille = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, famille.getNomFamille());
            statement.setInt(2, famille.getNombreMembres());
            statement.setInt(3, famille.getChefFamille().getId());
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Famille modifiée avec succès : " + famille.getNomFamille());
        }
    }

    // Méthode pour supprimer une famille
    public void supprimerFamille(int id) throws SQLException {
        String query = "DELETE FROM familles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Famille supprimée avec succès : ID " + id);
        }
    }
}
