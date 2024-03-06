public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }

//    public void setProductName(String productName){
//        this.productName = productName;
//    }

    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return getPrice();
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void displayProduct(){
        System.out.println("Nama Produk: "+ productName);
        System.out.println("Harga:$ "+price);
    }
}
