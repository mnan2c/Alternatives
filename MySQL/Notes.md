## 1. 常用命令

1. 显示表列：show columns from customer;
2. describe customer;  -- 是show columns的一种快捷方式
3. 显示建库、建表语句：show create database/table;
4. 多个列不同排序：order by prod_price DESC, prod_name ASC;
5. 不等于使用 != 或 <>
6. 范围检查：where price BETWEEN 5 and 10;
7. in比or语句更有优势：
   1. in一般比or执行更快；
   2. in可以包含select语句；
8. 通配符
   1. where name like '%joke'; 
   2. where name like '_joke';
9. 正则
   1. where name REGEXP 'Mark|Tony'; -- or匹配
   2. where name REGEXP BINARY '.Joke'; -- 基本匹配，区分大小写
   3. where name REGEXP '[1-9] Tony'; -- 匹配几个字符之一
   4. where name REGEXP '^.Joke$';  -- 使用这两个定位符，效果等同于like
   5. `where name REGEXP 'Inc\\.';` -- 匹配特殊字符（双反斜杠，MySQL自己解释一个，正则表达式库解释另一个）
   6. `where name REGEXP 'Inc\\\';` -- 匹配反斜杠本身
   7. select 'hello' REGEXP '[0-9]'; -- 在不使用数据的情况下使用select来测试正则表达式，没有匹配返回0，匹配到返回1
10. 拼接串：select concat(RTrim(user_name), '-', LTrim(user_idcard), '-', Trim(user_addr))
11. 文本处理函数。1）Left(), Right(), Locate(), SubString()：子字符串。2）Lower(), Upper()；3）LTrim(), RTrim(), Trim()。 Length(),  Soundex()。
12. 日期时间处理函数。1）addDate(), addTime()，date_add()，datediff(); 2) CurDate(), CurTime(), now(); 3) Date(), Time(), Year(), Month(), dayOfWeek(), day(), Hour(), Minute(), Second(); 4) date_format()
13. 数值处理函数。Abs(), Mod(), Rand(), Sqrt() 
14. 分组。HAVING过滤分组，WHERE过滤行。WHERE的所有子句都适用于HAVING。

