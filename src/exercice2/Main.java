package exercice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String storageFile = "messages_log.ser";

        List<ChatMessage> conversation = new ArrayList<>();
        conversation.add(new ChatMessage("Salma",  "Bonjour tout le monde !"));
        conversation.add(new ChatMessage("Amine",  "Ça avance bien le TP ?"));
        conversation.add(new ChatMessage("Nadia",  "Oui, presque terminé."));

        try {
            ChatHistory.save(storageFile, conversation);
            System.out.println("Les messages sont enregistrés dans : " + storageFile);
        } catch (IOException e) {
            System.err.println("Probleme lors de l'enregistrement : " + e.getMessage());
            return;
        }

        List<ChatMessage> importedMessages;
        try {
            importedMessages = ChatHistory.load(storageFile);
            System.out.println("Les messages sont rechargés :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Probleme lors du chargement : " + e.getMessage());
            return;
        }

        for (ChatMessage entry : importedMessages) {
            System.out.printf("  [%d chars] %s%n", entry.getCharCount(), entry);
        }
    }
}
