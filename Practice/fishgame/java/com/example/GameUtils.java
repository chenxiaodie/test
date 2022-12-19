package com.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //方向控制
    static boolean UP=false;
    static boolean DOWN=false;
    static boolean LEFT=false;
    static boolean RIGHT=false;

    //分数
    static int count=0;

    //关卡等级
    static int level=0;

    //敌方鱼类集合
    public static List<Enamy>EnamyList=new ArrayList<>();

    //定义固定的静态图片
    public static Image bgimg=Toolkit.getDefaultToolkit().createImage("img/sea.jpg");

    //敌方鱼类
    public static Image enemyl_img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish1_l.jpg");
    public static Image enemyr_img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish1_r.jpg");
    public static Image enemyl_2img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish2_l.jpg");
    public static Image enemyr_2img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish2_r.jpg");
    public static Image enemyl_3img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish3_l.jpg");
    public static Image enemyr_3img=Toolkit.getDefaultToolkit().createImage("img/enemyfish/fish3_r.jpg");

    public static Image bossimg=Toolkit.getDefaultToolkit().createImage("img/enemyfish/boss.jpg");

    //我方鱼
    public static Image MyFishimg_L=Toolkit.getDefaultToolkit().createImage("img/myfish/myfish_left.jpg");
    public static Image MyFishimg_R=Toolkit.getDefaultToolkit().createImage("img/myfish/myfish_right.jpg");

    //绘制文字的工具类
    public static void drawWord(Graphics g, String str, Color color, int size, int x, int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
