import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Puzzle1 {
    public static void solve(String inputFileName) throws FileNotFoundException {
        var total = 0;
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            while (scanner.hasNextLine()) {
                byte firstDigit = 0;
                byte lastDigit = 0;

                final var line = scanner.nextLine();
                byte[] chars = line.getBytes(StandardCharsets.UTF_8);

                for (byte c : chars) {
                    if (Character.isDigit(c)) {
                        if (firstDigit == 0) {
                            firstDigit = c;
                            lastDigit = c;
                        } else {
                            lastDigit = c;
                        }
                    }
                }
                total += Integer.parseInt(new String(new byte[]{firstDigit, lastDigit}));
            }
        }
        System.out.println("total: " + total);
    }
}
