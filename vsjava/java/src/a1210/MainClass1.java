// 부모 클래스
class StarCraft {
    // 공통 메서드 (오버라이딩 대상)
    public void life() {
        System.out.println("StarCraft life");
    }
}

// 자식 클래스 1: Tank
class Tank extends StarCraft {
    @Override
    public void life() {
        System.out.println("Tank life");
    }

    public void canon() {
        System.out.println("Tank canon");
    }
}

// 자식 클래스 2: Marin
class Marin extends StarCraft {
    @Override
    public void life() {
        System.out.println("Marin life");
    }

    public void run() {
        System.out.println("Marin run");
    }
}

// 자식 클래스 3: Race
class Race extends StarCraft {
    @Override
    public void life() {
        System.out.println("Race life");
    }

    public void fly() {
        System.out.println("Race fly");
    }
}

// 메인 클래스
public class MainClass {
    public static void main(String[] args) {
        // StarCraft 배열 생성 (다형성 활용)
        StarCraft[] starArr = new StarCraft[5];
        starArr[0] = new Marin();
        starArr[1] = new Tank();
        starArr[2] = new Race();
        starArr[3] = new Marin();
        starArr[4] = new Race();

        // 오버라이드된 메서드 호출 (다형성 적용)
        System.out.println("=== life() 호출 ===");
        for (StarCraft unit : starArr) {
            unit.life();
        }

        // 각 클래스의 고유 메서드 호출 (instanceof와 형변환 활용)
        System.out.println("\n=== 각 클래스 고유 메서드 호출 ===");
        for (StarCraft unit : starArr) {
            if (unit instanceof Marin) {
                Marin marin = (Marin) unit;
                marin.run(); // Marin 고유 메서드 호출
            } else if (unit instanceof Tank) {
                Tank tank = (Tank) unit;
                tank.canon(); // Tank 고유 메서드 호출
            } else if (unit instanceof Race) {
                Race race = (Race) unit;
                race.fly(); // Race 고유 메서드 호출
            }
        }
    }
}

