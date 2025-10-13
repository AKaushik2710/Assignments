create database dac_dbt;
use dac_dbt;
create table dept(deptcode varchar(15), deptname varchar(60), budget integer); 
create table grade(gradecode varchar(15), gradelevel varchar(30), gradedescription varchar(60), basic integer); 
create table desig(desigcode varchar(15), designame varchar(15)); 
create table emp(empcode varchar(15), empname varchar(60), deptcode varchar(15) ,birthdate date  not null, joindate date  not null, sex char(1) check (sex in ('M', 'F', 'T')),desigcode varchar(15), supcode varchar(15), gradecode varchar(15),gradelevel varchar(30), basicpay integer); 
create table salary(empcode varchar(15),salmonth date not null,basic integer,allow integer,deduct integer); 
create table history(empcode varchar(15), changedate date not null, desigcode varchar(15), gradecode varchar(15), gradelevel varchar(30), basicpay integer); 
alter table desig add primary key(desigcode); 
alter table dept add primary key(deptcode); 
alter table emp add primary key(empcode); 
alter table grade add primary key(gradecode,gradelevel); 
alter table salary add primary key (empcode, salmonth); 
alter table history add primary key (empcode, changedate, desigcode, gradecode, gradelevel); 
alter table emp add foreign key(deptcode) references dept(deptcode); 
alter table emp add foreign key(desigcode) references desig(desigcode); 
alter table emp add foreign key(supcode) references emp(empcode); 
alter table emp add foreign key(gradecode,gradelevel) references grade(gradecode,gradelevel); 
alter table salary add foreign key (empcode) references emp(empcode); 
alter table history add foreign key (empcode) references emp (empcode); 
alter table history add foreign key (desigcode) references desig(desigcode); 
alter table history add foreign key (gradecode, gradelevel) references grade(gradecode, gradelevel); 
insert into dept (deptcode,deptname,budget) values('ACCT', 'Accounts', 19),
('PRCH', 'Purchase', 25),
('SALE', 'Sales', 39),
('STOR', 'Stores', 33),
('FACL', 'Facilities', 42),
('PERS', 'Personal', 12); 
insert into grade (gradecode,gradelevel,gradedescription,basic) values ('GC1',  'GL1', 'GC-GL-1',   25000),
('GC4',  'GL1', 'GC-4-GL-1', 21000),
('GC4',  'GL4', 'GC-4-GL-4', 15000),
('GC6',  'GL1', 'GC-6-GL-1', 13000),
('GC6',  'GL2', 'GC-6-GL-2', 11000),
('GC12', 'GL1', 'GC-12-GL-1', 9000),
('GC12', 'GL2', 'GC-12-GL-2', 8500),
('GC12', 'GL3', 'GC-12-GL-3', 8000),
('GC15', 'GL1', 'GC-15-GL-1', 7000),
('GC15', 'GL2', 'GC-15-GL-2', 6500),
('GC15', 'GL3', 'GC-15-GL-3', 6000),
('GC20', 'GL1', 'GC-20-GL-1', 3500),
('GC20', 'GL2', 'GC-20-GL-2', 3000),
('GC20', 'GL3', 'GC-20-GL-3', 2500),
('GC20', 'GL4', 'GC-20-GL-4', 2000); 
insert into desig(desigcode,designame) values ('CLRK', 'Clerk'),
('SLMN', 'Sales Man'),
('MNGR', 'Manager'),
('SPRV', 'Supervisor'),
('PRES', 'Personal'); 
insert into emp(empcode,empname,deptcode,birthdate,joindate,sex,desigcode,supcode,gradecode,gradelevel,basicpay) values ('7839', 'Reddy',  'ACCT', '1959-12-12', '1981-07-17', 'M', 'PRES',  null,  'GC1', 'GL1', 32000),
('7566', 'Jain',   'PRCH', '1955-01-24', '1981-04-02', 'F', 'MNGR', '7839', 'GC6', 'GL2', 12400),
('7698', 'Murthy', 'SALE', '1960-09-16', '1981-05-01', 'F', 'MNGR', '7839', 'GC6', 'GL1', 14700),
('7782', 'Menon',  'ACCT', '1967-08-30', '1981-06-09','M', 'MNGR', '7839', 'GC6', 'GL2', 12400),
('7902', 'Naik',   'PRCH', '1958-02-20', '1981-12-03', 'M', 'MNGR', '7839', 'GC6', 'GL2', 11800),
('7654', 'Gupta', 'SALE', '1957-01-22', '1981-09-28', 'M', 'SLMN', '7698', 'GC6', 'GL2', 12600),
('7521', 'Wilson', 'STOR', '1956-03-18', '1981-02-22', 'M', 'MNGR', '7698', 'GC6', 'GL2', 12200),
('7844', 'Singh',  'SALE', '1956-09-09', '1981-09-08', 'F', 'SLMN', '7698', 'GC6', 'GL1', 14300),
('7900', 'Shroff', 'SALE', '1956-06-28', '1981-12-03', 'M', 'CLRK', '7698', 'GC6', 'GL2', 12000),
('7788', 'Khan', 'PRCH', '1957-02-03', '1982-12-09', 'M', 'SPRV', '7566', 'GC6', 'GL2', 11900),
('7499', 'Roy', 'SALE', '1957-09-27', '1981-02-20', 'M', 'SLMN', '7698', 'GC6', 'GL1', 14200),
('7934', 'Kaul',   'ACCT', '1957-05-02', '1982-01-23', 'M', 'CLRK', '7782', 'GC6', 'GL2', 11950),
('7369', 'Shah',   'PRCH', '1960-05-25','1983-12-17', 'M', 'CLRK', '7902', 'GC6', 'GL2', 12200),
('7876', 'Patil',  'PRCH', '1965-09-02', '1990-12-17', 'M', 'CLRK', '7788', 'GC6', 'GL2', 12300),
('7999', 'Sinha',  'SALE', '1970-04-11', '1992-02-20', 'M', 'SLMN', '7782', 'GC6', 'GL1', 14600),
('7939', 'Rai',    'PRCH', '1988-08-10', '2012-12-06', 'M', 'CLRK', '7782', 'GC6', 'GL2', 11800),
('7192', 'John',   'ACCT', '1968-11-05', '1994-12-03', 'M', 'CLRK', '7902', 'GC6', 'GL2', 12300),
('9902', 'Ahmad',  'SALE', '1970-02-16', '1992-04-17', 'M', 'SLMN', '7698', 'GC6', 'GL1', 14200),
('7802', 'Sanghvi','STOR', '1980-05-06', '1993-01-01', 'M', 'MNGR', '7566', 'GC6', 'GL2', 12400),
('6569', 'Tiwari', 'STOR', '1989-08-19', '2010-08-21', 'M', 'MNGR', '7782', 'GC6', 'GL2', 12400); 
insert into salary(empcode,salmonth,basic,allow,deduct) values('7839', '2011-12-01', 30000, 3000, 1200),
('7839', '2012-01-01', 32000, 3200, 1250),
('7839', '2012-02-01', 32000, 3200, 1250),
('7566', '2011-12-01', 12000, 600,   400),
('7566', '2012-01-01', 12400, 1240,  550),
('7566', '2012-02-01', 12400, 1240,  550),
('7698', '2011-12-01', 13900, 800,   500),
('7698', '2012-01-01', 14700, 1470,  650),
('7698', '2012-02-01', 14700, 1470,  650),
('7782', '2011-12-01', 11800, 600,   500),
('7782', '2012-01-01', 12400, 1240,  550),
('7782', '2012-02-01', 12400, 1240,  550),
('7902', '2011-12-01', 11200, 600,   450),
('7902', '2012-01-01', 11800, 1180,  550),
('7902', '2012-02-01', 11800, 1180,  550),
('7654', '2011-12-01', 11900, 700,   500),
('7654', '2012-01-01', 12600, 1260,  550),
('7654', '2012-02-01', 12600, 1260,  550),
('7521', '2011-12-01', 11400,  800,  500),
('7521', '2012-01-01', 12200, 1220,  550),
('7521', '2012-02-01', 12200, 1220,  550),
('7844', '2011-12-01', 13400,  900,  600),
('7844', '2012-01-01', 14300, 1430,  650),
('7844', '2012-02-01', 14300, 1430,  650),
('7900', '2011-12-01', 11500,  500,  300),
('7900', '2012-01-01', 12000, 1200,  550),
('7900', '2012-02-01', 12000, 1200,  550),
('7788', '2011-12-01', 11300,  600,  450),
('7788', '2012-01-01', 11900, 1190,  550),
('7788', '2012-02-01', 11900, 1190,  550),
('7499', '2011-12-01', 13400,  800,  550),
('7499', '2012-01-01', 14200, 1420,  650),
('7499', '2012-02-01', 14200, 1420,  650),
('7934', '2011-12-01', 11450,  500,  250),
('7934', '2012-01-01', 11950, 1195,  550),
('7934', '2012-02-01', 11950, 1195,  550),
('7369', '2011-12-01', 11600,  600,  450),
('7369', '2012-01-01', 12200, 1220,  550),
('7369', '2012-02-01', 12200, 1220,  550),
('7876', '2011-12-01', 11700,  600,  500),
('7876', '2012-01-01', 12300, 1230,  550),
('7876', '2012-02-01', 12300, 1230,  550),
('7999', '2011-12-01', 13950,  650,  600),
('7999', '2012-01-01', 14600, 1460,  650),
('7999', '2012-02-01', 14600, 1460,  650),
('7939', '2011-12-01', 11100,  700,  400),
('7939', '2012-01-01', 11800, 1180,  550),
('7939', '2012-02-01', 11800, 1180,  550),
('7192', '2011-12-01', 11700,  600,  500),
('7192', '2012-01-01', 12300, 1230,  550),
('7192', '2012-02-01', 12300, 1230,  550),
('9902', '2011-12-01', 13400,  800,  500),
('9902', '2012-01-01', 14200, 1420,  650),
('9902', '2012-02-01', 14200, 1420,  650),
('7802', '2011-12-01',  11900,  500,  300),
('7802', '2012-01-01',  12400, 1240,  550),
('7802', '2012-02-01',  12400, 1240,  550),
('6569', '2011-12-01', 11800,  600,  400),
('6569', '2012-01-01', 12400, 1240,  550),
('6569', '2012-02-01', 12400, 1240,  550); 
insert into history (empcode,changedate,desigcode,gradecode,gradelevel,basicpay) values ( '7839', '1981-09-17',  'CLRK', 'GC15','GL1',  7000),
( '7839', '1985-12-31',  'SLMN', 'GC12','GL3',  8000),
( '7839', '1988-12-31',  'SPRV', 'GC12','GL2',  8500),
( '7839', '1990-12-31',  'MNGR', 'GC12','GL1',  9000),
( '7839', '1994-12-31',  'CLRK', 'GC6', 'GL2', 11000),
( '7839', '1998-12-31',  'SLMN', 'GC6', 'GL1', 13000),
( '7839', '2001-12-31',  'SPRV', 'GC4', 'GL4', 15000),
( '7839', '2006-12-31',  'MNGR', 'GC4', 'GL1', 21000),
( '7839', '2011-12-31',  'PRES', 'GC1', 'GL1', 25000),
( '7566', '1981-04-02',  'CLRK', 'GC12','GL3',  8000),
( '7566', '1991-12-31',  'SLMN', 'GC12','GL2',  8500),
( '7566', '2001-12-31',  'SPRV', 'GC12','GL1',  9000),
( '7566', '2011-12-31',  'MNGR', 'GC6', 'GL2', 11000),
( '7698', '1981-05-01',  'CLRK', 'GC12','GL3',  8000),
( '7698', '1991-05-01',  'SLMN', 'GC12','GL2',  8500),
( '7698', '2001-05-01',  'MNGR', 'GC12','GL1',  9000),
( '7698', '2006-05-01',  'SPRV', 'GC6', 'GL2', 11000),
( '7698', '2011-05-01',  'MNGR', 'GC6', 'GL1', 13000),
( '7782', '1981-06-09',  'CLRK', 'GC12','GL3',  8000),
( '7782', '1991-06-09',  'SLMN', 'GC12','GL2',  8500),
( '7782', '2001-06-09',  'SPRV', 'GC12','GL1',  9000),
( '7782', '2011-06-09',  'MNGR', 'GC6', 'GL2', 11000),
( '7902', '1981-12-03',  'CLRK', 'GC12','GL3',  8000),
( '7902', '1991-12-03',  'SLMN', 'GC12','GL2',  8500),
( '7902', '2001-12-03',  'SPRV', 'GC12','GL1',  9000),
( '7902', '2011-12-03',  'MNGR', 'GC6', 'GL2', 11000),
( '7654', '1981-09-28',  'SLMN', 'GC12','GL3',  8000),
( '7654', '1991-09-28',  'SLMN', 'GC12','GL2',  8500),
( '7654', '2001-09-28',  'SLMN', 'GC12','GL1',  9000),
( '7654', '2011-09-28',  'SLMN', 'GC6', 'GL2', 11000),
( '7521', '1981-02-22',  'CLRK', 'GC12','GL3',  8000),
( '7521', '1991-02-22',  'SLMN', 'GC12','GL2',  8500),
( '7521', '2001-02-22',  'SPRV', 'GC12','GL1',  9000),
( '7521', '2011-02-22',  'MNGR', 'GC6', 'GL2', 11000),
( '7844', '1981-09-08',  'SLMN', 'GC12','GL3',  8000),
( '7844', '1991-09-08',  'SLMN', 'GC12','GL2',  8500),
( '7844', '2001-09-08',  'SLMN', 'GC12','GL1',  9000),
( '7844', '2006-09-08',  'SLMN', 'GC6', 'GL2', 11000),
( '7844', '2011-09-08',  'SLMN', 'GC6', 'GL1', 13000),
( '7900', '1981-12-03',  'SLMN', 'GC12','GL3',  8000),
( '7900', '1991-12-03',  'SLMN', 'GC12','GL2',  8500),
( '7900', '2001-12-03',  'CLRK', 'GC12','GL1',  9000),
( '7900', '2011-12-03',  'CLRK', 'GC6', 'GL2', 11000),
( '7788', '1982-12-09',  'SLMN', 'GC12','GL3',  8000),
( '7788', '1992-12-09',  'CLRK', 'GC12','GL2',  8500),
( '7788', '2002-12-09',  'MNGR', 'GC12','GL1',  9000),
( '7788', '2012-12-09',  'SPRV', 'GC6', 'GL2', 11000),
( '7499', '1981-02-20',  'SLMN', 'GC12','GL3',  8000),
( '7499', '1991-02-20',  'SLMN', 'GC12','GL2',  8500),
( '7499', '2001-02-20',  'SLMN', 'GC12','GL1',  9000),
( '7499', '2006-02-20',  'SLMN', 'GC6', 'GL2', 11000),
( '7499', '2011-02-20',  'SLMN', 'GC6', 'GL1', 13000),
( '7934', '1982-01-23',  'SLMN', 'GC12','GL3',  8000),
( '7934', '1992-01-23',  'SLMN', 'GC12','GL2',  8500),
( '7934', '2002-01-23',  'CLRK', 'GC12','GL1',  9000),
( '7934', '2012-01-23',  'CLRK', 'GC6', 'GL2', 11000),
( '7369', '1983-12-17',  'SLMN', 'GC12','GL3',  8000),
( '7369', '1993-12-17',  'SLMN', 'GC12','GL2',  8500),
( '7369', '2003-12-17',  'CLRK', 'GC12','GL1',  9000),
( '7369', '2006-12-17',  'CLRK', 'GC6', 'GL2', 11000);
show tables;
--  1.List the name, employee code and designationcodeof each employee of the office
select * from emp;
select empname, empcode, desigcode from emp;

