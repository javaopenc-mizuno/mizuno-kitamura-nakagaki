

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//使われる側のクラス
//連絡先(Contactクラス)のリストを管理するクラス
public class ContactManager {

	//フィールド	
	//連絡先情報(Contactオブジェクト)をまとめて保存するリストのrenrakusakiを設定
	//ArrayListとして初期化し、Contact型のデータだけを入れられるようにしている。
	//privateで、外から直接触れないようにする。
	private List<Contact> renrakusaki;

	//コンストラクタ
	//renrakusakiをnew ArrayList<>で初期化。←アプリ起動後に空の連絡先リストが最初に作られ、検索や追加が可能。
	public ContactManager() {
		renrakusaki = new ArrayList<>();
	}

	//メソッド↓（追加・検索・削除の３種類）

	//連絡先リストに追加する処理
	//引数で受け取ったContact型のオブジェクトを、リストrenntakusakiにadd()メソッドで追加
	public void addContact(Contact contact) {
		renrakusaki.add(contact);
	}

	//名前検索の処理
	//searchByNameメソッドを設定し、引数を探したい名前とする
	//for文でrenrakusakiリストの中を 1 件ずつ調べgetNameで一致する名前があるかを調べる。
	//一致する連絡先が見つかればそのContactオブジェクトを返し、見つからなければ null を返す。
	public Contact searchByName(String name) {
		for (Contact contact : renrakusaki) {
			if (contact.getName().equalsIgnoreCase(name)) {
				return contact;
			}

		}
		return null;

	}

	//電話番号検索の処理
	//searchByPhoneメソッドを設定し、引数を検索対象の電話番号とする。以降は先ほどのsearchByNameメソッドと同じ。
	//for文でrenrakusakiリストの中を 1 件ずつ調べ、contact.getName().equalsIgnoreCase(name) で一致する電話番号があるかを調べる。
	//一致する連絡先が見つかればその Contactオブジェクトを返し、見つからなければ null を返す。
	public Contact searchByPhone(String phone) {
		for (Contact contact : renrakusaki) {
			if (contact.getPhone().equalsIgnoreCase(phone)) {
				return contact;
			}
		}
		return null;

	}

	// 削除する処理
	// deleteContactByNameメソッドを設定し、一致する名前が見つかればtrueを返し、見つからなければ false を返す
	public boolean deleteContactByName(String name) {
		// 連絡先リスト（renrakusaki）のイテレーターを作成
		Iterator<Contact> iterator = renrakusaki.iterator();
		//要素が存在するかチェックする
		while (iterator.hasNext()) {
			//次の要素を取得
			Contact contact = iterator.next();
			// 取得した連絡先の名前が、引数の name と一致するかチェック
			if (contact.getName().equals(name)) {
				// 一致した場合、その要素をリストから削除  
				iterator.remove();
				return true;
			}

		}
		// ループ終了まで一致する名前が見つからなかった場合は false を返す
		return false;

	}

}
