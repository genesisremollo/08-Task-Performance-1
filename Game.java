import java.util.Scanner;

interface GameMode {
    void storyMode();
    void survivalMode();
}

interface PlayerActions {
    void startGame();
    void quitGame();
}

interface GameDisplay {
    void displayWelcomeMessage();
    void displayGameModes();
}

public class Game implements GameMode, PlayerActions, GameDisplay {
    private String playerName;
    private String selectedMode;

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Enter your name: ");
    }

    @Override
    public void displayGameModes() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        System.out.println("Press P to start playing.");
    }

    @Override
    public void storyMode() {
        selectedMode = "Story";
        System.out.println("You selected Story Mode. Enjoy the adventure!");
    }

    @Override
    public void survivalMode() {
        selectedMode = "Survival";
        System.out.println("You selected Survival Mode. Prepare to survive!");
    }

    @Override
    public void startGame() {
        System.out.println("Press P to start playing, " + playerName + ".");
        System.out.println("Starting " + selectedMode + " Mode... Have fun!");
    }

    @Override
    public void quitGame() {
        System.out.println("Quitting the game. See you next time!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        game.displayWelcomeMessage();
        String name = scanner.nextLine();
        game.playerName = name;

        game.displayGameModes();
        int mode = scanner.nextInt();
        scanner.nextLine();

        switch (mode) {
            case 1:
                game.storyMode();
                break;
            case 2:
                game.survivalMode();
                break;
            default:
                System.out.println("Invalid option. Quitting...");
                return;
        }

        System.out.println("Press 'P' to start or 'Q' to quit.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("P")) {
            game.startGame();
        } else if (input.equalsIgnoreCase("Q")) {
            game.quitGame();
        } else {
            System.out.println("Invalid input. Exiting...");
        }

        scanner.close();
    }
}
