create table student(
    student_no int not null,
    student_name varchar(20) not null,
    student_year int not null,
    student_addr varchar(100),
    student_tel varchar(20),
    student_birth date,
    primary key(student_no)
  );
  
  create table grade(
      student_no int not null,
      grade_kor int,
      grade_eng int,
      grade_math int,
      PRIMARY key(student_no),
      CONSTRAINT grade_student_no_fk 
        FOREIGN KEY (student_no) REFERENCES student(student_no)
    );
    
    create table scholarship(
        scholar_name varchar(20) not null,
        scholar_percent int,
        scholar_money int,
        PRIMARY key(scholar_name)
     );


insert into student values (20111001,'�質��',4,'����Ư���� ���ʱ� ���ʵ�','010-1111-2222','1992-09-09');
insert into student values (20111002,'�̿���',4,'����Ư���� ������ �Ż絿','010-1232-2222','1992-09-09');
insert into student values (20111003,'�ڿ���',4,'����Ư���� ������ �ֹ���','010-1232-1232','1992-09-09');
insert into student values (20120110,'������',3,'����Ư���� ����� ��赿','010-1232-2222','1993-08-09');
insert into student values (20120112,'���ʽ�',3,'����Ư���� ������ ������','010-1755-3543','1993-10-19');
insert into student values (20121003,'������',3,'����Ư���� ����� �߰赿','010-2563-8844','1993-05-19');
insert into student values (20130203,'������',2,'����Ư���� ���ϱ� ���ϵ�','010-5345-6443','1994-12-09');
insert into student values (20130206,'���Ǽ�',2,'����Ư���� ������ ������','010-0009-1231','1994-11-04');
insert into student values (20140207,'�̹̿�',1,'����Ư���� ����� �ϰ赿','010-4223-4211','1995-05-25');
insert into student values (20140216,'������',1,'����Ư���� ������ �Ͽ���','010-2344-2755','1995-03-22');
insert into student values (20140331,'�۾���',1,'������ ��õ�� ��赿','010-2344-1112','1995-04-08');
insert into student values (20140402,'�̹���',1,'����� ���Ǳ� ��õ��','010-5331-2330','1995-05-06');
insert into student values (20140405,'�Źξ�',1,'���ϵ� ���� �Ͼ���','010-0892-2349','1995-06-06');


insert into grade values (20111001,46,65,72);
insert into grade values (20111002,100,100,72);
insert into grade values (20111003,35,34,32);
insert into grade values (20120110,15,89,90);
insert into grade values (20120112,77,80,90);
insert into grade values (20121003,60,80,46);
insert into grade values (20130203,68,89,90);
insert into grade values (20130206,55,45,100);
insert into grade values (20140207,100,100,90);
insert into grade values (20140216,88,80,90);
insert into grade values (20140331,80,70,80);
insert into grade values (20140402,70,90,90);
insert into grade values (20140405,90,89,87);

insert into scholarship values ('�������б�',10,1200000);
insert into scholarship values ('��Ƽ�ƽ����б�',30,400000);
insert into scholarship values ('�е����б�',40,300000);