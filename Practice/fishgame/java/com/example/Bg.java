package com.example;

import java.awt.*;

public class Bg {
    void paintSelf(Graphics g, int fishlevel){
        g.drawImage(GameUtils.bgimg,0,0,null);
        switch (GameWin.state){
            case 0:
                GameUtils.drawWord(g,"开始",Color.red,80,450,350);
                break;
            case 1:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.ORANGE,30,200,70);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.ORANGE,30,600,70);
                GameUtils.drawWord(g,"等级"+fishlevel,Color.ORANGE,30,1000,70);
                break;
            case 2:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.ORANGE,30,200,70);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.ORANGE,30,600,70);
                GameUtils.drawWord(g,"等级"+fishlevel,Color.ORANGE,30,1000,70);
                GameUtils.drawWord(g,"失败",Color.red,200,350,350);
                break;
            case 3:
                GameUtils.drawWord(g,"积分"+GameUtils.count,Color.ORANGE,30,200,70);
                GameUtils.drawWord(g,"难度"+GameUtils.level,Color.ORANGE,30,600,70);
                GameUtils.drawWord(g,"等级"+fishlevel,Color.ORANGE,30,1000,70);
                GameUtils.drawWord(g,"胜利",Color.red,150,700,500);
                break;
            case 4:
                break;
            default:
        }
    }

}
