CREATE TABLE ers.employee (
	id SERIAL NOT NULL,
	password CHARACTER VARYING(100) NOT NULL,  -- abbrev VARCHAR
	login CHARACTER VARYING(100) NOT NULL,-- 4 digits total, 2 after the decimal point
	title CHARACTER VARYING(100) NOT NULL,
	email CHARACTER VARYING(100) NOT NULL,
	firstName CHARACTER VARYING(100) NOT NULL,
	LastName CHARACTER VARYING(100) NOT NULL
	
);

CREATE TABLE ers.manager (
	id SERIAL NOT NULL,
	password CHARACTER VARYING(100) NOT NULL,  -- abbrev VARCHAR
	login CHARACTER VARYING(100) NOT NULL UNIQUE,-- 4 digits total, 2 after the decimal point
	title CHARACTER VARYING(100) NOT NULL,
	email CHARACTER VARYING(100) NOT NULL UNIQUE,
	firstName CHARACTER VARYING(100) NOT NULL,
	LastName CHARACTER VARYING(100) NOT NULL
	
);

CREATE TABLE ers.reinbursmentRequest (
	reinburse_id SERIAL NOT NULL,
	reinburse_amount NUMBER NOT NULL,
	reinburse_Request TIMESTAMP,
	reinburse_Complete TIMESTAMP,
	Id_employee_requester int  NOT NULL,
	requestStatus CHARACTER VARYING(100) NOT NULL
	
	
);
CREATE TABLE ers.status  (
	manager_Login_id  CHARACTER VARYING(100) NOT NULL UNIQUE,
	manager_email CHARACTER VARYING(100) NOT NULL UNIQUE,
	reinburse_status_id NUMBER NOT NULL,
	reinburse_status Character varying(100)

	
	
);