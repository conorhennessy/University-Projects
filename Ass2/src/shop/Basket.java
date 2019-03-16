package shop;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    Map<Product, Integer> items;
    ShopDB db;

    public static void main(String[] args) {
        Basket b = new Basket();
        b.addItem("art1");
        System.out.println( b.getTotalString() );
        b.clearBasket();
        System.out.println( b.getTotalString() );
        // check that adding a null String causes no problems
        String pid = null;
        b.addItem( pid );
        System.out.println( b.getTotalString() );
    }

    public Basket() {
        db = ShopDB.getSingleton();
        items = new HashMap<Product, Integer>();
    }

    /**
     *
     * @return Collection of Product items that are stored in the basket
     *
     * Each item is a product object - need to be clear about that...
     *
     * When we come to list the Basket contents, it will be much more
     * convenient to have all the product details as items in this way
     * in order to calculate that product totals etc.
     *
     */
    public Map<Product, Integer> getItems() {
        return items;
    }

    /**
     * empty the basket - the basket should contain no items after calling this method
     */
    public void clearBasket() {
        items.clear();
    }

    /**
     *
     *  Adds an item specified by its product code to the shopping basket
     *
     * @param pid - the product code
     */
    public void addItem(String pid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        Product p = db.getProduct( pid );

        // ensure that we don't add any nulls to the item list
        if (p != null ) {
            //if the item is already in map increment quantity
            if (items.containsKey(p.PID)){
                items.put(p, items.get(p) + 1);
            } else {
                items.put(p, 1);
            }
        }
    }

    public Integer getQuantity(Product p){
        return items.get(p);
    }

    /**
     *
     * @return the total value of items in the basket in pence
     */
    public int getTotal() {
        // iterate over the set of products...
        int total = 0;
        for (Product item : items.keySet()){
            total += item.price;
        }

        // return the total
        return total;
    }

    /**
     *
     * @return the total value of items in the basket as
     * a pounds and pence String with two decimal places - hence
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
        double doubleTotal = (double) getTotal();
        double total = doubleTotal/100;
        DecimalFormat df = new DecimalFormat("#0.00");
        return String.valueOf(df.format(total));
    }

}