package jp.ac.uryukyu.ie.e225716;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //ルフィのインスタンス生成
        Luffy Monkey_D_Luffy = new Luffy("モンキー・D・ルフィ","ゴムゴムの実のゴム人間「麦わら」",0,1500,0,200,150,100,"「ゴムゴムの弾丸!」","「ゴムゴムの銃乱打!」","「ゴムゴムのバズーカ!」");
        System.out.println("このゲームはONEPIECEの名バトルを体験できるゲームです。" + "\n" + "※体験版の為、レベルアップ要素はまだ導入しておりません。バトルごとにルフィのステータスをこちらで決めています。また、敵の行動も一定となっています。あらかじめご了承ください。" + "\n" + "それではチュートリアル戦「ルフィvsバギー」を行います");
        System.out.println("");
        //ここからチュートリアル・バギー戦
        //バギーのインスタンス生成
        Enemy Buggy = new Enemy("バギー","バラバラの実のバラバラ人間「道化」",1500,1200,150,100,80,"「バラバラ砲」","「バラバラせんべい!」","「バラバラフェスティバル!」","「特製バギー玉！」");
        int BuggyActCount = 0;
        int BuggySpecialCount = 0;
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
        System.out.println("行動には攻撃、技があります。" + "\n" + "攻撃:通常攻撃を行う" + "\n" + "{ダメージ計算は(attack/2) - (defence/4)}" + "\n" + "そして技発動に必要なMPを100~150のうちランダムで獲得する。" + "\n" + "技:必要な分のMPを消費して技を発動する。技の発動に必要なMPは「技1:100」,「技2:200」,「技3:300」。※EnemyにはMPは存在しません。");
        //バトル開始
        while (Monkey_D_Luffy.hp >= 0 || Buggy.hp >= 0) {
            //どちらかのHPが0以下になった時に判定するif文
            if (Monkey_D_Luffy.hp <= 0 || Buggy.hp <= 0){
                if (Monkey_D_Luffy.getHp() <= 0) {
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Buggy.getName() + "」");
                    break;
                } else if (Buggy.getHp() <= 0) {
                    System.out.println("ルフィ「吹っ飛べバギー！ゴムゴムの〜バズーカ！」　バギー「ぎゃああぁぁぁぁ...」");
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Monkey_D_Luffy.getName() + "」");
        
                    break;
                }
            }
            //素早さ比較（ルフィの方が素早さの値が高かった場合）
            if (Monkey_D_Luffy.speed > Buggy.speed) {
                System.out.println(Monkey_D_Luffy.getName()  + "のターンです。");
            
                //ルフィの行動
                Scanner enter4 = new Scanner(System.in);
                enter4.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan2 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy.getHp() + " 現在のMP:" + Monkey_D_Luffy.getMp() + " 敵の残りHP:" + Buggy.getHp());
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
                if (BuggyActCount == 0 || BuggyActCount == 1) {
                    Buggy.normalAttack(Monkey_D_Luffy);
                    BuggyActCount += 1;
                } else if (BuggyActCount == 2) {
                    if (BuggySpecialCount == 0) {
                        Buggy.doSpecialAttack1(Monkey_D_Luffy);
                        BuggySpecialCount += 1;
                        BuggyActCount = 0;
                    } else if (BuggySpecialCount == 1) {
                        Buggy.doSpecialAttack2(Monkey_D_Luffy);
                        BuggySpecialCount += 1;
                        BuggyActCount = 0;
                    } else if (BuggySpecialCount == 2) {
                        Buggy.doSpecialAttack3(Monkey_D_Luffy);
                        BuggySpecialCount = 0;
                        BuggyActCount = 0;
                    }
                }

            //素早さ比較（敵の方が素早さが早かった場合）
            } else if (Buggy.speed > Monkey_D_Luffy.speed) {
                System.out.println(Buggy.getName() + "のターンです");
                //Enemyの行動
                if (BuggyActCount == 0 || BuggyActCount == 1) {
                    Buggy.normalAttack(Monkey_D_Luffy);
                    BuggyActCount += 1;
                } else if (BuggyActCount == 2) {
                    if (BuggySpecialCount == 0) {
                        Buggy.doSpecialAttack1(Monkey_D_Luffy);
                        BuggySpecialCount += 1;
                        BuggyActCount = 0;
                    } else if (BuggySpecialCount == 1) {
                        Buggy.doSpecialAttack2(Monkey_D_Luffy);
                        BuggySpecialCount += 1;
                        BuggyActCount = 0;
                    } else if (BuggySpecialCount == 2) {
                        Buggy.doSpecialAttack3(Monkey_D_Luffy);
                        BuggySpecialCount = 0;
                        BuggyActCount = 0;
                    }
                }
                //ルフィの行動
                Scanner enter4 = new Scanner(System.in);
                enter4.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan2 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy.getHp() + " 現在のMP:" + Monkey_D_Luffy.getMp() + " 敵の残りHP:" + Buggy.getHp());
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
            }
        }
        System.out.println("次のバトルに進みますか？");
        Scanner scan4 = new Scanner(System.in);
        System.out.println("1:次のバトルへ 2:終わる");
        int num4 = scan4.nextInt();
        if (num4 == 1) {

        } else if (num4 == 2) {
            System.exit(0);
        }
        //ここからクロコダイル戦
        Luffy Monkey_D_Luffy2 = new Luffy("モンキー・D・ルフィ","「麦わら」",3000,6000,0,800,550,300,"「ゴムゴムの斧!」","「ゴムゴムのバズーカ!!」","「ゴムゴムの暴風雨(ストーム)!!!」");
        Enemy Crocodile = new Enemy("サー・クロコダイル","スナスナの実の砂人間「Mr.0」",8100,5500,700,600,400,"「三日月型砂丘(バルハン)」","「砂嵐(サーブルス)」","「砂漠の向日葵(デザート・ジラソーレ)」","「砂漠の金剛宝刀(デザート・ラスパーダ)!!」");
        int CrocodileActCount = 0;
        int CrocodileSpecialCount = 0;
        System.out.println("クロコダイル「!!!!バカな・・・なぜ水もなく俺を殴れる・・・」" + "\n" + "ルフィ「血でも砂は固まるだろ」" + "\n" + "クロコダイル「クッハッハッハッハ・・・いいだろう、これが最後だ　決着をつけようじゃねェか!!」");
        Scanner enter5 = new Scanner(System.in);
        enter5.nextLine();
        //ルフィと敵のステータス開示
        Monkey_D_Luffy2.showStatus();
        Crocodile.showStatus();
        Scanner enter6 = new Scanner(System.in);
        enter6.nextLine();
        //バトル開始
        while (Monkey_D_Luffy2.hp >= 0 || Crocodile.hp >= 0) {
            //どちらかのHPが0以下になった時に判定するif文
            if (Monkey_D_Luffy2.hp <= 0 || Crocodile.hp <= 0){
                if (Monkey_D_Luffy2.getHp() <= 0) {
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Crocodile.getName() + "」");
                    break;
                } else if (Crocodile.getHp() <= 0) {
                    System.out.println("クロコダイル「どこの馬の骨とも知れねェ小僧が・・・!! このおれを誰だと思ってやがる!!!!」" + "\n" + "ルフィ「お前がどこの誰だろうと!!!! 俺はお前を超えていく!!!!」");
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Monkey_D_Luffy2.getName() + "」");
                    break;
                }
            }
            //素早さ比較（ルフィの方が素早さの値が高かった場合）
            if (Monkey_D_Luffy2.speed > Crocodile.speed) {
                System.out.println(Monkey_D_Luffy2.getName()  + "のターンです。");
            
                //ルフィの行動
                Scanner enter7 = new Scanner(System.in);
                enter7.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan5 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy2.getHp() + " 現在のMP:" + Monkey_D_Luffy2.getMp() + " 敵の残りHP:" + Crocodile.getHp());
                int num5 = scan5.nextInt();
                if (num5 == 1) {
                    //通常攻撃
                    Monkey_D_Luffy2.normalAttack(Crocodile);
                } else if(num5 == 2) {
                    //技
                    System.out.println("技1:" + Monkey_D_Luffy2.getSpecialAttack1() + "技2:" + Monkey_D_Luffy2.getSpecialAttack2() + "技3:" + Monkey_D_Luffy2.getSpecialAttack3());
                    Scanner scan6 = new Scanner(System.in);
                    System.out.println("どの技を発動しますか？「1」「2」「3」の内から選んでください。");
                    int num6 = scan6.nextInt();
                    if (num6 == 1) {
                        if (Monkey_D_Luffy2.getMp() >= 100) {
                            Monkey_D_Luffy2.doSpecialAttack1(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 100) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num6 == 2) {
                        if (Monkey_D_Luffy2.getMp() >= 200) {
                            Monkey_D_Luffy2.doSpecialAttack2(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 200) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num6 == 3) {
                        if (Monkey_D_Luffy2.getMp() >= 300) {
                            Monkey_D_Luffy2.doSpecialAttack3(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 300) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    }
                }
                //Enemyの行動
                if (CrocodileActCount == 0 || CrocodileSpecialCount == 1) {
                    Crocodile.normalAttack(Monkey_D_Luffy2);
                    CrocodileActCount += 1;
                } else if (CrocodileActCount == 2) {
                    if (CrocodileSpecialCount == 0) {
                        Crocodile.doSpecialAttack1(Monkey_D_Luffy2);
                        CrocodileSpecialCount += 1;
                        CrocodileActCount = 0;
                    } else if (CrocodileSpecialCount == 1) {
                        Crocodile.doSpecialAttack2(Monkey_D_Luffy2);
                        CrocodileSpecialCount += 1;
                        CrocodileActCount = 0;
                    } else if (CrocodileSpecialCount == 2) {
                        Crocodile.doSpecialAttack3(Monkey_D_Luffy2);
                        CrocodileSpecialCount = 0;
                        CrocodileActCount = 0;
                    }
                }

            //素早さ比較（敵の方が素早さが早かった場合）
            } else if (Crocodile.speed > Monkey_D_Luffy2.speed) {
                System.out.println(Crocodile.getName() + "のターンです");
                //Enemyの行動
                if (CrocodileActCount == 0 || CrocodileActCount == 1) {
                    Crocodile.normalAttack(Monkey_D_Luffy2);
                    CrocodileActCount += 1;
                } else if (CrocodileActCount == 2) {
                    if (CrocodileSpecialCount == 0) {
                        Crocodile.doSpecialAttack1(Monkey_D_Luffy2);
                        CrocodileSpecialCount += 1;
                        CrocodileActCount = 0;
                    } else if (CrocodileSpecialCount == 1) {
                        Crocodile.doSpecialAttack2(Monkey_D_Luffy2);
                        CrocodileSpecialCount += 1;
                        CrocodileActCount = 0;
                    } else if (CrocodileSpecialCount == 2) {
                        Crocodile.doSpecialAttack3(Monkey_D_Luffy2);
                        CrocodileSpecialCount = 0;
                        CrocodileActCount = 0;
                    }
                }
                //ルフィの行動
                Scanner enter7 = new Scanner(System.in);
                enter7.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan5 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy2.getHp() + " 現在のMP:" + Monkey_D_Luffy2.getMp() + " 敵の残りHP:" + Crocodile.getHp());
                int num5 = scan5.nextInt();
                if (num5 == 1) {
                    //通常攻撃
                    Monkey_D_Luffy2.normalAttack(Crocodile);
                } else if(num5 == 2) {
                    //技
                    System.out.println("技1:" + Monkey_D_Luffy2.getSpecialAttack1() + "技2:" + Monkey_D_Luffy2.getSpecialAttack2() + "技3:" + Monkey_D_Luffy2.getSpecialAttack3());
                    Scanner scan6 = new Scanner(System.in);
                    System.out.println("どの技を発動しますか？「1」「2」「3」の内から選んでください。");
                    int num6 = scan6.nextInt();
                    if (num6 == 1) {
                        if (Monkey_D_Luffy2.getMp() >= 100) {
                            Monkey_D_Luffy2.doSpecialAttack1(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 100) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num6 == 2) {
                        if (Monkey_D_Luffy2.getMp() >= 200) {
                            Monkey_D_Luffy2.doSpecialAttack2(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 200) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num6 == 3) {
                        if (Monkey_D_Luffy2.getMp() >= 300) {
                            Monkey_D_Luffy2.doSpecialAttack3(Crocodile);
                        } else if (Monkey_D_Luffy2.getMp() < 300) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    }                
                }
            }
        }
        System.out.println("次のバトルに進みますか？");
        Scanner scan7 = new Scanner(System.in);
        System.out.println("1:次のバトルへ 2:終わる");
        int num7 = scan7.nextInt();
        if (num7 == 1) {

        } else if (num7 == 2) {
            System.exit(0);
        }
        //ここからカタクリ戦
        Luffy Monkey_D_Luffy3 = new Luffy("モンキー・D・ルフィ","「麦わら」",50000,10000,0,2000,900,700,"「ゴムゴムのJET大蛇砲(ジェットカルヴァリン)!」","「ゴムゴムの黒い蛇群(ブラックマンバ)!!」","「ゴムゴムの王蛇(キングコブラ)!!!」");
        Enemy Katakuri = new Enemy("シャーロット・カタクリ","モチモチの実の餅人間「スイート3将星」",105700,11000,1600,700,900,"「モチ突」","「雨垂モチ!」","「無双ドーナツ!!」","「斬・切・餅!!!」");
        int KatakuriActCount = 0;
        int KatakuriSpecialCount = 0;
        System.out.println("カタクリ「おれはもう・・・お前を格下とは思わねェ」" + "ルフィ「ホントか!!嬉しい!!ありがとう,でも勝つ!!!」");
        Scanner enter8 = new Scanner(System.in);
        enter8.nextLine();
        //ルフィと敵のステータス開示
        Monkey_D_Luffy3.showStatus();
        Katakuri.showStatus();
        Scanner enter9 = new Scanner(System.in);
        enter9.nextLine();
        //バトル開始
        while (Monkey_D_Luffy3.hp >= 0 || Katakuri.hp >= 0) {
            //どちらかのHPが0以下になった時に判定するif文
            if (Monkey_D_Luffy3.hp <= 0 || Katakuri.hp <= 0){
                if (Monkey_D_Luffy3.getHp() <= 0) {
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Katakuri.getName() + "」");
                    break;
                } else if (Crocodile.getHp() <= 0) {
                    System.out.println("カタクリ「ハァ・・・いつかお前は・・・”ビッグマム”を・・・倒しに来るのか・・・?」" + "\n" + "ルフィ「勿論だ・・・おれは・・・海賊王になる男だ!!!」　カタクリ「ずいぶん未来を・・・見てやがる・・・!!」");
                    System.out.println("バトル終了！" + "\n" + "勝者は「" + Monkey_D_Luffy3.getName() + "」");
                    break;
                }
            }
            //素早さ比較（ルフィの方が素早さの値が高かった場合）
            if (Monkey_D_Luffy3.speed > Katakuri.speed) {
                System.out.println(Monkey_D_Luffy3.getName()  + "のターンです。");
            
                //ルフィの行動
                Scanner enter10 = new Scanner(System.in);
                enter10.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan9 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy3.getHp() + " 現在のMP:" + Monkey_D_Luffy3.getMp() + " 敵の残りHP:" + Katakuri.getHp());
                int num9 = scan9.nextInt();
                if (num9 == 1) {
                    //通常攻撃
                    Monkey_D_Luffy3.normalAttack(Katakuri);
                } else if(num9 == 2) {
                    //技
                    System.out.println("技1:" + Monkey_D_Luffy3.getSpecialAttack1() + "技2:" + Monkey_D_Luffy3.getSpecialAttack2() + "技3:" + Monkey_D_Luffy3.getSpecialAttack3());
                    Scanner scan10 = new Scanner(System.in);
                    System.out.println("どの技を発動しますか？「1」「2」「3」の内から選んでください。");
                    int num10 = scan10.nextInt();
                    if (num10 == 1) {
                        if (Monkey_D_Luffy3.getMp() >= 100) {
                            Monkey_D_Luffy3.doSpecialAttack1(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 100) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num10 == 2) {
                        if (Monkey_D_Luffy3.getMp() >= 200) {
                            Monkey_D_Luffy3.doSpecialAttack2(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 200) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num10 == 3) {
                        if (Monkey_D_Luffy3.getMp() >= 300) {
                            Monkey_D_Luffy3.doSpecialAttack3(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 300) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    }
                }
                //Enemyの行動
                if (KatakuriActCount == 0 || KatakuriActCount == 1) {
                    Katakuri.normalAttack(Monkey_D_Luffy3);
                    KatakuriActCount += 1;
                } else if (KatakuriActCount == 2) {
                    if (KatakuriSpecialCount == 0) {
                        Katakuri.doSpecialAttack1(Monkey_D_Luffy3);
                        KatakuriSpecialCount += 1;
                        KatakuriActCount = 0;
                    } else if (KatakuriSpecialCount == 1) {
                        Katakuri.doSpecialAttack2(Monkey_D_Luffy3);
                        KatakuriSpecialCount += 1;
                        KatakuriActCount = 0;
                    } else if (CrocodileSpecialCount == 2) {
                        Katakuri.doSpecialAttack3(Monkey_D_Luffy3);
                        KatakuriSpecialCount = 0;
                        KatakuriActCount = 0;
                    }
                }
    
            //素早さ比較（敵の方が素早さが早かった場合）
            } else if (Katakuri.speed > Monkey_D_Luffy3.speed) {
                System.out.println(Katakuri.getName() + "のターンです");
                //Enemyの行動
                if (KatakuriActCount == 0 || KatakuriSpecialCount == 1) {
                        Katakuri.normalAttack(Monkey_D_Luffy3);
                        KatakuriActCount += 1;
                } else if (KatakuriActCount == 2) {
                    if (KatakuriSpecialCount == 0) {
                        Katakuri.doSpecialAttack1(Monkey_D_Luffy3);
                        KatakuriSpecialCount += 1;
                        KatakuriActCount = 0;
                    } else if (KatakuriSpecialCount == 1) {
                        Katakuri.doSpecialAttack2(Monkey_D_Luffy3);
                        KatakuriSpecialCount += 1;
                        KatakuriActCount = 0;
                    } else if (CrocodileSpecialCount == 2) {
                        Katakuri.doSpecialAttack3(Monkey_D_Luffy3);
                        KatakuriSpecialCount = 0;
                        KatakuriActCount = 0;
                    }
                }
                //ルフィの行動
                Scanner enter10 = new Scanner(System.in);
                enter10.nextLine();
                System.out.println("");
                System.out.println("行動を選択してください");
                Scanner scan9 = new Scanner(System.in);
                System.out.println("1:通常攻撃　2:技  現在のHP:" + Monkey_D_Luffy3.getHp() + " 現在のMP:" + Monkey_D_Luffy3.getMp() + " 敵の残りHP:" + Katakuri.getHp());
                int num9 = scan9.nextInt();
                if (num9 == 1) {
                    //通常攻撃
                    Monkey_D_Luffy3.normalAttack(Katakuri);
                } else if(num9 == 2) {
                    //技
                    System.out.println("技1:" + Monkey_D_Luffy3.getSpecialAttack1() + "技2:" + Monkey_D_Luffy3.getSpecialAttack2() + "技3:" + Monkey_D_Luffy3.getSpecialAttack3());
                    Scanner scan10 = new Scanner(System.in);
                    System.out.println("どの技を発動しますか？「1」「2」「3」の内から選んでください。");
                    int num10 = scan10.nextInt();
                    if (num10 == 1) {
                        if (Monkey_D_Luffy3.getMp() >= 100) {
                            Monkey_D_Luffy3.doSpecialAttack1(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 100) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num10 == 2) {
                        if (Monkey_D_Luffy3.getMp() >= 200) {
                            Monkey_D_Luffy3.doSpecialAttack2(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 200) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    } else if(num10 == 3) {
                        if (Monkey_D_Luffy3.getMp() >= 300) {
                            Monkey_D_Luffy3.doSpecialAttack3(Katakuri);
                        } else if (Monkey_D_Luffy3.getMp() < 300) {
                            System.out.println("エラーが発生しました。原因:MPが不足している。全ての処理を終了します。初めからやり直してください。");
                            System.exit(0);
                        }
                    }                
                }
            }
        }
        System.out.println("ゲームクリア!おめでとう!");
    }
}
