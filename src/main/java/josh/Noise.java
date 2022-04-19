package josh;

import java.util.Random;
import java.util.HashMap;

public class Noise {
    private int sizex;
    private int sizey;

    private int sps; //samples per *lattice* spacing

    private Vec2[][] field;
    private Random rand;
    private HashMap<Long, Double> values;

    Noise(int sizex, int sizey, int sps) {
        this.sizex = sizex;
        this.sizey = sizey;
        this.sps = sps;
        

        rand = new Random();
        field = new Vec2[sizex / sps + 1][sizey / sps + 1];
        values = new HashMap<Long, Double>();

        //populate field with random vectors
        for(int i = 0; i < field.length; ++i ) {
            for(int j = 0; j < field[i].length; ++j) {
                field[i][j] = new Vec2(rand.nextDouble(-1.0, 1.0), rand.nextDouble(-1.0, 1.0));
            }
        }
    }

    Noise() {
        this(0, 0, 1);
    }

    double at(int x, int y) {
        long key = (((long)x) << 32) & (long)y;
        //so we don't have to recompute the value
        //if(values.containsKey(key)) return values.get(key);

        //displacement of (x,y) from each respective latice corner
        Vec2 disTopLeft, disTopRight, disBotLeft, disBotRight;
        int tempx = x / sps;//will truncate
        int tempy = y / sps;//will truncate 
        disTopLeft  = new Vec2(x -  tempx      * sps, y -  tempy      * sps);
        disTopRight = new Vec2(x - (tempx + 1) * sps, y -  tempy      * sps);
        disBotLeft  = new Vec2(x -  tempx      * sps, y - (tempy + 1) * sps);
        disBotRight = new Vec2(x - (tempx + 1) * sps, y - (tempy + 1) * sps);

        double value = 0;
        value += lerp(Math.abs((double)x/sps - tempx  ), Math.abs((double) y / sps - tempy  )) *  disTopLeft.dotP(field[tempx  ][tempy  ]);
        value += lerp(Math.abs((double)x/sps - tempx-1), Math.abs((double) y / sps - tempy  )) * disTopRight.dotP(field[tempx+1][tempy  ]);
        value += lerp(Math.abs((double)x/sps - tempx  ), Math.abs((double) y / sps - tempy-1)) *  disBotLeft.dotP(field[tempx  ][tempy+1]);
        value += lerp(Math.abs((double)x/sps - tempx-1), Math.abs((double) y / sps - tempy-1)) * disBotRight.dotP(field[tempx+1][tempy+1]);
        
        values.put(key, value);

        while(value < 0) value += 254;
        if(value > 255) value -= 254;
        return value;
    }

    //form of interpolation
    private double lerp(double x, double y) {
        if(x < 0 || x > 1 || y < 0 || y > 1) return 0;
        else return (3 * x * x - 2 * x * x * x) * (3 * y * y - 2 * y * y * y);
    }
    
}