--  2.List all the departments and the budgets
select * from dept;

-- 3.List the employees and their respective department names
select empname, (select deptname from dept where emp.deptcode = dept.deptcode) as depNames from emp;

-- 4.List the employees who are not having any superior to work under
select * from emp;
select * from emp where supcode is null;

-- 5.List the employees who are working directly under superior most employee of the 
-- office. (Assume the superior most employee is the employee who does not have asupervisor)
select * from emp where supcode = (select empcode from emp where supcode is null);

-- 6.List the employee(s) who is senior most in the office
select * from emp where joindate = (select min(joindate) from emp);

-- 7.List the employees who will retire from the office next.
select * from emp where birthdate = (select min(birthdate) from emp);

-- 8.List the departments with the respective department managers
select deptcode, (select empname from emp where desigcode="MNGR" AND (emp.deptcode= dept.deptcode)) from dept ;
select * from dept;
select empname, (select * from dept where dept.deptcode = emp.deptcode) from emp where desigcode = "MNGR";
select * from dept union select empname from emp where desigcode = "MNGR";

-- 9.List the number of employees working for either ‘accounts’ or ‘personal’ or‘purchase’ departments
select count(*) from emp where emp.deptcode in ("ACCT", "PERS", "PRCH") ;

-- 10.List the employees working for ‘accounts’ or ‘personal’ department
select * from emp where emp.deptcode in ("ACCT", "PERS") ;

