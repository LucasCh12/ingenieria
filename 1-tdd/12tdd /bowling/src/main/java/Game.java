import java.util.ArrayList;

public class Game {

    private ArrayList<Integer> frames;

    public Game(){
        frames = new ArrayList<>();
    }
    
    public void roll(int pins){

        if(pins < 0 || pins > 10) throw new IllegalArgumentException("Numero de pinos negativos");
        frames.add(pins);
    }

    public boolean strike(int x){
        return frames.get(x) == 10;
        
    }

    public boolean spare(int x){
        return frames.get(x) + frames.get(x +1) == 10;
    }

    public int score(){
        int score = 0;
        int i = 0;
        for(int frame = 0; frame < 10; frame++){
            if (strike(i)) {
                score += 10 + frames.get(i+1) + frames.get(i+2);
                i += 1;
            } 
            else if (spare(i)) {
                score += 10 + frames.get(i+2);
                i += 2;
            } 
            else {
                score += frames.get(i) + frames.get(i+1);
                i += 2;
            }
        }

        return score;
    }

}
