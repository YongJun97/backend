package a1206.movie2;

import java.time.Instant;

public class Movie {
    private long id;
    private String title;
    private String gen; // 장르

    
    public String getTitle() {
        return title;
    }
    public String getGen() {
        return gen;
    }
    
    public Movie(String title, String gen) {
        this.id = Instant.now().getEpochSecond();
        this.title = title;
        this.gen = gen;
    }

    public Movie(long id, String title, String gen) {
        this.id = id;
        this.title = title;
        this.gen = gen;
    }


    @Override
    public String toString() {
        return String.format("[%d] : %s(%s)",id, title, gen );
    }

}
