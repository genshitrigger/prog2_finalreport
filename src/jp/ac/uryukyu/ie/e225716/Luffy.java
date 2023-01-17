package jp.ac.uryukyu.ie.e225716;

public class Luffy extends Character {

    Luffy(String name,String nickname,int bounty,int hp,int attack,int speed,int defence,int avoidence) {
        this.name = name;
        this.nickname = nickname;
        this.bounty = bounty;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.defence = defence;
        this.avoidence = avoidence;
    }
    public void showStatus() {
        System.out.println(this.nickname + this.name + " 懸賞金" + this.bounty + "ベリー" + "\n" + " 体力:" + this.hp + " 攻撃力:" + this.attack + " 素早さ:" + this.speed + " 防御力:" + this.defence + " 回避値:" + this.avoidence + "%");
    }
    public void attackMotion() {
        
    }
}

