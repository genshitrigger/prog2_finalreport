package jp.ac.uryukyu.ie.e225716;

public abstract class superLuffy {
    String name;//キャラクター名
    String nickname;//キャラの異名
    int bounty;//海賊のキャラに掛かっている懸賞金
    int hp;//キャラクターの体力
    int mp;//キャラクターが技を発動する際に消費するエネルギー
    int attack;//キャラクターの攻撃力
    int speed;//キャラクターの素早さ、素早さが高い方が先に動く
    int defence;//キャラクターの防御力
    int avoidence;//キャラクターの回避率、回避%の確率で攻撃を避ける
    String specialAttack1;//技1
    String specialAttack2;//技2
    String specialAttack3;//技3
    
    public abstract void showStatus();

    public abstract void normalAttack(Enemy target);
    
    public abstract void doSpecialAttack1(Enemy target);

    public abstract void doSpecialAttack2(Enemy target);

    public abstract void doSpecialAttack3(Enemy target);
}
