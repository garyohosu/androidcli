# CounterApp

Jetpack Compose で作ったシンプルなカウンターアプリです。  
[Android CLI](https://developer.android.com/tools/agents/android-cli) と Claude Code を使って生成しました。

## ダウンロード

[**CounterApp-v1.0.0.apk**](https://github.com/garyohosu/androidcli/releases/download/v1.0.0/CounterApp-v1.0.0.apk)

または [リリースページ](https://github.com/garyohosu/androidcli/releases/tag/v1.0.0) から入手できます。

### インストール方法

1. 上記リンクから APK をダウンロード
2. Android の設定 → セキュリティ → **不明なソースからのインストールを許可**
3. ダウンロードした APK をタップしてインストール

## 機能

- **+/-ボタン** でカウントを増減
- **リセット**ボタンで0に戻す
- カウントの値に応じて色が変化
  - 正の数: プライマリカラー（青）
  - 負の数: エラーカラー（赤）
  - ゼロ: デフォルトカラー

## 動作環境

| 項目 | 内容 |
|------|------|
| 最小 Android バージョン | Android 7.0 (API 24) |
| ターゲット | Android 16 (API 36) |
| アーキテクチャ | arm64-v8a, armeabi-v7a, x86_64 |

## 技術スタック

- **言語**: Kotlin
- **UI**: Jetpack Compose + Material3
- **アーキテクチャ**: MVVM
- **ビルド**: Gradle 9.1.0

## ビルド方法

```bash
# Android SDK が必要です
git clone https://github.com/garyohosu/androidcli.git
cd androidcli/CounterApp
./gradlew assembleRelease
# APK: app/build/outputs/apk/release/app-release.apk
```

## Android CLI について

このアプリは Google の [Android CLI 1.0](https://developer.android.com/tools/agents/android-cli) を使って Claude Code から生成しました。

```bash
# Windows
winget install -e --id Google.AndroidCLI

# インストール確認
android --version
```

Android CLI は AI エージェントが Android Studio の機能（静的解析・シンボル検索・Compose プレビューなど）をコマンドラインから利用できるツールです。LLM のトークン使用量を最大 70% 削減し、開発速度を 3 倍にする効果があります。

## ライセンス

MIT
