-- 1. Create course table with the following fields a. course_id , type integer, Primary keyb. course_name type varchar(20)
drop table course;
create table course(course_id int primary key, course_name varchar(20));
start transaction;
-- 2. Insert the following records in course table (1, DBT)(2,OS)(3,JAVA)(4, Data structure)
insert into course values(1, 'DBT'),(2, 'OS'),(3, 'JAVA'),(4, 'Data Structure');

-- 3. Create a savepoint insertion
savepoint insertion;

-- 4. delete the record -DBT and OS 
delete from course where course_id in (1,2);

-- 5. Create savepoint deletion
savepoint deletion;
select * from course;

-- 6.Roll back to deletion
rollback to deletion;

-- 7. Insert the following record (5, Algorithms)
insert into course values(5, 'Algorithms');

-- 8.Rollback to insertion
rollback to insertion;

-- 9. complete Rollback 
rollback;