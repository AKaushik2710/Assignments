-- 1.Create a trigger after insert statement for emp table to insert the value into table only if join date is not older than 40 . 
delimiter $
create trigger t1 before insert 
on emp 
for each row 
if timestampdiff(year, new.birthdate, curdate()) < 40 then 
signal sqlstate '50001' set message_text='empp must be  older than 40'; 
end if; $
DELIMITER ;

-- 2.Insert a value to activate the trigger check 
insert into emp values(1001, 'Aman','Acct', '2002-12-27', '2018-06-02', 'M', 'MNGR', 7782, 'GC6', 'GL2', 10000);

-- 3.Create a table average_age, Insert the average age of the employee into this table. 
create table average_age (avrg float);
drop table average_age;
select * from average_age;
insert into average_age (avrg) select avg(age) from empage;

-- 4.Create an AFTER INSERT trigger on the emp table to update the average_age table after insert 
delimiter //
create trigger aft after insert
on emp 
for each row begin
update average_age set avrg = (select avg(timestampdiff(year, birthdate, curdate())) from emp);
end; //
delimiter ;

-- 5.Insert a value to activates the trigger check: 
use dac_dbt;
insert into emp values(1002, 'Kaushik','Acct', '1946-12-27', '2015-06-02', 'M', 'MNGR', 7782, 'GC6', 'GL2', 10000);
insert into emp values(1101, "AK", 'STOR', '1969-11-05', '2009-08-01', 'M', 'PRES', null, 'GC6', 'GL2', 72000);

-- 6.Add a BEFORE UPDATE trigger to the emp  table to check the age value (age should be more than 18) before inserting data into the emp  table 
delimiter //
create trigger bft before insert
on emp
for each row 
if timestampdiff(year, new.birthdate, curdate()) < 18 then
signal sqlstate '50001' set message_text=' Employee must be older than 18' ;
end if; //
delimiter ;
drop trigger bft;

-- 7.Updating an existing value activates the trigger check 
update emp set birthdate='2012-01-01' where empcode=1002;
delete from emp where empcode=1101;
insert into emp values(1003, 'KK','Acct', '2016-12-27', '2015-06-02', 'M', 'clrk', 7782, 'GC6', 'GL2', 10000);

-- 8.Create a table called emp_archive with samecolumns as emp table. 
create table emp_archive(empcode varchar(15), empname varchar(60), deptcode varchar(15) ,birthdate date  not null, joindate date  not null, sex char(1) check (sex in ('M', 'F', 'T')),desigcode varchar(15), supcode varchar(15), gradecode varchar(15),gradelevel varchar(30), basicpay integer); 

-- 9.Insert a new (which is does not exist in emp table) record into emp table 
insert into emp values(1001, 'Aman','Acct', '1946-12-27', '2015-06-02', 'M', 'MNGR', 7782, 'GC6', 'GL2', 10000);
delete from emp_archive;

-- 10.Create   a BEFORE DELETE trigger on the table emp and insert the values into the emp_archive table 
delimiter //
drop trigger delToins//
create trigger delToins before delete
on emp
for each row begin
insert into emp_archive select * from emp where empcode=old.empcode ;
end; //
delimiter ; 

-- 11.Delete the record inserted at step no 9 
delete from emp where empcode=1002;

-- 12.Display emp_archive table to check the trigger before delete 
select * from emp_archive;

-- 13.Create an AFTER DELETE trigger on the table emp to update the average_age table with the new information 
-- (i.e whenever you delete a record from emp table, average_age should get updated) 
show tables;
select * from average_age;
delimiter //
create trigger delToupd after delete
on emp
for each row begin
update average_age set avrg = (select avg(timestampdiff(year, birthdate, curdate())) from emp );
end; //
delimiter ;

-- 14.Delete a value to check the above trigger
delete from emp where empcode=1002;