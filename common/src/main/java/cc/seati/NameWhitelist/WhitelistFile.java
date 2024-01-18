package cc.seati.NameWhitelist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WhitelistFile {
    public static final String filename = "name-whitelist.txt";
    public static File file = new File("./" + filename);

    public static void init() {
        try {
           if (file.createNewFile()) {
               Main.LOGGER.info("Successfully created empty name whitelist at " + file.getAbsolutePath() + ".");
           }
        } catch (IOException e) {
            e.printStackTrace();
            Main.LOGGER.error("Unable to initialize whitelist file. The function won't work properly.");
        }
    }

    public static List<String> getPlayers() {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return result;
    }

    public static void addPlayer(String name) {
        if (containsName(name)) return;
        List<String> currentList = getPlayers();
        currentList.add(name);
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            writer.write(String.join("\n", currentList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removePlayer(String name) {
        if (!containsName(name)) return;
        List<String> currentList = getPlayers();
        currentList.remove(name);
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            writer.write(String.join("\n", currentList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean containsName(String name) {
        return getPlayers().stream().anyMatch(s -> s.equalsIgnoreCase(name));
    }
}
