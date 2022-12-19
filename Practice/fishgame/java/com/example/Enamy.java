package com.example;

import java.awt.*;

public class Enamy {
    //定义图片
    Image img;
    //定义物体坐标
    int x;
    int y;
    int width;
    int height;
    //移动速度
    int speed;
    //方向
    int dir = 1;
    //类型
    int type;
    //分值
    int count;
    //绘制自身的方法
    public void painSelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    //获取自身矩形用于碰撞检测
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}
//敌方鱼左类
class Enamy_1_L extends Enamy{
    Enamy_1_L(){
        this.x=-57;
        this.y=(int)(Math.random()*700+100);
        this.width=57;
        this.height=30;
        this.speed=5;
        this.count=1;
        this.type=1;
        this.img=GameUtils.enemyl_img;
    }
}
class Enamy_1_R extends Enamy_1_L{
    Enamy_1_R(){
        this.x=1400;
        dir=-1;
        this.img=GameUtils.enemyr_img;
    }
}
//定义第二类鱼
class Enamy_2_L extends Enamy{
    Enamy_2_L(){
        this.x=-100;
        this.y=(int)(Math.random()*700+100);
        this.width=69;
        this.height=37;
        this.speed=7;
        this.count=2;
        this.type=2;
        this.img=GameUtils.enemyl_2img;
    }
}
class Enamy_2_R extends Enamy_2_L{
    Enamy_2_R(){
        this.x=1400;
        dir=-1;
        this.img=GameUtils.enemyr_2img;
    }
}
//定义第三类鱼
class Enamy_3_L extends Enamy{
    Enamy_3_L(){
        this.x=-300;
        this.y=(int)(Math.random()*700+100);
        this.width=64;
        this.height=39;
        this.speed=13;
        this.count=4;
        this.type=4;
        this.img=GameUtils.enemyl_3img;
    }
    @Override//因为鱼体积过大，从新定义碰撞矩形
    public Rectangle getRec() {
        return new Rectangle(x+40,y+30,width+80,height+60);
    }
}
class Enamy_3_R extends Enamy_3_L{
    Enamy_3_R(){
        this.x=1400;
        dir=-1;
        this.img=GameUtils.enemyr_3img;
    }
}

//定义BOSS类
class Enamy_Boss extends Enamy{
    Enamy_Boss(){
        this.x=-1000;
        this.y=(int)(Math.random()*700+100);
        this.width=300;
        this.height=300;
        this.speed=20;
        this.type=10;
        this.count=0;
        this.img=GameUtils.bossimg;
    }

}
