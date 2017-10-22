package com.metalsphere.screens;





import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.metalsphere.Game;
import com.metalsphere.libs.Reference;
import com.metalsphere.utils.Button;

public class Pause {

    public Button goon, quit;
    private int width = 300;
    private int height = 50;
    private int init_size = 33;
    private boolean musicPlayed = false;

    public Pause() {

        int fillerY = 600;
        goon = new Button(Reference.CENTER_X -100, fillerY-50, width, height).setText("CONTINUE");
        quit = new Button(Reference.CENTER_X -100 , fillerY += 60-50, width, height).setText("QUIT");

    }

    public void drawButton(Graphics g, Rectangle rect, String text, int offsetX, int size) {

        Font Earth = new Font("Earth 2073.ttf", Font.BOLD, size);
        g.setFont(Earth);

        g.drawString(text, rect.x + offsetX, rect.y + 38);
    }


    public void render(Graphics g) {

        g.setColor(new Color(0, 0, 0));
        g.drawRect(0, 0, Game.WIDTH, Game.WIDTH);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Earth 2073.ttf",Font.BOLD, 100));
        g.drawString("PAUSE", Reference.CENTER_X-100, Reference.CENTER_Y-200);

        if (musicPlayed == false) {
            musicPlayed = true;
        }


        Font Earth = new Font("Percy Pixel", Font.BOLD, init_size);
        g.setFont(Earth);
        goon.drawButton(g, 65);
        quit.drawButton(g, 95);

    }

}