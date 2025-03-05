import java.util.Scanner;

public class Main12 {
    private static FlashcardManager flashcardManager = new FlashcardManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🧠 Welcome to Flashcard Learning System 🧠");

        while (true) {
            System.out.println("\n1. Create Flashcard");
            System.out.println("2. View All Flashcards");
            System.out.println("3. Edit Flashcard");
            System.out.println("4. Delete Flashcard");
            System.out.println("5. Test Mode (Self-Quiz)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    flashcardManager.createFlashcard();
                    break;
                case 2:
                    flashcardManager.viewFlashcards();
                    break;
                case 3:
                    flashcardManager.editFlashcard();
                    break;
                case 4:
                    flashcardManager.deleteFlashcard();
                    break;
                case 5:
                    flashcardManager.testMode();
                    break;
                case 6:
                    System.out.println("Exiting... Keep Learning! 🎓");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
