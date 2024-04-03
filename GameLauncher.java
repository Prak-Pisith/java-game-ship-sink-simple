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
        return result;
    }
}

class GameLauncher {
    public static void main(String[] args) {
        System.out.println("Game Start");

        // TDD
        testCase1();
        testCase2();

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
}