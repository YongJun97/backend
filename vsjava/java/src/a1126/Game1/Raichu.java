package a1126.Game1;


// Picachu를 상속
// 키워드 : 자식 클래스 extends 부모클래스()
public class Raichu extends Pikachu{

        public Raichu(){
            super(200,"슈퍼전기");
        }


        public Raichu(int energy, String type){
            super(energy, type,20);
        }
        public Raichu(int energy, String type, int level){
            super(energy, type, level);
        }


        @Override
        public String aAttack() {
            return "백만볼트";
        }


        @Override
        public String bAttack() {
            return "볼트체인";
        }
        
        // public String cAttack(){
        //     if(level >= 40){
        //         return "아이언테일";
        //     }else{
        //         return "사용불가";
        //     }
        // }


        @Override
        public String toString() {
            return super.toString();
        }
        


}