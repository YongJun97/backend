package mini.chelsea;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players = new ArrayList<>();
    private int nextId = 1;

    // 선수 목록 보기
    public void listPlayers() {
        if (players.isEmpty()) {
            System.out.println("선수가 없습니다.");
        } else {
            for (Player player : players) {
                System.out.println(player);
            }
        }
    }

    // 선수 스텟 보기
    public void showPlayerStats() {
        for (Player player : players) {
            System.out.println("ID: " + player.getId() + " 이름: " + player.getName() + " 슛: " + player.getShoot() 
                               + " 슛 정확도: " + player.getShootAccuracy() 
                               + " 패스: " + player.getPass() + " 패스 정확도: " + player.getPassAccuracy());
        }
    }

    // 선수 입력
    public void addPlayer(int number, String position, String name, int shoot, int shootAccuracy, int pass, int passAccuracy) {
        Player player = new Player(nextId, number, position, name, shoot, shootAccuracy, pass, passAccuracy);
        players.add(player);
        nextId++;
        System.out.println("선수 추가: " + player);
    }

    // 선수 삭제
    public void removePlayer(int id) {
        Player toRemove = null;
        for (Player player : players) {
            if (player.getId() == id) {
                toRemove = player;
                break;
            }
        }
        if (toRemove != null) {
            players.remove(toRemove);
            System.out.println("선수 삭제: " + toRemove);
        } else {
            System.out.println("선수를 찾을 수 없습니다.");
        }
    }
}

