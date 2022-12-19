package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    /*游戏状态  0未开始、1游戏中、2游戏通关、3游戏失败、4暂停*/
    //游戏默认状态
    static int state =0;

    //定义成员变量
    Image offScreenImage;
    //定义长和宽
    int width = 1180;
    int height =640;

    double random;
    //计数器
    int time=0;

    Bg bg=new Bg();

    //敌方鱼类
    Enamy enamy;

    //敌方BOSS类
    Enamy boss;
    //是否生成BOSS
    boolean isboss=false;

    //我方鱼类
    MyFish myFish=new MyFish();

    public void launch(){
        this.setVisible(true);//显示窗口
        this.setSize(width,height);//调用窗口尺寸大小
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setResizable(false);//窗口大小不可调整
        this.setTitle("小鱼成长历险记"+"  "+"2021100100001");//定义窗口名称
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口，自动停止运行

        //创建鼠标点击事件，点击为1，
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1&&state==0){
                    state=1;
                    repaint();
                }
                if(e.getButton()==1&&(state==2||state==3)){
                    reGame();
                    state=1;
                }
            }

        });

        //键盘移动
        this.addKeyListener(new KeyAdapter() {
            @Override//按压
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                //WASD
                if(e.getKeyCode()==87){
                    GameUtils.UP=true;
                }
                if(e.getKeyCode()==83){
                    GameUtils.DOWN=true;
                }
                if(e.getKeyCode()==65){
                    GameUtils.LEFT=true;
                }
                if(e.getKeyCode()==68){
                    GameUtils.RIGHT=true;
                }
                //监听键盘空格键（32），暂停游戏，在1和4之间切换
                if(e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state=4;
                            GameUtils.drawWord(getGraphics(),"游戏暂停!!!",Color.GREEN,120,350,500);
                            break;
                        case 4:
                            state=1;
                            break;
                    }
                }
            }
            @Override//抬起
            public void keyReleased(KeyEvent e){
                super.keyReleased(e);
                if(e.getKeyCode()==87){
                    GameUtils.UP=false;
                }
                if(e.getKeyCode()==83){
                    GameUtils.DOWN=false;
                }
                if(e.getKeyCode()==65){
                    GameUtils.LEFT=false;
                }
                if(e.getKeyCode()==68){
                    GameUtils.RIGHT=false;
                }
            }
        });

        //创建while循环，40毫秒，调用一次repaint
        while (true){
            repaint();
            time++;
            try {
                Thread.sleep(40);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //创建画笔，绘画背景
    public void paint(Graphics g){
        //加载模式初始化对象
        offScreenImage =createImage(width,height);
        Graphics gImage=offScreenImage.getGraphics();
        bg.paintSelf(gImage,myFish.level);
        switch (state){
            case 0:
                break;
            case 1:
                myFish.paintSelf(gImage);
                logic();
                for(Enamy enamy:GameUtils.EnamyList){
                    enamy.painSelf(gImage);
                }
                //添加BOSS
                if(isboss){
                    boss.x=boss.x+boss.dir*boss.speed;
                    boss.painSelf(gImage);
                    //BOSS出现预警
                    if(boss.x<0){
                        gImage.setColor(Color.red);
                        gImage.fillRect(boss.x,boss.y,2400,boss.height%30);
                    }
                }
                break;
            case 2:
                for(Enamy enamy:GameUtils.EnamyList){
                    enamy.painSelf(gImage);
                }
                if(isboss){
                    boss.painSelf(gImage);
                }
                break;
            case 3:
                myFish.paintSelf(gImage);
                break;
            case 4:
                return;
            default:
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    void logic(){
        //关卡难度
        if(GameUtils.count<5){
            GameUtils.level=0;
            myFish.level=1;
            //积分为15及15以下时，等级为1
        }else if(GameUtils.count<=15){
            GameUtils.level=1;
            //积分为50及50以下时，等级为2
            //鱼类等级为2
        }else if (GameUtils.count<=50){
            GameUtils.level=2;
            myFish.level=2;
            //积分为150及150以下时，等级为3
            //鱼类等级为3
        }else if(GameUtils.count<=150){
            GameUtils.level=3;
            myFish.level=3;
            //积分为300及300以下时，等级为4
            //鱼类等级为3
        }else if (GameUtils.count<=300){
            GameUtils.level=4;
            myFish.level=3;
            //当积分超过300，跳转界面3（胜利）
        }else if (GameUtils.count>300){
            state =3;
        }

        //定义一个随机函数
        random=Math.random();

        //通过难度等级，生成对应的鱼
        switch (GameUtils.level) {
            case 4:
                //90秒时，开始出现BOSS鱼类
                if(time%90==0){
                    if (random>0){
                        boss=new Enamy_Boss();
                        isboss=true;
                    }
                }
            case 3:
            case 2:
                //60秒时，开始出现3号鱼类
                if(time%60==0){
                    if(random>0.5){
                        enamy=new Enamy_3_L();
                    }else {
                        enamy=new Enamy_3_R();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
            case 1:
                //30秒时，开始出现2号鱼类
                if(time%30==0){
                    if(random>0.5){
                        enamy=new Enamy_2_L();
                    }else {
                        enamy=new Enamy_2_R();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
            case 0:
                //10秒时，开始添加1号鱼类
                if (time%10 == 0) {
                    if (random > 0.5) {
                        enamy = new Enamy_1_L();
                    } else {
                        enamy = new Enamy_1_R();
                    }
                    GameUtils.EnamyList.add(enamy);
                }
                break;
            default:
        }
        //鱼类移动方向
        for(Enamy enamy:GameUtils.EnamyList){
            enamy.x=enamy.x+enamy.dir*enamy.speed;

            if(isboss){
                //如果BOSS矩形和敌方鱼类矩形碰撞，敌方鱼类扭转到制定位置
                if(boss.getRec().intersects(enamy.getRec())){
                    enamy.x=-200;
                    enamy.y=-200;
                }
                //如果BOSS矩形和玩家鱼矩形碰撞，跳转到界面2（失败）
                if(boss.getRec().intersects(myFish.getRec())){
                    state=2;
                }
            }

            //我方鱼与敌方鱼碰撞检测
            if(myFish.getRec().intersects(enamy.getRec())){
                //如果我的鱼类等级，高于鱼类类型，吃掉鱼，获得积分，地方鱼类重新出现在指定位置
                if(myFish.level>=enamy.type){
                    System.out.println("吃啦");
                    System.out.println("获得"+GameUtils.count+"积分");
                    enamy.x=-200;
                    enamy.y=-200;
                    GameUtils.count=GameUtils.count+enamy.count;
                }else {
                    //不然，跳转到界面2（失败）
                    state=2;
                }
            }
        }
    }

    //重新开始
    void reGame(){
        GameUtils.EnamyList.clear();
        time=0;
        myFish.level=1;
        GameUtils.count=0;
        myFish.x=700;
        myFish.y=500;
        myFish.width=50;
        myFish.height=50;
        boss=null;
        isboss=false;
    }

    //主方法
    public static void main(String[] args){
        GameWin gameWin =new GameWin();
        gameWin.launch();
    }

}
