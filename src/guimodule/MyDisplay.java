package guimodule;

import processing.core.PApplet;

/**
 * Created by Damian on 4/9/2017.
 */
public class MyDisplay extends PApplet {
    public void setup(){
        size(400,400);
        background(0,0,0);
    }

    public void draw(){
        fill(255,255,0);
        ellipse(width/2, height/2, 2*width/3, 2*height/3);
        fill(0,0,0);
        ellipse(width/3,2*height/5, 50,70);
        fill(0,0,0);
        ellipse(2*width/3,2*height/5, 50,70);
        arc(width/2,3*height/5,width/3,height/3,0,PI);

    }
}
