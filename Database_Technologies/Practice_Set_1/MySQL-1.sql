use dac_dbt;
-- 1. Write a stored procedure that accepts two numbers as IN parameters and displays their sum.
delimiter //
create procedure sumOfNum(in num1 int, num2 int)
begin
select num1+num2 as sum;
end//

call sumOfNum(43, 5)//

-- 2. Write a stored procedure that accepts one number as IN parameter and displays whether it is even or odd.

create procedure oddOrEven(in num int)
begin
if num%2=0 then
select concat(num, " is even");
elseif num%2!=0 then
select concat(num, " is odd");
else
select concat("Invalid");
end if;
end//

call oddOrEven(3)//

-- 3. Write a stored procedure that accepts a string as IN parameter and displays the string in uppercase.
create procedure uppercase(in str varchar(30))
begin
select upper(str);
end//

call uppercase("aman")//

-- 4. Write a stored procedure that accepts a number N and prints the factorial of N.
drop procedure factorial//
create procedure factorial(in num int)
begin
declare x int default 0;
declare y int default 1;
set x = num;
while x>1 do
set y = y*x;
set x = x-1;
end while;
select y;
end//

call factorial(4)//

-- 5. Write a stored procedure that accepts a number as IN parameter and prints the multiplication table of that number (up to 10).
drop procedure numTable//
create procedure numTable(in num int)
begin
declare x int default 1;
declare y varchar(256) default "";
while x <= 10 do
set y = concat(y, " ",(num * x));
set x = x+1;
end while;
select y;
end //

call numTable(5)//

use dac_dbt//
-- 1. Write a stored procedure that accepts an employee_id and displays the employee’s name and salary from the employees table.
create procedure empdet(in eid int)
begin
select empname, basicpay from emp where empcode = eid;
end//

call empdet(7369)//

-- 2. Write a stored procedure that accepts a department_id and displays the count of employees in that department from the employees table.
create procedure empCounter(in dep varchar(20))
begin
select count(*) from emp where deptcode = dep group by deptcode;
end//

call empCounter("SALE")//

-- 3. Write a stored procedure that accepts a customer_id and displays all orders placed by that customer from the orders table.
-- 4. Write a stored procedure that accepts a product_id and displays the product name and current stock quantity from the products table.
-- 5. Write a stored procedure that accepts a student_id and displays the student’s marks and grade from the students table.