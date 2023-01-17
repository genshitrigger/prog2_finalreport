package jp.ac.uryukyu.ie.e225716;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Luffy Monkey_D_Luffy = new Luffy("モンキー・D・ルフィ","「麦わら」",0,1000,100,200,100,30);
        System.out.println("このゲームはONEPIECEの名バトル(セリフだけ)を体験できるゲームです。" + "\n" + "チュートリアル戦「ルフィvsバギー」を行いますか？");
        Scanner scan = new Scanner(System.in);
        System.out.println("行う場合は「1」をチュートリアル戦をスキップする場合は「2」を入力してください。");
        int num = scan.nextInt();
        
        if (num == 1){ //ここからバギー戦
            System.out.println("ルフィ「ししし、海図は手に入れたしあとはお前をブッ飛ばすだけだ。」" + "\n" + "バギー「麦わらぁ！偉大なる航路の海図を返しやがれ！よくも俺に赤っ恥をかかせやがって、ハデに死ね！・・・誰が赤っ鼻だクラァ!💢」"+"\n"+"バトルスタート！");
            Monkey_D_Luffy.showStatus();
        }

    }
}
