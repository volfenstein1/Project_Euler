import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Problem022 {

    public static int nameScore(String name) {
        int score = 0;
        for (char c : name.toCharArray()) {
            score += c - 'A' + 1;
        }
        return score;
    }

    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("names.txt")));
            String[] names = content.replace("\"", "").split(",");
            Arrays.sort(names);

            long totalScore = 0;
            for (int i = 0; i < names.length; i++) {
                totalScore += (long) (i + 1) * nameScore(names[i]);
            }

            System.out.println(totalScore);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
