
##创建数据库
CREATE DATABASE IF NOT EXISTS idiomdb;

##创建用户（该用户只能从本机访问数据库，权限为INSERT、DELETE、UPDATE、SELECT）
GRANT ALL ON idiomdb.* TO idiom@"localhost" IDENTIFIED BY "password";

##创建用户（该用户可以从其他机器远程访问数据库，权限SELECT和INSERT操作）
GRANT SELECT, INSERT, DELETE ON idiomdb.* TO student@"%" IDENTIFIED BY "password";

##进入数据库
USE idiomdb;

##创建表
DROP TABLE IF EXISTS cn_idiom;
CREATE TABLE cn_idiom
(
item_id    VARCHAR(18) NOT NULL, #索引号
name       VARCHAR(64) NOT NULL, #成语
pinyin     VARCHAR(64) NOT NULL, #拼音
paraphrase VARCHAR(1024),        #释义
provenance VARCHAR(1024),        #出处
example    VARCHAR(1024),        #示例
remark     VARCHAR(64),
PRIMARY KEY (item_id)
);