-- 11.List the employees working for ‘accounts’ and ‘personal’ department
select * from emp where emp.deptcode="ACCT" AND emp.deptcode="PERS";

-- 12.List the employees working for ‘accounts’ but not for ‘personal’ department
select * from emp where emp.deptcode = "ACCT" AND emp.deptcode != "pers";

-- 13.List the youngest employee of the office
select * from emp where birthdate = (select max(birthdate) from emp);

-- 14.List theemployees who are drawing basic pay not equal to 12400.
select * from emp where basicpay != 12400;

-- 15.List the employees who are drawing basic salary between 11000 and 12000.
select * from emp where basicpay between 11000 AND 12000;

-- 16.List the employees who are drawing basic salary not between 11000 and 12000
select * from emp where basicpay NOT between 11000 AND 12000;

-- 17.List the employees who got salary allowance between Rs.1000 to Rs.1500 in themonth of January 2012.
select * from emp;
select * from salary;
select count(*) from emp where empcode in (select empcode from salary where (allow between 1000 AND 1500) AND (salmonth>="2012-01-01" AND salmonth<="2012-01-31")); 

-- 18.List the employees whose name ends with ‘i’ or ‘y’.
select * from emp where empname like "%i" or empname like "%y";

-- 19.List the employees who have atleast 25 years of experience
select * from emp where joindate < (current_date - interval 25 year);-- 

