public class ToysProduct extends Product{
    public ToysProduct(String productName, double price){
        super(productName, price);

    }

    @Override
    public void displayProduct(){
       super.displayProduct();
       ProductCategory category = new Toys();
       System.out.println("Kategori: "+category.getNameProductCategory());
    }
    @Override
    public double getPrice(){
        return super.getPrice() * 2;
    }
}
