package jp.ac.uryukyu.ie.e225716;


public class Luffy extends superLuffy {

    Luffy(String name,String nickname,int bounty,int hp,int mp,int attack,int speed,int defence,String specialAttack1,String specialAttack2,String specialAttack3) {
        this.name = name;
        this.nickname = nickname;
        this.bounty = bounty;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.speed = speed;
        this.defence = defence;
        this.specialAttack1 = specialAttack1;
        this.specialAttack2 = specialAttack2;
        this.specialAttack3 = specialAttack3;

    }
    
    //ステータス開示メソッド
    public void showStatus() {
        System.out.println(this.nickname + this.name + " 懸賞金" + this.bounty + "ベリー" + "\n" + " 体力:" + this.hp + "MP:" + this.mp + " 攻撃力:" + this.attack + " 素早さ:" + this.speed + " 防御力:" + this.defence + "\n" + "技1:" + this.specialAttack1 + "技2:" + this.specialAttack2 + "技3:" + this.specialAttack3);
    }
    //フィールドの値を返すメソッド
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }
    public int getMp() {
        return this.mp;
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
    public String getSpecialAttack1() {
        return this.specialAttack1;
    } 
    public String getSpecialAttack2() {
        return this.specialAttack1;
    }
    public String getSpecialAttack3() {
        return this.specialAttack1;
    } 

    //通常攻撃メソッド
    public void normalAttack(Enemy target) {
        //ダメージ計算
        int damage = (this.attack/2) - (target.defence/4);
        target.hp -= damage;
        System.out.println("ゴムゴムの銃！");
        System.out.println("「" + target + "」に「" + damage + "」ダメージを与えた！");
        //獲得するMPを生成
        int resultMp = (int)(Math.random() * 50) + 100;
        this.mp += resultMp;
        System.out.println("MPを「" + resultMp + "」獲得した");
    }
    //技1(倍率はattackの2倍)
    public void doSpecialAttack1(Enemy target) {
        int damage = ((this.attack) - (target.defence/4));
        target.hp -= damage;
        System.out.println(this.getSpecialAttack1());
        System.out.println("「" + target + "」に「" + damage + "」ダメージを与えた！");
    }
    //技2(倍率はattackの3倍)
    public void doSpecialAttack2(Enemy target) {
        int damage = ((this.attack * 3 / 2) - (target.defence/4));
        target.hp -= damage;
        System.out.println(this.getSpecialAttack2());
        System.out.println("「" + target + "」に「" + damage + "」ダメージを与えた！");
    }
    //技3(倍率はattackの4.5倍)
    public void doSpecialAttack3(Enemy target) {
        int damage = (((this.attack * 9) / 2) / 2) - (target.defence/4);
        target.hp -= damage;
        System.out.println(this.getSpecialAttack3());
        System.out.println("「" + target + "」に「" + damage + "」ダメージを与えた！");
    }

}