-- 20.List the ‘Salesmen’ who have minimum 30 to 20 years of experience
select * from emp where deptcode="sale" and (curdate() - interval 25 year) <= joindate <= (curdate() - interval 30 year); 

-- 21.List the basic salary and half of the basic salary for each employee.
select empname,basicpay, (basicpay/2) as halfpay from emp;

-- 22.List the employees and the latest take-home-pay of each employee. (Hint: Take-home-pay = basic + allowance -deductions)
select f.*, (basic+allow-deduct) as takeHome from emp as f inner join salary s on f.empcode =  s.empcode where s.salmonth in (select max(salmonth) from salary);
select * from salary;

-- 23.List the employees and the latest take-home-pay of each employee of ‘Accounts’department.
select emp.*, (basic+allow-deduct) as takehome from emp, salary where (emp.deptcode="acct" and emp.empcode = salary.empcode) and salary.salmonth in (select max(salmonth) from salary);

-- 24.List employees and their respective ages.
select emp.*, timestampdiff(year, birthdate, curdate()) as age from emp;

-- 25.List all the ‘Accounts’ department employees, first ordered by their age and thenby their names.
select emp.*, timestampdiff(year, birthdate, curdate()) as age from emp where emp.deptcode="acct" order by empname, timestampdiff(year, birthdate, curdate());

