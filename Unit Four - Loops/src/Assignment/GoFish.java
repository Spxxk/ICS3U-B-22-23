package Assignment;
import java.util.Scanner;
import static java.lang.Math.random;

public class GoFish {
    //This function indicates if we are still playing as long as no one has more than 10 points
    //Input: All four players points
    //Output: Either true or false on wiether the game is stillplaying
    public static boolean stillplaying(int player1points, int player2points, int player3points, int player4points) {
        return player1points < 10 && player2points < 10 && player3points < 10 && player4points < 10;
    }

    //This function prints our deck and prints the computers decks as XX's
    //Input: players deck and white player
    //Output: N/A we do print the result though
    public static void printDeck(String playerDeck, int player) {
        String result = "";
        for (int i = 0; i < playerDeck.length(); i++) {
            if (player != 1) {
                result += "X";
                if (i % 2 == 1) {
                    result += " ";
                }
            } else {
                if (playerDeck.charAt(i) == 'S') {
                    result += "S";
                } else if (playerDeck.charAt(i) == 'H') {
                    result += "H";
                } else if (playerDeck.charAt(i) == 'D') {
                    result += "D";
                } else if (playerDeck.charAt(i) == 'C') {
                    result += "C";
                } else {
                    result += playerDeck.charAt(i);
                    result += " ";
                }
            }
        }
        System.out.println(result.strip());
    }

    //this function makes a random card drawn with randomized suites and cards then puts them together using the * random
    //Input: Nothing
    //Output: Random string that is a random card
    public static String drawCard() {
        String suite = "SHDC";
        int number = (int) (13 * random() + 1);
        String resultNumber = "";
        if (number == 10) {
            resultNumber = "T";
        } else if (number == 11) {
            resultNumber = "J";
        } else if (number == 12) {
            resultNumber = "Q";
        } else if (number == 13) {
            resultNumber = "K";
        } else {
            resultNumber = number + "";
        }
        return suite.charAt((int) (4 * random())) + resultNumber;
    }

    public static String removepairs(String AllCards) {
        String keepCards = "";
        String Triplets = "";
        for (int i = 0; i < AllCards.length() / 2; i++) {
            boolean isThereAPair = false;
            for (int j = 0; j < AllCards.length() / 2; j++) {
                if (i != j && AllCards.charAt(2 * i + 1) == AllCards.charAt(2 * j + 1)) {
                    isThereAPair = true;
                    break;
                }
            }
            if (!isThereAPair) {
                keepCards += AllCards.substring(2 * i, 2 * i + 2);
            } else {
                Triplets = AllCards.substring(2 * i, 2 * i + 2);
            }
        }
        if ((keepCards.length() == 4) || (keepCards.length() == 0)) {
            keepCards += Triplets;
        }
        return keepCards;
    }


    //This adds the points to our players
    //Input: playerdecks(String)
    //Output: The point was given
    public static int addpoints(String playerdecks) {
        return ((10 - playerdecks.length()) / 4);
    }

    //This requests a player to request a card from
    //Input: cur/the current player
    //Output: The requested player
    public static int RequestPlayer(int cur) {
        int player;
        if (cur == 1) {
            Scanner Scan = new Scanner(System.in);
            System.out.println("Select a player to choose from: ");
            try {
                player = Scan.nextInt();
                while (player == cur || player > 4 || player < 1) {
                    System.out.println("Invalid Input, please chose another player");
                    player = Scan.nextInt();
                }

            }
            catch(Exception e){
                System.out.println("There is a typo, automatically choosing the next player");
                player = 2;
            }
        } else {
            player = (int) (4 * random()) + 1;
            while (player == cur) {
                player = (int) (4 * random()) + 1;
            }
        }
        return player;
    }


    //This requests a card from the player you chose
    //Input: current player and their decks
    //Output: The chosen card
    public static String RequestCard(String playerDeck, int cur) {
        String card;
        if (cur == 1) {
            Scanner Scan = new Scanner(System.in);
            System.out.println("Select a card to chose from, your deck is: ");
            printDeck(playerDeck, 1);
            card = Scan.next().toUpperCase();
            String numbers = "123456789TJQK";
            while (!numbers.contains(card) || !playerDeck.contains(card)) {
                System.out.println("Invalid input, chose another card");
                card = Scan.next();
            }
        } else {
            int Len = playerDeck.length() / 2;
            int index = (int) (Len * random());
            card = playerDeck.charAt(index * 2 + 1) + "";
        }
        return card;
    }


    //This checks if the card exists or not
    //Input: The opponents deck and the card selected
    //Output: Removed card or GO FISH!
    public static String CheckCard(String OpponentDeck, String card) {
        if (!OpponentDeck.contains(card)) {
            return "GO FISH!";
        } else {
            int index = OpponentDeck.indexOf(card);
            return OpponentDeck.substring(index - 1, index + 1);
        }
    }


    //This gets the current players deck
    //Input: the current player and all the players decks
    //Output: the current players deck
    public static String GetPlayerDeck(int cur, String player1deck, String player2deck, String player3deck, String player4deck) {
        if (cur == 1) {
            return player1deck;
        } else if (cur == 2) {
            return player2deck;
        } else if (cur == 3) {
            return player3deck;
        } else {
            return player4deck;
        }
    }


