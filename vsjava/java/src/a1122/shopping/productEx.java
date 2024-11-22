package a1122.shopping;

public class productEx {
    public static void main(String[] args) {
        Product laptop = new Product("노트북", 1200000, 10);
        Product desktop = new Product("데스크톱", -1000000, -5);
        System.out.println();
        // System.out.println("제품명 : "+ laptop.getName() );
        // System.out.println("가격 : "+ laptop.getPrice() );
        // System.out.println("제고 : "+ laptop.getStock() );

        System.out.println(laptop.toStr());
        System.out.println(desktop.toDes());
        
        // 가격 수정
        //laptop.setPrice(-500); //세터로 가격수정
        //System.out.println("수정된 가격: "+ laptop.getPrice());

        // 재고 추가 매서드
        laptop.addStock(6);

        // 상품판매
        laptop.sellProduct(8);


    }
}
