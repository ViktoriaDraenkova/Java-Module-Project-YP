import java.util.ArrayList;

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