package Assignment;
import java.util.Scanner;
import static java.lang.Math.random;

public class GoFish { 

public static boolean stillplaying(int player1points, int player2points, int player3points, int player4points) {
    return player1points < 10 && player2points < 10 && player3points < 10 && player4points < 10;
} //This function indicates if we are still playing as long as no one has more than 10 points


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
} //This function prints our deck and prints the computers decks as XX's, it does so by checking as long as the player is not
//player1 we will make result += to X

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
}//this function makes a random card drawn with randomized suites and cards then puts them together using the * random


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
}//this function our removepairs removes all similar pairs and also checks if we have more than 3 similiar cards not to delete all of them
//it also makes sure it is only checking the car numbers and not the suits as suits are irrelevant



public static int addpoints(String playerdecks) {
    return ((10 - playerdecks.length()) / 4);
}//this function our addpoints adds a point when we have 2 of the same cards by checking how many cards onn the deck


public static int RequestPlayer(int cur) {
    int player;
    if (cur == 1) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Select a player to choose from: ");
        player = Scan.nextInt();
        while (player == cur) {
            System.out.println("Cannot chose yourself, choose another player");
            player = Scan.nextInt();
        }
    } else {
        player = (int) (4 * random()) + 1;
        while (player == cur) {
            player = (int) (4 * random()) + 1;
        }
    }
    return player;
}//this function our requestplayer asks for a player using a scanner and if the player is == to cur which is 1 we cannot proceed


public static String RequestCard(String playerDeck, int cur) {
    String card;
    if (cur == 1) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Select a card to chose from, your deck is: ");
        printDeck(playerDeck, 1);
        card = Scan.next();
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
}//this function our requestcard asks for a card using a scanner and if the card is not in the deck or not a card in the string umbers we will recieve an invalid input


public static String CheckCard(String OpponentDeck, String card) {
    if (!OpponentDeck.contains(card)) {
        return "GO FISH!";
    } else {
        int index = OpponentDeck.indexOf(card);
        return OpponentDeck.substring(index - 1, index + 1);
    }
}//this function our checkcard checks of the player requested actually has the card we are asking for


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
}//This function gets the players decks by checking which number is set to cur


public static void main(String[] args) throws InterruptedException {

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

    for (int i = 0; i < 5; i++) {
        player1deck += drawCard();
        player2deck += drawCard();
        player3deck += drawCard();
        player4deck += drawCard();
    }
    System.out.println("Cards before handing in pairs");
    printDeck(player1deck, 1); //Player 1 Deck: cards
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
        System.out.println("=====================================");
        System.out.println("Current player is player: " + cur);
        System.out.println("");
        if (cur != 1) {
            System.out.println("Computer " + cur + " thinking...");
            Thread.sleep(5000);
        }

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


        int requestedplayer = RequestPlayer(cur);
        System.out.println(requestedplayer + " is the selected player");
        System.out.println("=====================================");
        System.out.println("");

        String CurrentDeck = GetPlayerDeck(cur, player1deck, player2deck, player3deck, player4deck);
        String requestedcard = RequestCard(CurrentDeck, cur);
        System.out.println("Requested Card is: " + requestedcard);
        String OpponentsDeck = GetPlayerDeck(requestedplayer, player1deck, player2deck, player3deck, player4deck);
        String result = CheckCard(OpponentsDeck, requestedcard);

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
    if (player1points == 10) {
        System.out.println("You Won!");
    } else if (player2points == 10) {
        System.out.println("Player 2 has Won!");
    } else if (player3points == 10) {
        System.out.println("Player 3 has Won!");
    } else if (player4points == 10) {
        System.out.println("Player 4 has Won!");
    }
}



    public static void playAgain() throws InterruptedException { //this asks if you want to play again
        System.out.println("Would you like to play again? (yes, no)");
        Scanner input;
        String ans = input.nextLine().toLowerCase();

        while (true) {
            if (ans.equals("yes")) {
                startGame();
            } else if (ans.equals("no")) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input! Enter either 'yes' or 'no'");
            }
        }
    }
}