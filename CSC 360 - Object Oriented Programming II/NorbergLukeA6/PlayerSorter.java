import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PlayerSorter {
    public static void main(String[] args) {
        var players = new ArrayList<Player>();

        try (Scanner input = new Scanner(new File("players.txt"))) {
            while (input.hasNext()) {
                String fName = input.next();
                String lName = input.next();
                Double score = Double.parseDouble(input.next());
                players.add(new Player(fName, lName, score));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        var playerNameLenPQ = new PriorityQueue<Player>(players.size(), new NameLengthComparator());
        var playerScorePQ = new PriorityQueue<Player>(players.size(), new ScoreComparator());

        for (Player player : players) {
            playerNameLenPQ.add(player);
            playerScorePQ.add(player);
        }

        System.out.println("--------- Name comparator -----------");
        removeAndPrintQueue(playerNameLenPQ);
        System.out.println("--------- Score comparator -----------");
        removeAndPrintQueue(playerScorePQ);
    }

    public static void removeAndPrintQueue(PriorityQueue<Player> pq) {
        while (!pq.isEmpty()) {
            Player player = pq.remove();
            System.out.printf("%s %s\t%.2f\n", player.getfName(), player.getlName(), player.getScore());
        }
    }
}

class Player {
    private String fName;
    private String lName;
    private Double score;

    public Player(String fName, String lName, Double score) {
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Double getScore() {
        return score;
    }
}

class NameLengthComparator implements java.util.Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int p1NameLength = p1.getfName().length() + p1.getlName().length();
        int p2NameLength = p2.getfName().length() + p2.getlName().length();

        if (p1NameLength == p2NameLength) {
            return 0;
        }
        return (p1NameLength > p2NameLength) ? 1 : -1;
    }
}

class ScoreComparator implements java.util.Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getScore() == p2.getScore()) {
            return 0;
        }
        return (p1.getScore() > p2.getScore()) ? 1 : -1;
    }
}
