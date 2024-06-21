create table collection(
    id int primary key auto_increment,
    userid int not null ,
    quizid int not null

);
create table quiz(
    id int primary key auto_increment,
    data text,
    question text,
    solution text,
    analysis text,
    stysle varchar(15)
);
create table user(
    id int primary key auto_increment,
    username varchar(20) not null ,
    password varchar(20) not null 
)
create table commemt(
    id int primary key auto_increment,
    username varchar(20) not null ,
    quizid int not null ,
    comment text not null ,
    goal int not null 
              )
