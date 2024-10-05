import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // пути к файлам
        String inputFilePath = "input.txt";  // файл для чтения
        String outputFilePath = "output.svc"; // файл для записи

        try {
            // считывание текста из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            String text = content.toString();

            // статистика
            int totalCharacters = text.length();
            int totalCharactersWithoutSpaces = text.replace(" ", "").length();
            String[] words = text.split("\\s+");
            int totalWords = words.length;

            // формирование строку для вывода
            String statistics = String.format("Количество символов: %d%nКоличество символов без пробелов: %d%nКоличество слов: %d%n",
                    totalCharacters, totalCharactersWithoutSpaces, totalWords);

            // вывод в консоль
            System.out.println(statistics);

            // запись в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            writer.write(statistics);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
