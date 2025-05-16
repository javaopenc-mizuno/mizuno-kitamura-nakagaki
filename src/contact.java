

public class contact {
	//contact クラスでは、個人の連絡先情報を表すための基本的なデータクラス
	//連絡帳アプリなどで「1人分の連絡先」を扱うための部品に当たります。

	//フィールド
	//フィールド変数としてname,phone,email、すべてprivateにしてアクセス制限をかける。
	private String name;//名前
	private String phone;//電話番号
	private String email;//メールアドレス

	//コンストラクタ:オブジェクト生成時に、名前・電話番号・メールアドレスを受け取って初期化する
	public contact(String name, String phone, String email) {
		this.name = name;//引数nameの値をフィールドnameに代入
		this.phone = phone;//引数phoneの値をフィールドphoneに代入
		this.email = email;//引数emailの値をフィールドemailに代入
	}

	//ゲッター・セッター
	//ゲッター・セッターを使いフィールドの値を取得、変更を行います
	//名前の取得
	public String getName() {
		return name;
	}

	// 名前を設定
	public void setName(String name) {
		this.name = name;
	}

	// 電話番号を取得
	public String getPhone() {
		return phone;
	}

	// 電話番号を設定
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// メールアドレスを取得
	public String getEmail() {
		return email;
	}

	// メールアドレスを設定
	public void setEmail(String email) {
		this.email = email;

	}
	
	@Override
	//toStringメソッド
	// // 連絡先の情報を文字列として返す
	public String toString() {
		return "名前: " + name + ", 電話番号: " + phone + ", メールアドレス: " + email;

	}

}
