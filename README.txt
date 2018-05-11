//Application written using Maven, with Spring Boot, Spring Data and Spring Security for login.

1. ER is under the "ER" directory 
(Note: the VOTE_POOL table has 2 FK's which are the candidate/committee respectevily. These can have Null values since user can
vote either by candidate or committe)
DB script is under the "sql-script" directory
*db name = mydb
*user = root
*password = root

2.The application is called "votingapp"
It has the entitites mapped with spring security configured 
when running you can sign in with username: lasusie - password: root and try a different user/password to test this
you will see the dashboard screen but it doesnt have the functionality at UI level configured [had thought to build it using thymeleaf]
you can not register users and you cant vote as well.

This is what I have built and what I can deliver given the circumstances.

