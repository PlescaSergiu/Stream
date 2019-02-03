package homework;


import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.stream.Stream;
import static java.nio.file.Files.lines;


public class WriteToFile {


    public void writeToFile(int month) {

        String search = Month.of(month).name().toLowerCase();

        try (Stream<String> stream = lines(Paths.get("C:\\Java\\HomeWorkStream\\Read.csv"))) {
            stream
                    .filter(x -> x.contains(search))
                    .sorted()
                    .forEach(x -> {
                        String[] data = x.split(",");
                        String output = data[0] + " " + data[1] + "\n";
                        try {
                            Files.write(Path.of("C:\\Java\\HomeWorkStream\\Write.csv"), output.getBytes(), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
