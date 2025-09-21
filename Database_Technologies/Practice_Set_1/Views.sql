show databases;
use dac_dbt;
create view empage(empcode, age) as (select empcode, timestampdiff(year, birthdate, curdate()) from emp);
show tables;
drop view empage;
select * from salary;
select empcode, sum(basic+allow-deduct) from salary group by empcode having salmonth in (select max(salmonth) from salary );
select f.empcode, e.deptcode, (basic+allow-deduct) as sty from salary f inner join emp e on e.empcode = f.empcode where f.salmonth in (select  max(salmonth) from salary) group by sty;
create view salaries(deptcode, salary) as (select empcode, sum(basicsal+allow-deduct) from salary group by deptcode);
select * from emp;

-- 1. Write a view to compute the employee age of the organization 
select * from empAge;
create view empAge(employees, age) as (select empname, timestampdiff(year, birthdate, curdate()) from emp);

-- 2. Write a view to compute the employee experience with the organization 
create view empExp(employees, exp) as (select empname, timestampdiff(year, joindate, curdate()) from emp);
select  * from empExp; 

-- 3. Write a view that computes the employee pay for the current month for all the employees. Hint: Compute the employee pay as the Basic+Allowance-Deduction 
create view empCurrentSal(empname, empcode, currentSal) as (select e.empname, e.empcode, (s.basic+s.allow-s.deduct) as sal from emp as e inner join salary as s where s.empcode = e.empcode and s.salmonth in (select max(salmonth) from salary));
select * from empcurrentSal;
drop view empcurrentsal;

-- 4. List the employees who are older than their supervisors. Hint: Use views to implement employeeage 
create view ageSeniority(empname) as (select empname from emp where (select timestampdiff(year, birthdate, curdate()) from emp) > (select timestampdiff(year, birthdate, curdate())));
select f.empcode, f.empname, f.supcode, l.empname from emp f inner join emp l on f.supcode = l.empcode where f.supcode in (select empcode from emp);
select f.empname, count(l.supcode) from emp f inner join emp l where f.empcode = l.supcode group by f.empname;
select * from emp;

-- 5. Write a view to display the total number of employees in each department 
select * from dept;
drop view totalEmp;
alter view totalEmp(deptCode, deptName, numberEmp) as (select e.deptcode, d.deptname, count(e.empcode) from emp e inner join dept d on e.deptcode =  d.deptcode group by deptcode);
select * from totalEmp;

-- 6. Write a view to display the total number of employees in the organization 
alter view totalEmpOrg(total) as (select count(empcode) from emp);
select *  from totalEmpOrg;

-- 7. Use the views in Qn No 5 & Qn No 6, to display the percentage of employees in each department
create view empPercent(deptname, percent) as (select d.deptname, d.numberEmp/t.total*100 from totalEmp d, totalEmpOrg t);
select * from empPercent;
drop view empPercent;