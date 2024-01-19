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

    public static void reload() {
        file = new File("./" + filename);
        init();
    }

    public static BufferedReader getReader() throws IOException {
        return Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
    }

    public static BufferedWriter getWriter() throws IOException {
        return Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8);
    }

    public static void toggleStatus() {
        List<String> toWrite = getPlayers();
        try (BufferedWriter writer = getWriter()) {
            if (!isDisabled()) toWrite.add(0, "#disabled");
            writer.write(String.join("\n", toWrite));
        } catch (IOException e) {
            e.printStackTrace();
            Main.LOGGER.error("Unable to open whitelist file. The function won't work properly.");
        }
    }

    public static boolean isDisabled() {
        try (BufferedReader reader = getReader()) {
            String line = reader.readLine();
            if (line == null) return false;
            return line.equalsIgnoreCase("#disabled") || line.equalsIgnoreCase("# disabled");
        } catch (IOException e) {
            e.printStackTrace();
            Main.LOGGER.error("Unable to open whitelist file. The function won't work properly.");
            return true;
        }
    }

    public static List<String> getPlayers() {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader reader = getReader()) {
            String line = reader.readLine();
            while (line != null) {
                if (!line.equalsIgnoreCase("#disabled") && !line.equalsIgnoreCase("# disabled")) result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Main.LOGGER.error("Unable to open whitelist file. The function won't work properly.");
            return new ArrayList<>();
        }
        return result;
    }

    public static void addPlayer(String name) {
        if (containsName(name)) return;
        List<String> currentList = getPlayers();
        currentList.add(name);
        try (BufferedWriter writer = getWriter()) {
            writer.write(String.join("\n", currentList));
        } catch (IOException e) {
            Main.LOGGER.error("Unable to open whitelist file. The function won't work properly.");
            e.printStackTrace();
        }
    }

    public static void removePlayer(String name) {
        if (!containsName(name)) return;
        List<String> currentList = getPlayers();
        currentList.remove(name);
        try (BufferedWriter writer = getWriter()) {
            writer.write(String.join("\n", currentList));
        } catch (IOException e) {
            Main.LOGGER.error("Unable to open whitelist file. The function won't work properly.");
            e.printStackTrace();
        }
    }

    public static boolean containsName(String name) {
        return getPlayers().stream().anyMatch(s -> s.equalsIgnoreCase(name));
    }
}
