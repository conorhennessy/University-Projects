package shop;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    Map<Product, Integer> items = new HashMap<Product, Integer>();
    ShopDB db;

    public static void main(String[] args) {
        Basket b = new Basket();
        b.addItem("art1");
        System.out.println(b.getTotalString());
        b.clearBasket();
        System.out.println(b.getTotalString());
        // check that adding a null String causes no problems
        String pid = null;
        b.addItem(pid);
        System.out.println(b.getTotalString());
    }

    public Basket() {
        db = ShopDB.getSingleton();
        items = new HashMap<Product, Integer>();
    }

    /**
     * @return Collection of Product items that are stored in the basket
     * <p>
     * Each item is a product object - need to be clear about that...
     * <p>
     * When we come to list the Basket contents, it will be much more
     * convenient to have all the product details as items in this way
     * in order to calculate that product totals etc.
     */
    public Map<Product, Integer> getItems() {
        return items;
    }

    /**
     *
     * @param
     */
    public void removeProduct(String currentPID){
        for (Product i : items.keySet()) {
            if (currentPID.equals(i.PID)) {
                items.remove(i);
            }
        }
    }

    /**
     * empty the basket - the basket should contain no items after calling this method
     */
    public void clearBasket() {
        items.clear();
    }

    /**
     * Adds an item specified by its product code to the shopping basket
     *
     * @param pid - the product code
     */
    public void addItem(String pid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        Product p = db.getProduct(pid);

        // ensure that we don't add any nulls to the item list
        Boolean found = false;
        Integer quantity = 0;
        Product incrementProduct = null;

        if (p != null) {
            // check if the item is already in map, the quantity will be incremented
            for (Product item : items.keySet()) {
                String currentPID = item.PID;
                if (currentPID.equals(pid)) {
                    found = true;
                    for (Product i : items.keySet()) {
                        String iPID = i.PID;
                        incrementProduct = i;
                        if (iPID.equals(pid)) {
                            quantity = items.get(i);
                        }
                    }
                    items.put(incrementProduct, quantity + 1);
                }
            }
            if (!found) {
                items.put(p, 1);
            }
        }
    }

    public Integer getQuantity(Product p) {
        return items.get(p);
    }

    public void incrementProduct(String currentPID){
        Integer quantity;
        for (Product i : items.keySet()) {
            quantity = items.get(i);
            if (currentPID.equals(i.PID)) {
                items.put(i, quantity + 1);
            }
        }
    }

    public void decrementProduct(String currentPID){
        Integer quantity;
        for (Product i : items.keySet()) {
            quantity = items.get(i);
            if (currentPID.equals(i.PID)) {
                if (quantity > 1) {
                    items.put(i, quantity - 1);
                } else {
                    removeProduct(i.PID);
                }
            }
        }
    }

    public String getProductTotal(Product p) {
        double doubleProductTotal = (double) p.price * getQuantity(p);
        double productTotal = doubleProductTotal/100;
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(productTotal));
    }

    /**
     * @return the total value of items in the basket in pence
     */
    public int getTotal() {
        // iterate over the set of products...
        int total = 0;
        for (Product item : items.keySet()) {
            total += (getQuantity(item) * item.price);
        }

        // return the total
        return total;
    }

    /**
     * @return the total value of items in the basket as
     * a pounds and pence String with two decimal places - hence
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
        double doubleTotal = (double) getTotal();
        double total = doubleTotal / 100;
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(total));
    }

}