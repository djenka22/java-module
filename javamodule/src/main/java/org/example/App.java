package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {
    static final String WORD = "BALLOON";
    static final String FILE_FOR_READ = "Balloon";
    static final String FILE_FOR_WRITE = "Result";

    public static void main( String[] args ) {
        File fileToRead = new File(FILE_FOR_READ);
        File fileToWrite = new File(FILE_FOR_WRITE);
        try {
            FileReader fileReader = new FileReader(fileToRead);
            FileWriter fileWriter = new FileWriter(fileToWrite);
            List<String> lines = Reader.read(fileReader);
            log.info(lines.toString());
            Map map = Balloon.count(lines, WORD);
            Writer.write(fileWriter, map);
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            log.info(
                    e.getMessage(),
                    LocalDateTime.now()
                    );

        } catch (IOException e) {
            log.info(
                    e.getMessage(),
                    LocalDateTime.now()
            );
        } catch (RuntimeException e) {
            log.info(
                    e.getMessage(),
                    LocalDateTime.now()
            );
        }
        /*
            ILI MOZEMO DA UHVATIMO SVE
            catch (Exception e) {}
            ILI
            catch (IOException e)
            catch (RuntimeException e)
            ILI
            catch (IOException | RuntimeException e)
        */
    }




}
