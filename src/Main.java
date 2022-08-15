import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goalStep = 10000;
        System.out.println("Ваше целевое значение шагов в день - " + goalStep);

        String[] months = {"Январь","Февраль","Март","Апрель","Май", "Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        StepTracker stepTracker = new StepTracker(months);

        while(true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Выберите, за какой месяц вы хотите ввести шаги: ");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1) + " - " + months[month]);
                }

                int monthDigits = scanner.nextInt();  // изменить ввод на цифры

                if(monthDigits < 0){
                    System.out.println("Число месяца не может быть отрицательным.");

                }
                String month = months[monthDigits - 1];

                System.out.println("За какой день месяца " + month  + " вы хотите ввести шаги? Введите от 1 до 30:");
                int day = scanner.nextInt();
                if(day < 0){
                    System.out.println("День месяца не может быть отрицательным.");

                }else{
                    System.out.println("Введите количество за шагов за " + day + " день месяца " + month + ":");
                }


                int step = scanner.nextInt();

                stepTracker.addSteps(month, day, step);

            } else if (userInput == 2) {
                System.out.println("Выберите, за какой месяц вы хотите получить статистику: ");
                for (int month = 0; month < months.length; month++) {
                    System.out.println((month + 1 ) + " - " + months[month]);
                }

                int monthInt = scanner.nextInt(); // изменить ввод на цифры
                String month = months[monthInt - 1];

                stepTracker.goStepsInDay(month);
                stepTracker.sumStepMonth(month);
                stepTracker.maxStepMonth(month);
                stepTracker.averageStepMonth(month);
                stepTracker.pathsPassed(month);
                stepTracker.energySpent(month);
                stepTracker.bestSeries(goalStep, month);

            } else if (userInput == 3) {

                goalStep = stepTracker.newGoalStep();
                if(goalStep < 0){
                    System.out.println("Целевое значение шагов не может быть отрицательным.");
                }else{
                    System.out.println("Целевое количество шагов изменено.");
                    System.out.println("Ваша новая цель - " + goalStep + " шагов в день!");
                }



            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1. Ввести количество шагов за определённый день месяца");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выход");
    }
}
