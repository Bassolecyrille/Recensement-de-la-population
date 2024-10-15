import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistiques {
    public static void afficherDetailsPersonne(Personne personne) {
        personne.afficherInfos(); // Appel polymorphe
    }

    public static int calculerPopulationTotale(List<Citoyen> citoyens) {
        return citoyens.size();
    }

    public static double calculerMoyenneAge(List<Citoyen> citoyens) {
        int somme = 0;
        for (Citoyen citoyen : citoyens) {
            somme += citoyen.getAge();
        }
        return (double) somme / citoyens.size();
    }

    public static Map<String, Long> repartitionParSexe(List<Citoyen> citoyens) {
        return citoyens.stream().collect(Collectors.groupingBy(Citoyen::getSexe, Collectors.counting()));
    }
}
