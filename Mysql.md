 create table user(
    id int primary key auto_increment,
    username varchar(20) not null ,
    password varchar(20) not null 
);

create table quiz(
    id int primary key auto_increment,
    descrition varchar(35),
    data text,
    question text,
    solution text,
    analysis text,
    stysle varchar(15)
);

create table collection(
    id int primary key auto_increment,
    userid int not null ,
    quizid int not null,
    CONSTRAINT `fk_collection_userid`  FOREIGN KEY(userid) REFERENCES user(id),
    CONSTRAINT `fk_collection_quizid` FOREIGN KEY(quizid) REFERENCES quiz(id)
);


create table commemt(
    id int primary key auto_increment,
    username varchar(20) not null ,
    comment text not null ,
    goal int not null ,
    createtime datetime not null,
    userid int not null ,
    quizid int not null ,
	CONSTRAINT `fk_comment_userid`  FOREIGN KEY(userid) REFERENCES user(id),
    CONSTRAINT `fk_comment_quizid` FOREIGN KEY(quizid) REFERENCES quiz(id)
	);
