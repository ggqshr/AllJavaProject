use test;
create table t_computer(
	id int primary key auto_increment,
	model varchar(20),
	picName varchar(100),
	prodDesc varchar(255),
	price double
);
insert into t_computer(model,picName,prodDesc,price) 
			values('x200','x200.jpg','价格便宜，性能不咋滴，适合入门',2500);
			insert into t_computer(model,picName,prodDesc,price) 
			values('x500','x500.jpg','适合办公，性能一般般吧',3000);
			insert into t_computer(model,picName,prodDesc,price) 
			values('x600','x600.jpg','还可以啦，性能也还好哦',3500);