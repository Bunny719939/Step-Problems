import java.util.Scanner;

abstract class Question {
    String question;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String question, String correctAnswer, String studentAnswer, double points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String question, String correctAnswer, String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equals(correctAnswer))
            return points;
        return 0;
    }
}

class TF extends Question {
    TF(String question, String correctAnswer, String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equals(correctAnswer))
            return points;
        return 0;
    }
}

class Essay extends Question {
    Essay(String question, String correctAnswer, String studentAnswer, double points) {
        super(question, correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (int i = 0; i < keywords.length; i++) {
            if (answer.contains(keywords[i].trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int firstSpace = line.indexOf(" ");
            String type = line.substring(0, firstSpace);

            Scanner lineScanner = new Scanner(line.substring(firstSpace + 1));
            lineScanner.useDelimiter("\"");

            String question = lineScanner.next();
            lineScanner.next();
            String correctAnswer = lineScanner.next();
            lineScanner.next();
            String studentAnswer = lineScanner.next();
            lineScanner.next();

            double points = Double.parseDouble(lineScanner.next().trim());

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(question, correctAnswer, studentAnswer, points);
            else if (type.equals("TF"))
                q = new TF(question, correctAnswer, studentAnswer, points);
            else
                q = new Essay(question, correctAnswer, studentAnswer, points);

            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;

            lineScanner.close();
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
