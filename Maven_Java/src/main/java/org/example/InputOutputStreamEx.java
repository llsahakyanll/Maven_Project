package org.example;

import java.io.*;
import java.util.Optional;

public class InputOutputStreamEx {
    public static void main(String[] args) {
        Optional<BufferedReader> optional = Optional.empty();
        try {
            File file = new File("text.txt");

            if (!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            pw.println("Hello");
            pw.println("How are you?");
            pw.println("Fine");
            pw.println("And you?");
            pw.println("Fine, thanks");

            pw.close();

            optional = Optional.of(new BufferedReader(new FileReader(file)));
            String s;
            while ( (s = optional.get().readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(optional.isPresent()) {
                try {
                    optional.get().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
