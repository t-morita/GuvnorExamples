##  人工知能学会誌 解説「業務ルール管理システムBRMSの現状と動向」のサンプルリポジトリとプログラム

### 科研費国内出張に関するGuvnorのサンプルリポジトリ
 * [Guided Rule Editorのみを用いてルールを作成したGuvnorのリポジトリ] (https://github.com/t-morita/GuvnorExamples/blob/master/SampleRepositories/normal_repository_export.zip)
 * [Guided Rule EditorとDSLを用いてルールを作成したGuvnorのリポジトリ](https://github.com/t-morita/GuvnorExamples/blob/master/SampleRepositories/dsl_repository_export.zip)
 * [決定表を用いてルールを作成したGuvnorのリポジトリ] (https://github.com/t-morita/GuvnorExamples/blob/master/SampleRepositories/decision_tree_repository_export.zip)

### 科研費国内出張に関するGuvnorのサンプルリポジトリと連携するEclipseプロジェクト
 * [サンプルEclipseプロジェクト] (https://github.com/t-morita/GuvnorExamples/tree/master/KAKENHIDomesticTrip)
 * [科研費国内出張に関するルールを実行するJavaサンプルプログラム](https://github.com/t-morita/GuvnorExamples/blob/master/KAKENHIDomesticTrip/src/main/java/com/sample/KAKENHIDomesticTripTest.java)

### Guvnorのインストール方法
#### Tomcat 6を利用する場合 (WindowsはTomcat推奨)
 1.	 [Tomcat 6](http://tomcat.apache.org/download-60.cgi)をインストール
  * Windows Vista/7/8の場合，ユーザのアクセス権限のあるフォルダにインストールすること
 2. [guvnor-distribution-5.5.0.Final.zip](http://download.jboss.org/drools/release/5.5.0.Final/)のダウンロード
 3. Tomcat6のwebappsフォルダに，zipファイルを展開したフォルダのbinariesフォルダにある「guvnor-5.5.0.Final-tomcat-6.0.war」ファイルをコピー
 4. [http://localhost:8080/guvnor-5.5.0.Final-tomcat-6.0/]([http://localhost:8080/guvnor-5.5.0.Final-tomcat-6.0/) にアクセスする

#### JBoss AS 7を利用する場合
 1.	 JBoss Application Server(AS) 7.1.1 Finalのインストール
  * [http://www.jboss.org/jbossas/](http://www.jboss.org/jbossas/)
  * [http://www.jboss.org/jbossas/downloads](http://www.jboss.org/jbossas/downloads)
 2. [guvnor-distribution-5.5.0.Final.zip](http://download.jboss.org/drools/release/5.5.0.Final/)のダウンロード
 3.  JBoss ASを展開したフォルダのstandalone/deploymentsフォルダに，guvnorを展開したフォルダのbinariesフォルダにあるguvnor-5.5.0.Final-jboss-as-7.0.warファイルをコピーする
 4.	上記と同一フォルダに，guvnor-5.5.0.Final-jboss-as-7.0.war.dodeployファイルを作成する
  * touch guvnor-5.5.0.Final-jboss-as-7.0.war.dodeploy
 5.	bin/standalone.confに以下を追加（日本語をコンソールに表示可能にする設定）
   * JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF-8"
 6. JBoss ASを展開したフォルダのbin/standalone.sh(bat)ファイルを実行する
 7.	 [http://localhost:8080/guvnor-5.5.0.Final-jboss-as-7.0/](http://localhost:8080/guvnor-5.5.0.Final-jboss-as-7.0/) にアクセスする

### GuvnorとEclipseの連携方法
 1. Eclipse 3.7または4.2をインストール
   * [http://mergedoc.sourceforge.jp](http://mergedoc.sourceforge.jp)
   * [http://www.eclipse.org/downloads/](http://www.eclipse.org/downloads/)
 2. [droolsjbpm-tools-distribution-5.5.0.Final.zip](http://download.jboss.org/drools/release/5.5.0.Final/) のダウンロードし，ファイルを解凍する
 3. Eclipseを起動し，”Help”メニューから“Install new software...”を選択
 4. “Add...”ボタンを押して，“drools local update site”と入力し，“Local...”ボタンを押して，2.で解凍したフォルダにあるorg.drools.updatesiteフォルダを選択する
 5. Nextボタンを押して，最後にFinishボタンを押す
 6. Eclipse環境設定のGuvnorメニューより，「Guvnor URL Template」にインストールしたGuvnorのwebdavのURL(例：http://localhost:8080/guvnor-5.5.0.Final-jboss-as-7.0/org.drools.guvnor.Guvnor/webdav/)を設定することで，指定したGuvnor上のパッケージ一覧，パッケージ内のアセット，アセットの更新履歴などが参照可能となる．
 7. Eclipse環境設定のDroolsメニューより，「Installed Drools Runtimes」として，ダウンロードした「drools-distribution」のbinariesディレクトリ(例：/Users/t_morita/Downloads/drools-distribution-5.5.0.Final/binaries)を設定することで，Droolsプロジェクトの作成が可能となる．
 8. Droolsプロジェクトを作成すると，Drools関連ライブラリのクラスパスへの追加などが自動で行われる．また，パッケージのスナップショットを作成することにより，Javaプログラムにより外部からGuvnor上で作成したアセットにアクセス可能となる．

