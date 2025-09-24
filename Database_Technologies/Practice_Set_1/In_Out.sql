CREATE DATABASE school;
USE school;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50),
    marks INT
);

INSERT INTO students (name, age, course, marks) VALUES
('Alice', 20, 'Computer Science', 78),
('Bob', 21, 'Electronics', 78),
('Charlie', 22, 'Mechanical', 65),
('David', 20, 'Electrical', 50),
('Eva', 23, 'Civil', 88),
('Frank', 21, 'Computer Science', 73),
('Grace', 22, 'Electronics', 81),
('Helen', 20, 'Mechanical', 55),
('Ian', 21, 'Civil', 60),
('Jane', 22, 'Computer Science', 95);

-- 1.	Write a procedure that accepts a student name as input and retrieves the marks of that student using SELECT INTO and display the retrieved marks.
delimiter //
drop procedure marksDisplayer//
create procedure marksDisplayer(in sname varchar(20))
begin
declare smarks int default 0;
select marks into smarks from students where name = sname;
select concat("Student ", sname, " marks are ", smarks);
end//

call marksDisplayer("Frank")//

-- 2.	Write a procedure that accepts a course ID as input and retrieves the course name using SELECT INTO and display the retrieved course name.
create procedure courseName(in cid varchar(10))
begin
declare cname varchar(20) default "";
select course into cname from students where id = cid;
select concat("Course name is ", cname);
end//

call courseName(3)//

-- 3.	Write a procedure that accepts a student name as input and retrieves the student ID using SELECT INTO and display the retrieved student ID.
create procedure studId(in sname varchar(20))
begin
declare sid int default 0;
select id into sid from students where name = sname;
select concat("Student id is", sid);
end//

call studId("Eva")//

-- 4.	Write a procedure that accepts a student ID as input and retrieves the average marks of that student using SELECT INTO and display the retrieved average marks.
create procedure avgMarks(in sname varchar(20))
begin
declare smark int default 0;
select avg(marks) into smark from students where name = sname;
select concat("Average marks are", smark);
end//

call avgMarks("Alice")//

-- 5.	Write a procedure that accepts a student name as input and retrieves the course of that student using SELECT INTO and display the retrieved course.
drop procedure courseDisplay//
create procedure courseDisplay(in sname varchar(20))
begin
declare coursenm varchar(30) default "";
select course into coursenm from students where name =  sname limit 1;
select concat("Course is ", coursenm);
end//

call courseDisplay("Bob")//

-- 1.	Write a procedure that retrieves the name of the topper student (highest marks) into an OUT parameter using SELECT INTO and display the retrieved name.
drop procedure topper//
create procedure topper(out sname varchar(20))
begin
select name into sname from students where marks =  (select max(marks) from students) limit 1;
end//

call topper(@sname)//
select @sname//

-- 2.	Write a procedure that retrieves the lowest marks scored by any student into an OUT parameter using SELECT INTO and display the retrieved marks.
create procedure loser(out sname varchar(20))
begin
select distinct name into sname from students where marks = (select min(marks) from students);
end//

call loser(@lname)//
select @lname//

-- 3.	Write a procedure that retrieves the total number of students into an OUT parameter using SELECT INTO and display the retrieved count.
create procedure numStud(out num int)
begin
select count(*) into num from students;
end//

call numStud(@scount)//
select @scount//

-- 4.	Write a procedure that retrieves the overall average marks of all students into an OUT parameter using SELECT INTO and display the retrieved average marks.
create procedure avgMarksStud(out markavg float)
begin
select avg(marks) into markavg from students;
end//

call avgMarksStud(@marks)//
select @marks//

-- 5.	Write a procedure that accepts a student ID as input and retrieves the course name of that student into an OUT parameter using SELECT INTO and display the retrieved course name.
create procedure cretriever(in sid int, out cname varchar(20))
begin
select course into cname from students where id = sid limit 1;
end //

call cretriever(1,@cname)//
select @cname//