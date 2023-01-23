package jp.ac.uryukyu.ie.e225716;


public class Enemy {
    String name;//キャラクター名
    String nickname;//キャラの異名
    int bounty;//海賊のキャラに掛かっている懸賞金
    int hp;//キャラクターの体力
    int attack;//キャラクターの攻撃力
    int speed;//キャラクターの素早さ、素早さが高い方が先に動く
    int defence;//キャラクターの防御力
    String normalAttack;//通常技(敵の通常技はルフィと違ってキャラによって異なるため)
    String specialAttack1;//技1
    String specialAttack2;//技2
    String specialAttack3;//技3

    Enemy(String name,String nickname,int bounty,int hp,int attack,int speed,int defence,String normalAttack,String specialAttack1,String specialAttack2,String specialAttack3) {
        this.name = name;
        this.nickname = nickname;
        this.bounty = bounty;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.defence = defence;
        this.normalAttack = normalAttack;
        this.specialAttack1 = specialAttack1;
        this.specialAttack2 = specialAttack2;
        this.specialAttack3 = specialAttack3;

    }
    
    //ステータス開示メソッド
    public void showStatus() {
        System.out.println(this.nickname + this.name + " 懸賞金" + this.bounty + "万ベリー" + "\n" + " 体力:" + this.hp + " 攻撃力:" + this.attack + " 素早さ:" + this.speed + " 防御力:" + this.defence + "\n" + "通常攻撃:" + this.getNormalAttack() + "技1:" + this.specialAttack1 + "技2:" + this.specialAttack2 + "技3:" + this.specialAttack3);
    }
    //フィールドの値を返すメソッド
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getSpeed() {
        return this.speed;
    }
    public int getDefence() {
        return this.defence;
    }
    public String getNormalAttack() {
        return this.normalAttack;
    }
    public String getSpecialAttack1() {
        return this.specialAttack1;
    } 
    public String getSpecialAttack2() {
        return this.specialAttack2;
    }
    public String getSpecialAttack3() {
        return this.specialAttack3;
    } 

    //通常攻撃メソッド
    public void normalAttack(Luffy target) {
        //ダメージ計算
        int damage = ((this.attack / 2) - (target.defence / 4));
        target.hp -= damage;
        System.out.println(this.getNormalAttack());
        System.out.println("「" + target.getName() + "」に「" + damage + "」ダメージを与えた！");
    }

    //技1
    public void doSpecialAttack1(Luffy target) {
        int damage = ((this.attack) - (target.defence/4));
        target.hp -= damage;
        System.out.println(this.getSpecialAttack1());
        System.out.println("「" + target.getName() + "」に「" + damage + "」ダメージを与えた！");
    }
    //技2
    public void doSpecialAttack2(Luffy target) {
        int damage = ((this.attack * 3 / 2) - (target.defence/4));
        target.hp -= damage;
        System.out.println(this.getSpecialAttack2());
        System.out.println("「" + target.getName() + "」に「" + damage + "」ダメージを与えた！");
    }
    //技3
    public void doSpecialAttack3(Luffy target) {
        int damage = (((this.attack * 9) / 2) / 2) - (target.defence/4);
        target.hp -= damage;
        System.out.println(this.getSpecialAttack3());
        System.out.println("「" + target.getName() + "」に「" + damage + "」ダメージを与えた！");
    }
}
