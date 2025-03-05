import java.io.*;
import java.util.*;

public class FileHandler5 {
    private static final String FILE_PATH = "flashcards.txt";

    public static void saveFlashcards(List<Flashcard> flashcards) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(flashcards);
        } catch (IOException e) {
            System.out.println("❌ Error saving flashcards.");
        }
    }

    public static List<Flashcard> loadFlashcards() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Flashcard>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
