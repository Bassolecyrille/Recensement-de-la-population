

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class GestionCitoyensUI extends JFrame {

    private JTextField nomField;
    private JTextField professionField;
    private JTextField adresseField;
    private JTextField etatCivilField;
    private CitoyenDAO citoyenDAO;

    public GestionCitoyensUI() {
        try {
            citoyenDAO = new CitoyenDAO(DatabaseConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTitle("Gestion des citoyens");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des composants
        nomField = new JTextField(20);
        professionField = new JTextField(20);
        adresseField = new JTextField(20);
        etatCivilField = new JTextField(20);

        JButton ajouterButton = new JButton("Ajouter Citoyen");
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterCitoyen();
            }
        });

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Profession:"));
        panel.add(professionField);
        panel.add(new JLabel("Adresse:"));
        panel.add(adresseField);
        panel.add(new JLabel("Etat Civil:"));
        panel.add(etatCivilField);
        panel.add(new JLabel());
        panel.add(ajouterButton);

        // Ajout du panel à la fenêtre
        add(panel, BorderLayout.NORTH);

        // Table pour afficher la liste des citoyens
        JTable citoyensTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(citoyensTable);
        add(scrollPane, BorderLayout.CENTER);

        // Charger les citoyens existants
        chargerCitoyens(citoyensTable);
    }

    // Méthode pour ajouter un citoyen
    private void ajouterCitoyen() {
        try {
            Citoyen citoyen = new Citoyen();
            citoyen.setNom(nomField.getText());
            citoyen.setProfession(professionField.getText());
            citoyen.setAdresse(adresseField.getText());
            citoyen.setEtatCivil(etatCivilField.getText());

            citoyenDAO.ajouterCitoyen(citoyen);
            JOptionPane.showMessageDialog(this, "Citoyen ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du citoyen.");
        }
    }

    // Méthode pour charger et afficher la liste des citoyens
    private void chargerCitoyens(JTable table) {
        try {
            List<Citoyen> citoyens = citoyenDAO.listerCitoyens();
            Object[][] data = new Object[citoyens.size()][4];
            for (int i = 0; i < citoyens.size(); i++) {
                data[i][0] = citoyens.get(i).getNom();
                data[i][1] = citoyens.get(i).getProfession();
                data[i][2] = citoyens.get(i).getAdresse();
                data[i][3] = citoyens.get(i).getEtatCivil();
            }

            String[] columnNames = {"Nom", "Profession", "Adresse", "Etat Civil"};
            table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionCitoyensUI().setVisible(true);
            }
        });
    }
}