-- 26.List the number of employees directly reporting to ‘Reddy’
select count(*) from emp where supcode = (select empcode from emp where empname="reddy");

-- 27.List the employees who have atleast one person workingunder him/her and thenumber of their subordinates. 
-- List the employee with highest number ofsubordinates first, next the person with next highest number of subordinates andso on.
select f.empname, count(*) as subordinates from emp f inner join emp l on f.empcode = l.supcode group by f.empname order by subordinates desc;

-- 28.List the employees who have minimum 3 employees working under him/her.
select f.empname, count(*) as subs from emp f inner join emp l on f.empcode = l.supcode group by f.empname having subs > 3;

-- 29.List the minimum and maximum salaries drawn in each grade code.
select max(basicpay), gradecode from emp group by gradecode;

-- 30.List the employees with names of their supervisors (Hint: Use Join).
select f.empname, l.empname as supervisor from emp f inner join emp l on f.supcode = l.empcode; 

-- 31.List the number of officers reporting to each supervisor having more than 3people working under them
use dac_dbt;
select count(empcode) from emp where empcode in (select e.empcode from emp e inner join emp s on e.empcode = s.supcode group by e.empcode having count(e.empcode)>3) and supcode is not null;
select f.empname, count(*) as subcount from emp f inner join emp l on f.empcode = l.supcode group by f.empname having subcount>3;
select count(empcode) from emp where empcode in (select e.empcode from emp e, emp s where e.empcode = s.supcode group by e.empcode having count(e.empcode) >3 ) and supcode is not null;

