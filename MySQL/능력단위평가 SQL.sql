# 1.
CREATE DATABASE HumanResource;

# 2.
USE HumanResource;

# 3.
CREATE TABLE Department (
    department_code VARCHAR(10) PRIMARY KEY,
    department_name VARCHAR(25) NOT NULL,
    department_tel_number VARCHAR(25) UNIQUE NOT NULL,
    department_address VARCHAR(100) NOT NULL,
    head_employee_number VARCHAR(25)
);

CREATE TABLE Posit (
    position_code VARCHAR(10) PRIMARY KEY,
    position_name VARCHAR(25) NOT NULL
);

CREATE TABLE Employee (
    employee_number VARCHAR(25) PRIMARY KEY,
    employee_name VARCHAR(25) NOT NULL,
    employee_birth_date DATETIME NOT NULL,
    employee_tel_number VARCHAR(25) UNIQUE NOT NULL,
    employee_address VARCHAR(100) NOT NULL,
    department_code VARCHAR(10),
    position_code VARCHAR(10)
);

-------------------------------------------

#4.
    ALTER TABLE Employee ADD CONSTRAINT foreign_key_1 FOREIGN KEY (department_code)
        REFERENCES Department (department_code);
    ALTER TABLE Employee ADD CONSTRAINT foreign_key_2 FOREIGN KEY (position_code)
        REFERENCES Posit (position_code);
	CREATE TABLE Annual_Income (
    department_code VARCHAR(10),
    position_code VARCHAR(10),
    annual_income_amount INT NOT NULL,
    CONSTRAINT foreign_key_3 FOREIGN KEY (department_code)
        REFERENCES Department (department_code),
    CONSTRAINT foreign_key_4 FOREIGN KEY (position_code)
        REFERENCES Employee (position_code)
);

#5
INSERT INTO Department VALUES ('DEV', '개발부', '051-240-1155','부산광역시 부산진구', '2023010101');
INSERT INTO Posit VALUES ('PO1', '사원');
INSERT INTO Employee VALUES ('2023010101', 'John Doe', '1980-11-12','010-9184-6574', '부산광역시 부산진구', 'DEV', 'PO1');
INSERT INTO Annual_Income VALUES ('DEV', 'PO1', 38000000);

#6
SELECT D.department_code, D.department_name, E.employee_name, E.employee_tel_number FROM Department D JOIN Employee E WHERE D.department_code = 'DEV';

#7
INSERT INTO Employee VALUES ('2023010102', 'raynor seo', '1993-06-02','010-4736-1346', '부산광역시 서구', 'DEV', 'PO1');
COMMIT;

#8
CREATE INDEX employee_index ON Employee(department_code,position_code);

#9
CREATE VIEW head_employee_search AS
    SELECT 
        D.department_code,
        D.department_name,
        E.employee_name,
        E.employee_tel_number
    FROM
        Department D
            JOIN
        Employee E
    WHERE
        D.department_code = 'DEV';
