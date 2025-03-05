import java.util.*;

public class FlashcardManager {
    private List<Flashcard> flashcards;
    private Scanner sc;

    public FlashcardManager() {
        this.flashcards = FileHandler5.loadFlashcards();
        this.sc = new Scanner(System.in);
    }

    public void createFlashcard() {
        System.out.print("Enter question: ");
        String question = sc.nextLine();
        System.out.print("Enter answer: ");
        String answer = sc.nextLine();

        flashcards.add(new Flashcard(question, answer));
        FileHandler5.saveFlashcards(flashcards);
        System.out.println("✅ Flashcard Created Successfully!");
    }

    public void viewFlashcards() {
        if (flashcards.isEmpty()) {
            System.out.println("📄 No flashcards available.");
            return;
        }

        System.out.println("\n📌 Flashcards:");
        for (int i = 0; i < flashcards.size(); i++) {
            System.out.println((i + 1) + ". " + flashcards.get(i));
        }
    }

    public void editFlashcard() {
        viewFlashcards();
        System.out.print("Enter flashcard number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < flashcards.size()) {
            System.out.print("Enter new question: ");
            flashcards.get(index).setQuestion(sc.nextLine());
            System.out.print("Enter new answer: ");
            flashcards.get(index).setAnswer(sc.nextLine());

            FileHandler5.saveFlashcards(flashcards);
            System.out.println("✅ Flashcard Updated Successfully!");
        } else {
            System.out.println("❌ Invalid flashcard number.");
        }
    }

    public void deleteFlashcard() {
        viewFlashcards();
        System.out.print("Enter flashcard number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < flashcards.size()) {
            flashcards.remove(index);
            FileHandler5.saveFlashcards(flashcards);
            System.out.println("✅ Flashcard Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid flashcard number.");
        }
    }

    public void testMode() {
        if (flashcards.isEmpty()) {
            System.out.println("❌ No flashcards available for testing.");
            return;
        }

        System.out.println("\n🧠 Test Mode - Try Answering the Questions!");
        int correctAnswers = 0;

        for (Flashcard flashcard : flashcards) {
            System.out.println("📝 " + flashcard.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            if (userAnswer.equalsIgnoreCase(flashcard.getAnswer())) {
                System.out.println("✅ Correct!");
                correctAnswers++;
            } else {
                System.out.println("❌ Incorrect! The correct answer is: " + flashcard.getAnswer());
            }
        }

        System.out.println("\n🎯 Test Completed! You got " + correctAnswers + "/" + flashcards.size() + " correct.");
    }
}
