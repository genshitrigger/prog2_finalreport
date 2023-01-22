package jp.ac.uryukyu.ie.e225716;

public abstract class superEnemy {
    String name;//キャラクター名
    String nickname;//キャラの異名
    int bounty;//海賊のキャラに掛かっている懸賞金
    int hp;//キャラクターの体力
    int mp;//キャラクターが技を発動する際に消費するエネルギー
    int attack;//キャラクターの攻撃力
    int speed;//キャラクターの素早さ、素早さが高い方が先に動く
    int defence;//キャラクターの防御力
    int avoidence;//キャラクターの回避率、回避%の確率で攻撃を避ける
    String normalAttack;//通常技(敵の通常技はルフィと違ってキャラによって異なるため)
    String specialAttack1;//技1
    String specialAttack2;//技2
    String specialAttack3;//技3

    public abstract void showStatus();

    public abstract void normalAttack(Luffy target);

    public abstract void doSpecialAttack1(Luffy target);

    public abstract void doSpecialAttack2(Luffy target);

    public abstract void doSpecialAttack3(Luffy target);
}
