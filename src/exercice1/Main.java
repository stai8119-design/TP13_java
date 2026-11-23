package exercice1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String outputPath = "team_data.ser";

        List<Employee> members = new ArrayList<>();
        members.add(new Employee(101, "Salma",  4200.0,  "keySalma123"));
        members.add(new Employee(102, "Amine",  3950.5,  "keyAmine456"));
        members.add(new Employee(103, "Nadia",  3600.25, "keyNadia789"));
        members.add(new Employee(104, "Faysal",  2560.9, "keyFaysal009"));

        try {
            SerializationUtil.saveRecords(outputPath, members);
            System.out.println("Le sauvegarde est effectuée dans : " + outputPath);
        } catch (IOException e) {
            System.err.println("Probleme dans la sérialisation : " + e.getMessage());
            return;
        }
        List<Employee> restoredMembers;
        try {
            restoredMembers = SerializationUtil.loadRecords(outputPath);
            System.out.println("Les données sont restaurées avec succès :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Probleme en désérialisation : " + e.getMessage());
            return;
        }

        for (Employee member : restoredMembers) {
            System.out.println("  " + member);
        }
        System.out.println("\nRemarque : 'secretKey' est marqué transient, donc sa valeur devient null après désérialisation.");
    }
}
