package a1122.shopping;

public class Product {
    private String name;
    private double price;
    private int stock;



    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            this.price = 0;
        }else{
        this.price = price;
        }
    }

    public int getStock() {
        
        return stock;
        
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Product(String name, double price, int stock) {
        this.name = name;
        setPrice(price);
        setStock(stock);
    }

    public String toStr() {
        return String.format("제품명 : %s , 가격 : %.2f, 재고: %d,",name,price,stock);
    }

    public void addStock(int i) {
        if(i<0){
            System.out.println("재고 추가 실패: 음수 값은 허용되지 않습니다.");
        }else{
            stock += i;
            System.out.println(i + "개의 재고가 추가 되었습니다.");
        }
    }

    public void sellProduct(int i) {
        if(i > stock){ // 재고보다 판매수량이 많으면
            System.out.println("판매 실패 : 재고가 부족해요");
        }else if(i <= 0){ // 판매수량은 음수 일 때
            System.out.println("판매 실패 : 판매 수량은 양수여야 합니다.");
        }else{
            stock -= i;
            System.out.println(i + "개의 상품이 판매되었습니다.");
            System.out.println("수량이 "+ stock + "개 남았습니다." );
        }
    }

    public String toDes() {
        return String.format("제품명 : %s , 가격 : %.2f, 재고: %d,",name,price,stock);
    }

    




}

// 온라인 쇼핑몰 시스템에 상품을 관리하는 Product 클래스를 만드세요. 이 클래스는 다음의 요구사항을 만족해야 합니다:

// 클래스의 필드

// String name: 상품의 이름 (예: "노트북").
// double price: 상품의 가격 (양수만 가능, 음수일 경우 0으로 설정).
// int stock: 상품의 재고 수량 (양수만 가능, 음수일 경우 0으로 설정).
// 생성자

// 모든 필드를 초기화하는 생성자를 작성하세요.
// Getter와 Setter

// 각 필드에 대한 getter와 setter를 작성하세요.
// price와 stock의 setter는 음수 값을 허용하지 않도록 조건을 추가하세요.
// 추가 메서드

// void addStock(int amount): 재고를 추가하는 메서드. amount가 음수일 경우 "재고 추가 실패" 메시지를 출력하세요.
// void sellProduct(int amount): 상품을 판매하는 메서드. 판매 수량이 재고보다 많을 경우 "재고 부족" 메시지를 출력하세요. 정상 판매 시 재고를 줄이세요.
// 메인 클래스에서 테스트

// 상품 객체를 생성하고, 다양한 조건에서 getter와 setter, 추가 메서드를 호출하여 동작을 확인하세요.