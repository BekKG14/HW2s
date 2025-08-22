import article.Article;
import basket.ProductBasket;
import product.DiscountProduct;
import product.FixPriceProduct;
import product.Product;
import product.SimpleProduct;
import search.Searchable;


import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Product cucumber = new SimpleProduct("Cucumner", 110);
        Product vodka = new SimpleProduct("Vodka", 101);
        Product pivo = new SimpleProduct("Pivo", 80);
        Product pivoCheep = new DiscountProduct("Pivo Light", 29, 12);
        Product chlor = new FixPriceProduct("Chlor", 2313);
        Product cheetos = new DiscountProduct("Cheetos",109, 10 );
        Product maltesers = new FixPriceProduct("Maltesers", 129);
        Product coupon = new SimpleProduct("Netflix coupon", 499);



        Article alcohol = new Article("Vodka premium!", "Is premium vodka good for your ? No vodka is bad anyway");
        Article vegetables = new Article("Cucmber, or not cucumber? That is the question!", "Cucumber is good !");
        Article discount = new Article("Discount is for poor?", "No it's not, now discount products are cheetos and Pivo Light");

        System.out.println(pivoCheep);
        System.out.println(cucumber);


        System.out.println("Корзина 1");
        ProductBasket<Product> basket = new ProductBasket<>();
        basket.addProduct(pivoCheep);
        basket.addProduct(pivo);
        basket.addProduct(pivo);
        basket.addProduct(vodka);
        basket.addProduct(chlor);

        basket.printAllProducts();
        basket.checkProduct(pivo);


        System.out.println("Корзина 2");
        ProductBasket<Product> basket2 = new ProductBasket<>();

        basket2.addProduct(pivo);
        basket2.addProduct(vodka);
        basket2.addProduct(pivo);
        basket2.checkProduct(vodka);
        basket2.addProduct(pivoCheep);
        basket2.printAllProducts();

        System.out.println("Корзина 3");
        ProductBasket<Product> basket3 = new ProductBasket<>();
        basket3.addProduct(coupon);
        basket3.addProduct(maltesers);
        basket3.addProduct(cheetos);
        basket3.addProduct(pivoCheep);
        basket3.printAllProducts();
        basket3.checkProduct(pivo);
        basket3.clearBasket();


        System.out.println(basket.isSpecialCount());


        SearchEngine<Searchable> searchBase = new SearchEngine<>();

        searchBase.add(cucumber);
        searchBase.add(pivo);
        searchBase.add(pivoCheep);
        searchBase.add(vodka);
        searchBase.add(chlor);
        searchBase.add(maltesers);
        searchBase.add(cheetos);
        searchBase.add(coupon);
        searchBase.add(alcohol);
        searchBase.add(vegetables);
        searchBase.add(discount);


        System.out.println(searchBase.search("Pivo"));
        System.out.println(searchBase.search("Vodka"));


        System.out.println("ответ на задание 4");

        try{
            System.out.println(searchBase.searchBestResult("Pivo"));
        } catch (BestResultNotFound e) {
            System.out.println("Нет подходящих по запросу");
        }


        try {
            Product lolipop = new DiscountProduct("Lolipop", -1, 12);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный номер");
        }

        try {
            Product potato = new SimpleProduct(null, -11);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверные данные");
        }
    }

}