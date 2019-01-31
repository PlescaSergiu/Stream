package homework;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;


public class WriteToFile {


    public void writeToFile(String birthday) {

        String[] brd = birthday.split("-");
        String sort = brd[0];

        List<String> list = new ArrayList<>();

        //reading text file into stream, try-with-resources
        try (Stream<String> stream = lines(Paths.get("C:\\Java\\HomeWorkStream\\Read.csv"))) {
            list = stream
                    .filter(line -> line.contains(sort))
                    .sorted()
                    .collect(Collectors.toList());

            list.forEach(System.out::println);
            for (String i : list) {
                String[] lines = i.split(",");
                String output = lines[0] + "-" + lines[1];
                try {

                    Files.write(Paths.get("C:\\Java\\HomeWorkStream\\Write.csv"), output.getBytes());


                } catch (IllegalAccessError e) {
                    e.printStackTrace();

                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
