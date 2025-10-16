package gameLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorSchemaBlackWhiteGreenRed implements Colors{

    @Override
    public String colorForLiveCell(){
        List<String> schemaLive= new ArrayList<>();
        Random random = new Random();
        schemaLive.add("White");
        schemaLive.add("Green");
        int randomIndex = random.nextInt(schemaLive.size());
        String randomColor = schemaLive.get(randomIndex);
        return randomColor;
    }

    @Override
    public String colorForDeathCell(){
        List<String> schemaDeath= new ArrayList<>();
        Random random = new Random();
        schemaDeath.add("Black");
        schemaDeath.add("Red");
        int randomIndex = random.nextInt(schemaDeath.size());
        String randomColor = schemaDeath.get(randomIndex);
        return randomColor;
    }

    public static void main(String[] args) {
        ColorSchemaBlackWhiteGreenRed c = new ColorSchemaBlackWhiteGreenRed();
        System.out.println(c.colorForDeathCell());
    }
    
}
