

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ZoneGeographiqueDAO {
    private Connection connection;

    public ZoneGeographiqueDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter une zone géographique
    public void ajouterZoneGeographique(ZoneGeographique zone) throws SQLException {
        String query = "INSERT INTO zones_geographiques (nom, nombreHabitants) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, zone.getNom());
            statement.setInt(2, zone.getNombreHabitants());
            statement.executeUpdate();
            System.out.println("Zone géographique ajoutée avec succès : " + zone.getNom());
        }
    }

    // Méthode pour lister toutes les zones géographiques
    public List<ZoneGeographique> listerZonesGeographiques() throws SQLException {
        List<ZoneGeographique> zones = new ArrayList<>();
        String query = "SELECT * FROM zones_geographiques";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                ZoneGeographique zone = new ZoneGeographique();
                zone.setId(resultSet.getInt("id"));
                zone.setNom(resultSet.getString("nom"));
                zone.setNombreHabitants(resultSet.getInt("nombreHabitants"));
                zones.add(zone);
            }
        }
        return zones;
    }

    // Méthode pour modifier une zone géographique
    public void modifierZoneGeographique(int id, ZoneGeographique zone) throws SQLException {
        String query = "UPDATE zones_geographiques SET nom = ?, nombreHabitants = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, zone.getNom());
            statement.setInt(2, zone.getNombreHabitants());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Zone géographique modifiée avec succès : " + zone.getNom());
        }
    }

    // Méthode pour supprimer une zone géographique
    public void supprimerZoneGeographique(int id) throws SQLException {
        String query = "DELETE FROM zones_geographiques WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Zone géographique supprimée avec succès : ID " + id);
        }
    }
}
