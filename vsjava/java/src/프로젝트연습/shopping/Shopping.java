package 프로젝트연습.shopping;

public class Shopping {
    private String name;
    private String price;
    private int star;
    private int review;

    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public int getStar() {
        return star;
    }


    public void setStar(int star) {
        this.star = star;
    }


    public int getReview() {
        return review;
    }


    public void setReview(int review) {
        this.review = review;
    }


    public Shopping(String name, String price, int star, int review) {
        this.name = name;
        this.price = price;
        this.star = star;
        this.review = review;
    }


    @Override
    public String toString() {
        return ""+ name + "\n" + price + "\n" + star + "\n" + review + "";
    }
}