    //This is the main game loop
    public static void gameStart() throws InterruptedException {

        //Initilizes the games stats and prints the title
        int player1points = 0;
        int player2points = 0;
        int player3points = 0;
        int player4points = 0;

        String player1deck = "";
        String player2deck = "";
        String player3deck = "";
        String player4deck = "";

        System.out.println("Welcome To Go Fish!");
        System.out.println("");


        //This initializes the players decks and removes pairs
        for (int i = 0; i < 5; i++) {
            player1deck += drawCard();
            player2deck += drawCard();
            player3deck += drawCard();
            player4deck += drawCard();
        }
        System.out.println("Cards before handing in pairs");
        printDeck(player1deck, 1);
        printDeck(player2deck, 2);
        printDeck(player3deck, 3);
        printDeck(player4deck, 4);
        System.out.println("");

        player1deck = removepairs(player1deck);
        player2deck = removepairs(player2deck);
        player3deck = removepairs(player3deck);
        player4deck = removepairs(player4deck);

        player1points = addpoints(player1deck);
        player2points = addpoints(player2deck);
        player3points = addpoints(player3deck);
        player4points = addpoints(player4deck);


        int cur = 1;

        System.out.println("+++++++++++ Game Begins! +++++++++");

        while (stillplaying(player1points, player2points, player3points, player4points)) {
            //This displayes the current player and the board
            System.out.println("=====================================");
            System.out.println("Current player is player: " + cur);
            System.out.println("");

            if(cur == 1){
                System.out.println("The Board is now: ");
                printDeck(player1deck, 1);
                printDeck(player2deck, 2);
                printDeck(player3deck, 3);
                printDeck(player4deck, 4);
                System.out.println();
                System.out.println("=====================================");
                System.out.println("You have " + player1points + " points");
                System.out.println("player2 has " + player2points + " points");
                System.out.println("player3 has " + player3points + " points");
                System.out.println("player4 has " + player4points + " points");
                System.out.println("=====================================");
            }
            else{
                System.out.println("Computer " + cur + " thinking...");
                Thread.sleep(5000);
            }

            //This asks for the player and card
            int requestedplayer = RequestPlayer(cur);
            System.out.println(requestedplayer + " is the selected player");
            System.out.println("=====================================");

            String CurrentDeck = GetPlayerDeck(cur, player1deck, player2deck, player3deck, player4deck);
            String requestedcard = RequestCard(CurrentDeck, cur);
            System.out.println("Requested Card is: " + requestedcard);

            String OpponentsDeck = GetPlayerDeck(requestedplayer, player1deck, player2deck, player3deck, player4deck);
            String result = CheckCard(OpponentsDeck, requestedcard);

            //This checks of the card is found or available
            if (!result.equals("GO FISH!")) {
                System.out.println("Found card: " + result);
                OpponentsDeck = OpponentsDeck.replace(result, "");
                if (OpponentsDeck.length() == 0) {
                    for (int i = 0; i < 5; i++) {
                        OpponentsDeck += drawCard();
                    }
                }
                if (requestedplayer == 1) {
                    player1deck = OpponentsDeck;
                }
                if (requestedplayer == 2) {
                    player2deck = OpponentsDeck;
                }
                if (requestedplayer == 3) {
                    player3deck = OpponentsDeck;
                }
                if (requestedplayer == 4) {
                    player4deck = OpponentsDeck;
                }

                //This adds a point
                CurrentDeck += result;
                CurrentDeck = removepairs(CurrentDeck);
                if (cur == 1) {
                    player1points += 1;
                }
                if (cur == 2) {
                    player2points += 1;
                }
                if (cur == 3) {
                    player3points += 1;
                }
                if (cur == 4) {
                    player4points += 1;
                }
                if (CurrentDeck.length() == 0) {
                    for (int i = 0; i < 5; i++) {
                        CurrentDeck += drawCard();
                    }
                }
            } else {


                //This removes the pair fromt he deck
                System.out.println(result);
                CurrentDeck += drawCard();
                int Len = CurrentDeck.length();
                CurrentDeck = removepairs(CurrentDeck);
                if (CurrentDeck.length() < Len) {
                    if (cur == 1) {
                        player1points += 1;
                    }
                    if (cur == 2) {
                        player2points += 1;
                    }
                    if (cur == 3) {
                        player3points += 1;
                    }
                    if (cur == 4) {
                        player4points += 1;
                    }
                }
            }


            //This draws a card if the hand reaches 0 card
            if (CurrentDeck.length() == 0) {
                for (int i = 0; i < 5; i++) {
                    CurrentDeck += drawCard();
                }
            }
            if (cur == 1) {
                player1deck = CurrentDeck;
            }
            if (cur == 2) {
                player2deck = CurrentDeck;
            }
            if (cur == 3) {
                player3deck = CurrentDeck;
            }
            if (cur == 4) {
                player4deck = CurrentDeck;
            }

            cur += 1;
            if (cur == 5) {
                cur = 1;
            }
        }


        //This displays the winner and the amount of points
        if (player1points == 10) {
            System.out.println("+++++++++++++++++++++++++++++++++++++");
            System.out.println("You Won!");
        } else if (player2points == 10) {
            System.out.println("Player 2 has Won!");
        } else if (player3points == 10) {
            System.out.println("Player 3 has Won!");
        } else if (player4points == 10) {
            System.out.println("Player 4 has Won!");
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("player1 has: " + player1points + " points");
        System.out.println("player2 has: " + player2points + " points");
        System.out.println("player3 has: " + player3points + " points");
        System.out.println("player4 has: " + player4points + " points");
    }


    //This is the game menu
    public static void main(String [] args) throws InterruptedException {
        int counter = 0;
        while (true) {
            if(counter == 0){
                System.out.println("Would you like to play? (yes, no)");
            }
            else{
                System.out.println("Would you like to play again? (yes, no)");
            }
            Scanner input = new Scanner(System.in);
            String ans = input.nextLine().toLowerCase();
            if (ans.equals("yes")) {
                counter++;
                gameStart();
            } else if (ans.equals("no")) {
                break;
            } else {
                System.out.println("Invalid Input! Enter either 'yes' or 'no'");
            }
        }
    }
}

