package exercice2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    public static void save(String path, List<ChatMessage> messages) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeInt(messages.size());
            for (ChatMessage entry : messages) {
                entry.writeExternal(oos);
            }
        }
    }
    public static List<ChatMessage> load(String path) throws IOException, ClassNotFoundException {
        List<ChatMessage> messages = new ArrayList<>();
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(path))) {
            int total = ois.readInt();
            for (int i = 0; i < total; i++) {
                ChatMessage entry = new ChatMessage();
                entry.readExternal(ois);
                messages.add(entry);
            }
        }
        return messages;
    }
}
