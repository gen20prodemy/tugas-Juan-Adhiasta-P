public abstract class ProductCategory {
    private String nameProductCategory;

    public ProductCategory(String nameProductCategory){
        this.nameProductCategory = nameProductCategory;
    }
    public String getNameProductCategory(){
        return nameProductCategory;
    }
    public void setNameProductCategory(String nameProductCategory){
        this.nameProductCategory = nameProductCategory;
    }
    public abstract String categoryDesc();
}
