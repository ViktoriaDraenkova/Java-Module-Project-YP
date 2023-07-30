import java.util.Scanner;
import java.util.ArrayList;


class Product {
    float cost;
    String name;

    Product(float cost, String name) {
        this.cost = cost;
        this.name = name;
    }
}

class Calculator {
    float sum;
    ArrayList<String> products = new ArrayList<>();

    Calculator() {

    }

    public void addProduct(Product product) {
        products.add( "\n" + product.name + " " + Float.toString(product.cost) + "\n");
        sum += product.cost;
    }

    public void print() {
        if (products.size() == 0) {
            System.out.println("Дорогой пользователь, ты не ввёл ни одного товара!");
            return;
        }
        System.out.println(products);
    }
}


class Formatter{
    public static String format(double sum, int  amount){
        int digit= (int) ((sum/amount)%10);
        switch (digit){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}



class Main {

    public static void printMenu() {
        System.out.println("Введите подходящий вам вариант ^-^\n");
        System.out.println(" 1- Я хочу добавить товар\n");
        System.out.println(" 2- Хотелось бы увидеть общую и индивидуальную сумму на которую мы уже нагребли\n");
        System.out.println("Вы хотите завершить закупку? Тогда напишите \"завершить\" \n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуй дорогой пользователь! На скольких человек необходимо разделить счёт?");
        int amount = 0;
        do {
            if (scanner.hasNextInt()) {
                amount = scanner.nextInt();
                if (amount<=1){
                    System.out.println("Корректно вводите данные! Кол-во людей должно быть больше 1!");
                }
            } else {
                System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
                return;
            }
        }
        while (amount <= 1);

        Calculator calc = new Calculator();

        while (true) {
            printMenu();
            String num = scanner.next();
            num = num.toLowerCase();
            switch(num) {
                case "1":
                    System.out.println("Введите наименование товара, который хотите приобрести");
                    String name = scanner.next();
                    System.out.println("Введите цену товара, который хотите приобрести");
                    float cost;
                    if (scanner.hasNextFloat()) {
                        cost = scanner.nextFloat();
                        Product product = new Product(cost, name);
                        calc.addProduct(product);
                    } else {
                        System.out.println("Дорогой пользователь, введи корректную цену товара)");
                    }
                    break;
                case "2":
                    calc.print();
                    float numb =  (calc.sum/amount);
                    String formated = String.format("%.2f",numb);
                    System.out.println("Пока каждый из вашей компании должен будет за товары " + formated+ " "  + Formatter.format(calc.sum, amount));
                    break;
                case "завершить":
                    scanner.close();
                    return;

            }
        }
    }
}