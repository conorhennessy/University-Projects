package shop;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Basket {

    Collection<Product> items;
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
        items = new ArrayList<Product>();
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
    public Collection<Product> getItems() {
        return items;
    }

    /**
     * empty the basket - the basket should contain no items after calling this method
     */
    public void clearBasket() {
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

        addItem( db.getProduct( pid ) );

    }

    public void addItem(Product p) {
        // ensure that we don't add any nulls to the item list
        if (p != null ) {
            items.add( p );
        }
    }

    /**
     *
     * @return the total value of items in the basket in pence
     */
    public int getTotal() {
        // iterate over the set of products...

        // return the total
        return 100;
    }

    /**
     *
     * @return the total value of items in the basket as
     * a pounds and pence String with two decimal places - hence
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
		return "";
    }
}
