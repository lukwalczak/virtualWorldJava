import java.io.Console;
import java.io.IOException;

public class Human extends Animal {
    private static final int initialStrenght = 5;
    private final int initialInitiative = 5;
    private final int initialposX = 5;
    private final int initialposY = 5;
    private final String initialOrganismChar = "H";
    private final String initialOrganismFullName = "Human";
    private boolean alive;

    public Human(Board board) {
        super(5, 5, 5, 5, "H", "Human", board);
        this.alive = true;
    }

    public boolean getAlive() {
        return this.alive;
    }

    @Override
    public void action() throws IOException {
        boolean confirmMove = false;

        Console console = System.console();
        if (console == null) {
            System.err.println("No console available");
            System.exit(1);
        }

        System.out.print("Press an arrow key: ");

        // Read the input character by character
        while (true) {
            char input = 0;
            try {
                input = (char) console.reader().read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Check for escape sequences representing arrow keys
            if (input == 27 && console.reader().ready()) {
                char secondInput = (char) console.reader().read();

                if (secondInput == '[' && console.reader().ready()) {
                    char thirdInput = (char) console.reader().read();

                    // Process the arrow key based on the third input
                    switch (thirdInput) {
                        case 'A':
                            if (this.checkMove(0, 1)) {
                                this.posY += 1;
                            }

                            System.out.println("Up arrow key pressed");
                            break;
                        case 'B':
                            System.out.println("Down arrow key pressed");
                            break;
                        case 'C':
                            System.out.println("Right arrow key pressed");
                            break;
                        case 'D':
                            System.out.println("Left arrow key pressed");
                            break;


                    }
                }
            }
        }

    }
}
