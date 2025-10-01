import greenfoot.*;

public class DancerGirl extends Actor {
    private GreenfootImage[] frames = new GreenfootImage[8];
    private int frameIndex = 0;
    private int frameSpeed = 5;
    private int frameCounter = 0;

    public DancerGirl(String folderName, double scale) {
        for (int i = 0; i < frames.length; i++) {
            GreenfootImage img = new GreenfootImage(folderName + "/dance_" + i + ".png");
            
            if (scale != 1.0) {
                int w = (int)(img.getWidth() * scale);
                int h = (int)(img.getHeight() * scale);
                img.scale(w, h);
            }

            frames[i] = img;
        }

        setImage(frames[0]);
    }

    public void act() {
        frameCounter++;
        if (frameCounter >= frameSpeed) {
            frameCounter = 0;
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
        }
    }
}
