package jp.ac.uryukyu.ie.e225716;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        //ルフィのインスタンス生成
        Luffy Monkey_D_Luffy = new Luffy("モンキー・D・ルフィ","「麦わら」",0,1500,0,200,150,100,"「ゴムゴムの弾丸!」","「ゴムゴムの銃乱打!」","「ゴムゴムのバズーカ!」");
        System.out.println("このゲームはONEPIECEの名バトルを体験できるゲームです。" + "\n" + "※体験版の為、レベルアップ要素はまだ導入しておりません。バトルごとにルフィのステータスをこちらで決めています。また、敵の行動も一定となっています。あらかじめご了承ください。" + "\n" + "チュートリアル戦「ルフィvsバギー」を行いますか？");
        //分岐
        Scanner scan1 = new Scanner(System.in);
        System.out.println("行う場合は「1」をチュートリアル戦をスキップする場合は「2」を入力してください。");
        int num = scan1.nextInt();
        System.out.println("");
        //チュートリアル・バギー戦
        if (num == 1){
            Enemy Buggy = new Enemy("バギー","「道化」",1500,1200,150,100,80,"「バラバラ砲」","「バラバラせんべい!」","「バラバラフェスティバル!」","「特製バギー玉！」");
            System.out.println("ルフィ「ししし、海図は手に入れたしあとはお前をブッ飛ばすだけだ。」" + "\n" + "バギー「麦わらぁ！偉大なる航路の海図を返しやがれ！よくも俺に赤っ恥をかかせやがって、ハデに死ね！・・・誰が赤っ鼻だクラァ!💢」" + "\n" + "バトルスタート！" + "\n" + "※文章が長いので区切っています。読み終わったらEnterを押してください。続きが表示されます。");
            Scanner enter1 = new Scanner(System.in);
            enter1.nextLine();
            //ルフィと敵のステータス開示
            Monkey_D_Luffy.showStatus();
            Buggy.showStatus();
            Scanner enter2 = new Scanner(System.in);
            enter2.nextLine();
            System.out.println("");
            System.out.println("このゲームではターン制のバトルです。お互い素早さが早い方から順に１回ずつ行動します。");
            
            //バトル開始
            while (Monkey_D_Luffy.getHp() > 0 || Buggy.getHp() > 0) {
                int BuggyActCount = 0;
                int BuggySpecialCount = 0;
                //素早さ比較（ルフィの方が素早さの値が高かった場合）
                if (Monkey_D_Luffy.getSpeed() > Buggy.getSpeed()) {
                    System.out.println(Monkey_D_Luffy.getName()  + "のターンです。");
                    Scanner enter3 = new Scanner(System.in);
                    enter3.nextLine();
                    System.out.println("");
                    System.out.println("行動には攻撃、技があります。" + "\n" + "攻撃:通常攻撃を行う" + "\n" + "{ダメージ計算は(attack/2) - (defence/4)}" + "\n" + "そして技発動に必要なMPを100~150のうちランダムで獲得する。" + "\n" + "技:必要な分のMPを消費して技を発動する。技の発動に必要なMPは「100」,「200」,「300」。※EnemyにはMPは存在しません。");
                
                    //ルフィの行動
                    Scanner enter4 = new Scanner(System.in);
                    enter4.nextLine();
                    System.out.println("");
                    System.out.println("行動を選択してください");
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy.getHp() + " 現在のMP:" + Monkey_D_Luffy.getMp());
                    int num2 = scan2.nextInt();
                    if (num2 == 1) {
                        //通常攻撃
                        Monkey_D_Luffy.normalAttack(Buggy);
                    } else if(num2 == 2) {
                        //技
                        System.out.println("技1:" + Monkey_D_Luffy.getSpecialAttack1() + "技2:" + Monkey_D_Luffy.getSpecialAttack2() + "技3:" + Monkey_D_Luffy.getSpecialAttack3());
                        Scanner scan3 = new Scanner(System.in);
                        System.out.println("どの技を発動しますか？「1」「2」「3」の内から選んでください。");
                        int num3 = scan3.nextInt();
                        if (num3 == 1) {
                            if (Monkey_D_Luffy.getMp() >= 100) {
                                Monkey_D_Luffy.doSpecialAttack1(Buggy);
                            } else if (Monkey_D_Luffy.getMp() < 100) {
                                System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                                System.exit(0);
                            }
                        } else if(num3 == 2) {
                            if (Monkey_D_Luffy.getMp() >= 200) {
                                Monkey_D_Luffy.doSpecialAttack2(Buggy);
                            } else if (Monkey_D_Luffy.getMp() < 200) {
                                System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                                System.exit(0);
                            }
                        } else if(num3 == 3) {
                            if (Monkey_D_Luffy.getMp() >= 300) {
                                Monkey_D_Luffy.doSpecialAttack3(Buggy);
                            } else if (Monkey_D_Luffy.getMp() < 300) {
                                System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                                System.exit(0);
                            }
                        }
                    }
                    //Enemyの行動
                    if (BuggyActCount % 3 == 0) {
                        if (BuggySpecialCount == 0 || BuggySpecialCount % 3 == 0) {
                            Buggy.doSpecialAttack1(Monkey_D_Luffy);
                            BuggyActCount += 1;
                            BuggySpecialCount += 1;
                        } else if (BuggySpecialCount == 1 || BuggySpecialCount % 3 == 1) {
                            Buggy.doSpecialAttack2(Monkey_D_Luffy);
                            BuggyActCount += 1;
                            BuggySpecialCount += 1;
                        } else if (BuggySpecialCount == 2 || BuggySpecialCount % 3 == 2) {
                            Buggy.doSpecialAttack3(Monkey_D_Luffy);
                            BuggyActCount += 1;
                            BuggySpecialCount += 1;
                        }
                    } else {
                        Buggy.normalAttack(Monkey_D_Luffy);
                        BuggyActCount += 1;
                    }

                //素早さ比較（敵の方が素早さが早かった場合）
                } else if (Buggy.getSpeed() > Monkey_D_Luffy.getSpeed()) {
                    System.out.println(Buggy.getName() + "のターンです");
                    //敵の行動
                }
            }
            //バトルのリザルト
            if (Monkey_D_Luffy.getHp() <= 0){
                System.out.println("バトル終了！" + "\n" + "勝者は「" + Monkey_D_Luffy + "」");
            } else if(Buggy.getHp() <= 0) {
                System.out.println("バトル終了！" + "\n" + "勝者は「" + Buggy.getName() + "」");
                }
            System.out.println("次のバトルに進みますか？");
            Scanner scan4 = new Scanner(System.in);
            System.out.println("1:次のバトルへ 2:終わる");
            int num4 = scan4.nextInt();
            if (num4 == 1) {
            
            } else if (num4 == 0) {
                System.exit(0);
            }
            

        }

    }
}
