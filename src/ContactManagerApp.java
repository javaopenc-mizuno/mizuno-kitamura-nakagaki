package tsuika;

import java.util.Scanner;// ユーザー入力を受け取るために Scanner クラスをインポート

//ContactManagerApp クラス（使う側のクラス）
public class ContactManagerApp {
	public static void main(String[] arges) {
		// ContactManagerクラスのオブジェクトを作成（連絡先を管理するため）
		ContactManager manager = new ContactManager();
		// ユーザー入力を受け取るためのScannerオブジェクトを作成
		Scanner sc1 = new Scanner(System.in);

		//プログラム進行管理（while文）
		// アプリを動作させるための変数(running)を作成し初期値はtrueに設定
		boolean running = true;
		while (running) {
			// メニュー表示
			System.out.println("連絡先管理アプリ(メニュー)");
			System.out.println("1.連絡先登録");
			System.out.println("2.詳細連絡先登録");
			System.out.println("3.連絡先一覧表示");
			System.out.println("4.名前検索");
			System.out.println("5.電話番号");
			System.out.println("6.連絡先削除 ");
			System.out.println("7.終了");
			System.out.print(" >");
			// メニューの選択肢をユーザーから受け取りt1に格納する
			String t1 = sc1.nextLine();
			switch (t1) {
			//t1の値をもとにswitch文で処理を分岐
			case "1":
				System.out.println("名前を入力してください");
				String name = sc1.nextLine();
				// すでに同じ名前が登録されていないか確認(警告文)
				//入力したnameをSerchByNameメソッドにいれ、nullでなかったらメッセージを表示
				if (manager.searchByName(name) != null) {
					System.out.println("この名前は既に登録されています。");
					break; // 重複があるので登録処理を中断し、メニューに戻る
				}
				System.out.println("電話番号を入力してください");
				String phone = sc1.nextLine();
				System.out.println("メールアドレスを入力してください");
				String email = sc1.nextLine();
				//内容確認
				while (true) {
					// 入力された情報をもう一度表示し、確認を促す
					System.out.println("登録内容は以下の内容で間違いありませんか？");
					System.out.println("名前: " + name);
					System.out.println("電話番号: " + phone);
					System.out.println("メールアドレス: " + email);

					// ユーザーに「はい」か「いいえ」を入力してもらう
					System.out.println("「はい」か「いいえ」を入力してください");
					String t = sc1.nextLine(); // ユーザーの入力をtに格納

					// 「はい」と入力された場合：連絡先を登録
					if (t.equals("はい")) {
						// Contactオブジェクトを生成し、managerに追加する
						manager.addContact(new Contact(name, phone, email));
						System.out.println("連絡先を登録しました。");
						break; // 登録完了後、確認ループを終了し、メインメニューに戻る
					}

					// 「いいえ」と入力された場合：登録をキャンセルしてメインメニューに戻る
					else if (t.equals("いいえ")) {
						System.out.println("メニューに戻ります。");
						break; // ループを抜けて何もせずにメインメニューに戻る
					}

					// それ以外の入力があった場合：エラーメッセージを表示し、再入力を促す
					else {
						System.out.println("無効な選択肢です。「はい」か「いいえ」で入力してください。");
						// ここでは何もせず、ループの最初に戻って再表示する
					}
				}

				// case "1" の処理終了。メインメニュー表示に戻る
				break;

			case "2": // 詳細連絡先追加
				System.out.println("名前を入力してください");
				// ユーザーに名前の入力を求め、name2に格納
				String name2 = sc1.nextLine();
				System.out.println("電話番号を入力してください");
				// 電話番号の入力を受け取り、phone2に格納
				String phone2 = sc1.nextLine();
				System.out.println("メールアドレスを入力してください");
				// メールアドレスの入力を受け取り、email2に格納
				String email2 = sc1.nextLine();
				System.out.println("住所を入力してください");
				// 住所の入力を受け取り、addressに格納
				String address = sc1.nextLine();
				System.out.println("郵便番号を入力してください");
				// 郵便番号の入力を受け取り、addressnumに格納
				String addressnum = sc1.nextLine();

				// 入力された情報を元に、DetailContactオブジェクトを作成し、ContactManagerに追加する
				manager.addContact(new DetailContact(name2, phone2, email2, address, addressnum));
				// ユーザーに登録完了のメッセージを表示
				System.out.println("詳細連絡先を登録しました。");
				break;
			case "3"://連絡先一覧を表示する
				manager.displayAll();
				break;

			case "4"://名前検索の処理
				System.out.print("検索したい名前を入力してください: ");
				//入力された名前をsearchNameに格納
				String searchName = sc1.nextLine();
				// ContactManager に登録されている連絡先から名前で検索し、変数foundByNameに格納
				Contact foundByName = manager.searchByName2(searchName);
				// 検索結果を判定（null でなければ見つかった）
				if (foundByName != null) {
					// 一致する名前が見つかった場合、情報を表示
					System.out.println("見つかりました: " + foundByName);
				} else {
					// 一致する連絡先がなかった場合のメッセージ
					System.out.println("その名前の連絡先は見つかりませんでした。");
				}
				break;
			case "5"://電話番号検索の処理
				System.out.print("検索する電話番号を入力してください: ");
				// 入力された電話番号を searchPhone に格納
				String searchPhone = sc1.nextLine();
				// ContactManager に登録された連絡先から電話番号で検索し、変数serchPhoneに格納		
				Contact foundByPhone = manager.searchByPhone(searchPhone);
				// 検索結果を判定（null でなければ見つかった）
				if (foundByPhone != null) {
					// 一致する連絡先が見つかった場合、情報を表示
					System.out.println("見つかりました: " + foundByPhone);
				} else {
					// 一致する連絡先がなかった場合のメッセージ
					System.out.println("該当する電話番号の連絡先は見つかりませんでした。");
				}
				break;
			case "6":
				//名前で削除
				System.out.print("削除したい名前を入力してください。");
				//ユーザーから削除したい名前を受け取る
				String deleteName = sc1.nextLine();
				// 指定された名前に一致する連絡先を削除する
				boolean deleted = manager.deleteContactByName(deleteName);
				// 削除の結果に応じてメッセージを表示
				if (deleted) {
					// 名前に一致する連絡先が見つかり、削除できた場合
					System.out.println("連絡先を削除しました。");
				} else {
					//  // 一致する連絡先が存在しなかった場合
					System.out.println("指定された名前の連絡先は見つかりませんでした。");
				}

				break;

			case "7"://終了処理
				System.out.println("アプリを終了します。");
				// ループを終了させるために running を false にする
				running = false;
				break;

			default:// 無効な入力に対する処理
				System.out.println("無効な選択肢です。もう一度入力してください。");
				break;
			}
		}
		sc1.close();// Scannerを閉じる

	}
}