-- 32.List the employees who have not got any promotion till now.
select * from emp where empcode not in (select distinct empcode from history);
select e.empcode, e.empname from emp e where e.empcode not in (select distinct empcode from history);

-- 33.List the employee with maximum number of promotions. Also list the number ofpromotions that he/she got.
select e.empcode, e.empname, count(h.empcode) as cn from emp e, history h where e.empcode = h.empcode group by e.empcode, e.empname order by cn desc limit 1;
select empcode, count(empcode) as emcount from history group by empcode order by emcount desc  limit 1;

-- 34.List the employees who got promoted in the year 1991.
select * from history;
select * from emp where  empcode in (select empcode from history where year(changedate) = 1991);
select * from emp where empcode in (select empcode from history where year(changedate)=1991);

-- 35.List the department budget and the total salary drawn (by theemployees of thisdepartment).
use dac_dbt;
show tables;
select * from emp, salary, dept;
select * from emp;
select deptcode, count(deptcode) from emp e group by deptcode;
select * from dept;
select d.deptcode, d.budget, sum(e.basicpay) from dept d, emp e where d.deptcode = e.deptcode group by d.deptcode;

-- 36.Display the employee names in full uppercase.
select upper(empname) from emp;

-- 37.List all the employees drawing salary higher than the salary drawn by ‘Jain’
select * from emp where basicpay > (select basicpay from emp where empname="jain");
select e.empcode from emp e, salary s where e.empcode = s.empcode group by e.empcode having max(s.salmonth);
select e.emp
name, (s.basic+s.allow-s.deduct) as sal from salary s, emp e where s.salmonth in (select max(salmonth) from salary group by empcode);

-- 38.List all the employees who have higher salary than all the employees who drawsalary in the range of 11000 to 12000.
select * from emp where basicpay > 12000;

-- 39.List all the employees who have greater than average pay. Display the result in theincreasing order of the salary.
select *  from emp where basicpay > (select avg(basicpay) from emp) order by basicpay;
select e.*, s.basic+s.allow-s.deduct from emp e, salary s where s.basic+s.allow-s.deduct > (select avg(s.basic+s.allow-s.deduct) from salary s) and e.empcode =  s.empcode and s.salmonth in (select max(salmonth) from salary) order by s.basic+s.allow-s.deduct;

-- 40.List the employees who draws highest salary
select * from emp where basicpay = (select max(basicpay) from emp);

-- 41.List all the employees other than the employees who draw highest salary
select * from emp where basicpay != (select max(basicpay) from emp);

-- 42.List the employees who draw highest salary in each department
select deptcode, basicpay from emp e group by deptcode, basicpay having basicpay = max(basicpay);
select e.* from emp e where e.basicpay in (select max(e.basicpay) from emp e group by e.deptcode);
select * from emp where basicpay in (select max(e.basicpay) from emp e inner join emp  m on e.deptcode = m.deptcode group by e.deptcode);
select e.deptcode, max(e.basicpay) from emp e inner join emp  m on e.deptcode = m.deptcode group by e.deptcode;

-- 43.List the employee(s) getting second highest salary
select max(basicpay) from emp where basicpay not in (select max(basicpay) from emp );

-- 44.List the employee(s) who are getting fifth highest salary.
select * from emp where basicsal in (select basicsal from emp order by basicsal desc limit 5) order by basicsal asc limit 1;
select  min(basicpay) from emp where basicpay in (select basicpay from emp order by basicpay desc);

-- 45.List the department name of the female employee who draws the highest salaryhigherthan any other female employee
select * from emp where basicpay = (select max(basicpay) from emp where sex = 'f');
select deptcode from emp where empcode in (select  empcode from emp group by empcode having max(basicpay) and sex = "f");

-- 46.List all male employees who draw salary greater than atleast on female employee
select * from emp where basicpay > (select min(basicpay) from emp where sex = 'f') and sex = 'm';

-- 47.List the departments in which average salary of employees is more than averagesalary of the company
select avg(basicpay) from emp group by deptcode;

-- 48.List the employees drawing salary lesser than the average salary of employeesworking for ‘accounts’ 
select * from emp where basicpay < (select avg(basicpay) from emp where deptcode = "acct") and deptcode !="acct";
select * from emp where basicpay < (select avg(basicpay) from emp where deptcode="acct") and deptcode != "acct";