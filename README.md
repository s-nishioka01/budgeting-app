# 家計管理アプリ
## アプリケーションの内容
- 簡単な家計管理アプリ
- 購入したもののリストを日付昇順で表示。新規登録(Create)、編集(Update)、削除(Delete)が可能。
- サーバーサイドはPurchase.java, PurchaseController.java, PurchaseService.java, PurchaseMapper.java, PurchaseMapper.xml
- フロントエンドはトップページがindex.html, 新規登録用のフォームがnew.html, 編集用フォームがupdate.html, 削除確認用フォームがdelete.html

## 構成要件
- Java 11  
- Gradle 7.5  
- Spring Boot 2.7.4  
- Docker Desktop 4.8.7  
- Docker Compose 2.5.0  
- MySQL 8.0  
- MyBatis Spring Boot Starter 2.2.2  

## 主な機能
- リスト：データベースの要素をSQLで取得したものを日付昇順で表示
- 合計金額欄：データベースの全ての要素の金額の合計をSQLで取得し表示
- 新規登録ボタン：GETメソッドを送信し、新規登録フォームページを返す
- 編集ボタン：各リスト要素のidを取得しGETメソッドを送信して編集フォームページを返す
- 削除ボタン：各リスト要素のidを取得しGETメソッドを送信して削除確認ページを返す
- 新規登録フォーム：POSTメソッドで入力した値を送信しデータベースに保存（日付の初期値には今日の日付をセット）
- 編集フォーム：各リスト要素の現在の値を初期値にセットし、編集した要素をPOSTメソッドで送信
- 削除確認：POSTメソッドを送信して対応するデータをデータベースから削除

![lesson6application](https://user-images.githubusercontent.com/103230014/171185307-5d68514c-6b95-45dd-a69e-d368d2a93526.gif)
