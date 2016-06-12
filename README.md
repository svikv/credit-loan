Project created by Viktor Somka

To startup project you need:

    1) Download JDK 1.8 from http://www.oracle.com/technetwork/java/javase/downloads/index.html and install it using following instructions http://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html;
    2) Download Maven from https://maven.apache.org/ and install it using following instructions https://maven.apache.org/install.html;
    3) Download MySQL server (at least v5) from http://dev.mysql.com/downloads/mysql/ and install it;
    4) Create database using scripts from src\main\resources\sql-scripts and execute command mysql -u {username} -p{password} {dbName} < {script-file-name}. Next scripts are available:
        'Web-tester-schema_only-date.sql - includes only database schema;
        'Web-tester-test_data-date.sql' - includes database schema with test data;
    5) User has ability to log in as OPERATOR or MANAGER. When using test data use the following credentials:
        OPERATOR: email - 'svikv84@mail.com'; password - 's';
        MANAGER: email - 'manager@mail.com'; password - '1234';
    6) Set properties value for database connection in src\main\resources\datasource.properties;
    7) Run application using Maven Tomcat plugin. For this purpose execute mvn tomcat7:run command in project root folder.
