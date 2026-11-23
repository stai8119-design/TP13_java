package exercice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationUtil {
    public static void saveRecords(String nomFichi, List<Employee> records)
            throws IOException {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(nomFichi))) {
            out.writeObject(records);
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Employee> loadRecords(String nomFichi)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(nomFichi))) {
            return (List<Employee>) in.readObject();
        }
    }
}
