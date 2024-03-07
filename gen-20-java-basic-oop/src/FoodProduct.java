public class FoodProduct extends Product{
    public FoodProduct(String productName, double price){
        super(productName,price);
    }

    @Override
    public void displayProduct(){
        super.displayProduct();
        ProductCategory category = new Food();
        System.out.println("Kategori: "+category.getNameProductCategory());
    }

    @Override
    public double getPrice(){
        if(super.getPrice()>5) {
            return super.getPrice() * 0.7;
        } else{
            return super.getPrice();
        }
    }
}
