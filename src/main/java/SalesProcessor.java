import Receipt.SimpleReceipt;
import models.*;
import service.OrderService;

import java.util.List;

/**
 * Created by plongobucco on 24/03/18.
 */
public class SalesProcessor {

    public static void main(String[] args) {

        // Basket One
        List<Product> basketOne = OrderService.getBasket(1);

        Order order = new Order();
        order.initOrder();
        for (Product product : basketOne){
             order.add(product);
        }

        SimpleReceipt receipt = SimpleReceipt.printReceipt(System.out);
        order.print(receipt);

        // Basket Two
        List<Product> basketTwo = OrderService.getBasket(2);
        Order orderTwo = new Order();
        orderTwo.initOrder();
        for (Product product : basketTwo){
            orderTwo.add(product);
        }

        SimpleReceipt receiptOrderTwo = SimpleReceipt.printReceipt(System.out);
        orderTwo.print(receiptOrderTwo);

        // Basket Three
        List<Product> basketThree = OrderService.getBasket(3);

        Order orderThree = new Order();
        orderThree.initOrder();
        for (Product product : basketThree){
            orderThree.add(product);
        }

        SimpleReceipt receiptOrderThree = SimpleReceipt.printReceipt(System.out);
        orderThree.print(receiptOrderThree);

    }

}
