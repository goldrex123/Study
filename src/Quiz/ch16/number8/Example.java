package Quiz.ch16.number8;

public class Example {
    private static Student[] students = {
            new Student("홍길동", 90, 96),
            new Student("신용권", 95, 93)
    };

    public static double avg(Function function) {
        int sum = 0;
        for (Student student : students) {
            sum += function.apply(student);
        }

        double avg = (double) sum / students.length;
        return avg;
    }


    public static void main(String[] args) {
        double englistAvg = avg(student -> student.getEnglishScore());
        System.out.println("영어 평균 점수 : " + englistAvg);

        double mathAvg = avg(Student::getMathScore);
        System.out.println("수학 평균 점수 : " + mathAvg);

    }
}
