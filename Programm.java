import java.io.*;
import java.nio.charset.StandardCharsets;

public class Programm {
    public static void main(String[] args) {
        String jsonStr = " { { \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";
        ex0(jsonStr);
    }

    static void ex0(String jsonStr) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = jsonStr.split("[{| |\"|:|,|}|\n]+");

        String repStr = "";
        int count = 0;

        for (String ws : str) {
            repStr += ws + " ";
            count++;
            if (count == 7) {
                repStr += ". \n";
                count = 1;
            }
        }
        // stringBuilder.append(str);
        stringBuilder.append(
                repStr.replace("фамилия", "Студент").replace("оценка", "получил").replace("предмет", "по предмету"));
        ex1(repStr);
        System.out.print(stringBuilder);
    }

    static void ex1(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        File file = new File("jsonParce.txt");

        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
            out.print(str);
            boolean created = file.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

}
// }
/*
 * { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
 * Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 * Используйте StringBuilder для подготовки ответа
 */