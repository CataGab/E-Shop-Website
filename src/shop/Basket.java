package shop;

import java.util.*;

public class Basket {

    HashMap<Product, Integer> items;
    ShopDB db;

    public static void main(String[] args) {//I used some variables to test the basket in the console
        Basket b = new Basket();
        b.addItem("art1");
        System.out.println( b.getTotalString() );
        b.clearBasket();
        System.out.println( b.getTotalString() );
        // I check if adding a null String is going to cause errors
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
    public HashMap<Product, Integer> getItems() {
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

        addItem( db.getProduct( pid ) );

    }

    public void addItem(Product p) {
        // I make sure that I don't add any nulls to the item list adding a new product if the product is not in the basket yet and change the quantity otherwise
        boolean OK=false;
        if (p != null ) {
            if (items.size() == 0) {
                items.put(p, 1);
            } else {
                for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                    if (entry.getKey().PID.equals(p.PID)){
                        OK = true;
                        items.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
                if (OK == false)
                    items.put(p, 1);
            }
        }

    }

    public void decreaseItem(String pid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        decreaseItem( db.getProduct( pid ) );

    }

    public void decreaseItem(Product p) {
        // I decrease the quantity of the product and if the quantity is 1 it will remove the item from the basket
            Iterator<Map.Entry<Product, Integer>> it = items.entrySet().iterator();
            Map.Entry<Product, Integer>entry1=it.next() ;
            if(entry1.getValue()==1) {
                removeItem(p);
            }
            else {

                for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                    if (entry.getValue() != 0)
                        if (entry.getKey().PID.equals(p.PID))
                            items.put(entry.getKey(), entry.getValue() - 1);

                }
            }




    }

    public void removeItem(String pid) {

        // need to look the product name up in the
        // database to allow this kind of item adding...

        removeItem( db.getProduct( pid ) );

    }


        public void removeItem(Product p) {
            // I remove the product from the basket no matter what quantity it has
                            items.remove(p);
         }




    /**
     *
     * @return the total value of items in the basket in pence
     */
    public int getTotal() {         // I make the total of the products from the basket multiplying the quantity of each product adding it to the total
        int x = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()){
            Product p = entry.getKey();
            x += p.price * items.get(p);
        }
        return x;
    }

    /**
     *
     * @return the total value of items in the basket as
     * a pounds and pence String with two decimal places - hence
     * suitable for inclusion as a total in a web page
     */
    public String getTotalString() {
        return String.valueOf((double)getTotal()/100);

    }
}


try{
    Statement statement = conn.createStatement();
    ResultSet rs = statement.executeQuery("Select * from Table where age = '24'");
    while(rs.next()){
        sout("YES" + rs.getInt('age'));
        }
    String delete = "delete * from Table where age = '24'";
    int i= statement.executeUpdate(delete);
    sout(i);
   String update = "update Table"+ "set age='22'" + "where name='iulia'";
   statement.executeUpdate(update);
   String insert = "insert into Table"+"(name, age)"+"values('ionel','23')";
   statement.executeUpdate(insert);
        }

     <CATALOGUE>
<CD name = "BlackStar"  artist = "DavidBowie" year= "2016">
</CATALOGUE>

<?xml version ="1.0"?>
<!DOCTYPE CATALOGUE[
        <!ELEMENT CATALOGUE (CD)>
        <!ELEMENT CD EMPTY>
        <!ATTLIST CD name PCDATA #REQUIRED>
<!ATTLIST CD artist PCDATA #REQUIRED>
<!ATTLIST CD year PCDATA #REQUIRED>
        ]>

public Basket()
        {
        this.items = new HashMap<Products,Integer>();
        }
public int getTotalCost()
        {
        return totalCost;
        }
public void addItem(Product pr, int quant)
        {
        items.add(pr,quant);
        }
        {items.put(pr, items.get(pr)+quant);
        }

function validate(){
    var name = $("#fname"),val();
    var surname =#("#sname").val();
    var regnumber = $("#reg").val();
    if(name==""||surname==""  ||regnumber=="")
        alert("no input");
        }