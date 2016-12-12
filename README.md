# Database-Management-System

This is a database management system developed in java .
The advantages of this dbms is that it works very well for those who don't know sql making it easier for them to creating a query and retireve the information and this is also great tool from the perspective of learning.


When application is started the user enters into a login page where user credentials are asked.This provides each user his/her own workspace providing isolation between different users.The username root holds total control.

Then we enter into a page where we have our 6 different modules.
The dbms has six basic modules:
1.Insert table
2.update table
3.alter table
4.create table
5.drop table
6.delete table
7.Select Table

Alter Table:
This module used to alter the table's schema like the add column name,the constraint and we can also modify the column.

The is prompted for input after provding the tablename if there is no such table an error information is flashed in the interface to the user and if there is any table the schema of the table provided to the user.The user is provided options to add/drop the columns adn as well define the constraints on the value through the user_panel.

Once user submits all the data as per his/her requirements the the changes are reflected in database and shown as a message to the user if there was any discrepency then error is alos shown to the user so that he/she can correct it.

Drop Table:

This module allows the user to drop a table ,it is very useful in cases were we accidently create table.The user enters the table to be dropped it the table exsists and if it isn't refernced by any other table then it can be or else error message is shown to the user.

Insert Data:

The user first insert the tablename if the table is present then the columns are genertated based on the number of colums present in the schema for that table.

User will input the data into the specific columns provided in the order specified in the schema in the visual panel.

After INsertion of the data as the user's requiremts the submit transfers the data sql compiler the compiler checks all the neccesary constraints and insert the data if it is correct or else error message is thrown at the visual panel.

Create table:

The Tables can be created by entering the required table name and the number columns required as per the demands if there already exsists such table an error message is at the visual panel.

If there doesnt exsists any such table then an temporary query is built at the backend , as per the user's request for columns the same number of textboxes are made avalible to the user for the creating table with required constraints.

if there is are any input errors like the invalid cinstraints are passed on as data input error is reported and the table is not created.  

Update table:

We can update the contents in the table using this module this includes the all data not the schema(use alter module for this)

delete table:

LOL this name is quite ironical but it actually deleted record from the table.

Select table:

This used by user to extract the required information with all possible with any worry of the syntax the backend is modified in such a way that the working is restircted so the user cannot fire a wrong query.
