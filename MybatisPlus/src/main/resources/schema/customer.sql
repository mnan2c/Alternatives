DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '名称',
	address VARCHAR(50) NULL DEFAULT NULL COMMENT '地址',
	PRIMARY KEY (id)
);

DELETE FROM customer;

INSERT INTO customer (id, name, address) VALUES
(1, 'Jone', '旺墩路'),
(2, 'Jack', '南施街'),
(3, 'Tom', '齐门大街'),
(4, 'Sandy', '奥体中心西'),
(5, 'Billie', '独墅湖');