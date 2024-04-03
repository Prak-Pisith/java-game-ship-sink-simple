import java.util.Scanner;

class Ship {
    private int[] locations;
    private int numOfHits = 0;

    public void setLocations(int[] locations) {
        this.locations = locations;
    }

    public String healthCheck(int guess) {
        String result = "MISS";
        for (int cell : this.locations) {
            if (cell == guess) {
                result = "HIT";
                ++this.numOfHits;
                break;
            }
        }
        if (this.numOfHits >= this.locations.length) result = "KILL";
        System.out.println("You've " + result + " the ship.");
        return result;
    }
}

class GameLauncher {
    public static void main(String[] args) {
        System.out.println("Game Start");

        // TDD
        System.out.println("============ START TESTING GAME ============");
        testCase1();
        testCase2();
        testCase3();
        System.out.println("============ END TESTING GAME ============");
        System.out.println("");

        // Gameplay
        System.out.println("============ START PLAYING GAME ============");
        gamePlay();
        System.out.println("============ END PLAYING GAME ============");
    }

    public static void gamePlay() {
        // Helper
        Scanner scanner = new Scanner(System.in);

        // Stat
        int userQuess = 0;

        // Init Ship
        Ship ship = new Ship();
        boolean isAlive = true;

        // Get Ramdom number of location
        int headCell = (int) (Math.random() * 5);
        // Set Ship Location
        int[] locations = {headCell, headCell + 1, headCell + 2};
        ship.setLocations(locations);

        // Play
        while (isAlive) {
            // Prompt the user for input
            System.out.print("Enter number: ");
            userQuess = scanner.nextInt();
            String result = ship.healthCheck(userQuess);
            if (result == "KILL") {
                isAlive = false;
                System.out.println("Ship Sinked");
            }
        }

        // Close the Scanner (optional but good practice)
        scanner.close();
    }

    public static void testCase1 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        int[] locations = {2,3,4};
        ship.setLocations(locations);

        // Guessing
        int userGuess = 2;
        String result = ship.healthCheck(userGuess);

        // Check Result
        if (result == "HIT") testResult = "PASSED";

        // Output
        System.out.println("Test 1:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }

    public static void testCase2 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        int[] locations = {2,3,4};
        ship.setLocations(locations);

        // Guessing
        int userGuess = 5;
        String result = ship.healthCheck(userGuess);

        // Check Result
        if (result == "MISS") testResult = "PASSED";

        // Output
        System.out.println("Test 2:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }

    public static void testCase3 () {
        // ========= START TEST =========
        String testResult = "FAILED";

        // Init Ship
        Ship ship = new Ship();

        // Init Locations
        int[] locations = {2,3,4};
        ship.setLocations(locations);

        // Guessing
        int[] userGuesses = locations;
        String result = null;
        for (int userGuess : userGuesses) {
            result = ship.healthCheck(userGuess);
        }

        // Check Result
        if (result == "KILL") testResult = "PASSED";

        // Output
        System.out.println("Test 3:");
        System.out.println("Expected : PASSED");
        System.out.println("Result   : " + testResult);
        // ========= END TEST =========
    }
}