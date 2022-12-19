package com.example;

import java.awt.*;

public class MyFish {
    //图片
    Image img=GameUtils.MyFishimg_L;
    //坐标
    int x=700;
    int y=500;
    int width=94;
    int height=57;
    int speed=20;
    int level=1;

    //对我方鱼类的控制
    void logic(){
        if(GameUtils.UP){
            y=y-speed;
        }
        if(GameUtils.DOWN){
            y=y+speed;
        }
        if(GameUtils.LEFT){
            x=x-speed;
            img=GameUtils.MyFishimg_L;
        }
        if(GameUtils.RIGHT){
            x=x+speed;
            img=GameUtils.MyFishimg_R;
        }
    }
    //绘制自身的方法
    public void paintSelf(Graphics g){
        logic();
        g.drawImage(img,x,y,width+GameUtils.count,height+GameUtils.count,null);
    }
    //获取自身矩形，用于碰撞检测
    public Rectangle getRec(){
        return new Rectangle(x,y,width+GameUtils.count,height+GameUtils.count);
    }

}
