SET search_path TO ers, public;

CREATE TABLE ers.employee (
	id SERIAL NOT NULL,
	password CHARACTER VARYING(100) NOT NULL,  -- abbrev VARCHAR
	login CHARACTER VARYING(100) NOT NULL,-- 4 digits total, 2 after the decimal point
	title CHARACTER VARYING(100) NOT NULL,
	email CHARACTER VARYING(100) NOT NULL,
	firstName CHARACTER VARYING(100) NOT NULL,
	LastName CHARACTER VARYING(100) NOT NULL
	CONSTRAINT pk_employees PRIMARY KEY  (id)
	
);

CREATE TABLE ers.manager (
	id SERIAL NOT NULL,
	password CHARACTER VARYING(100) NOT NULL,  
	login CHARACTER VARYING(100) NOT NULL UNIQUE,
	title CHARACTER VARYING(100) NOT NULL,
	email CHARACTER VARYING(100) NOT NULL UNIQUE,
	firstName CHARACTER VARYING(100) NOT NULL,
	LastName CHARACTER VARYING(100) NOT NULL
	CONSTRAINT pk_managers PRIMARY KEY  (id)
	
);

CREATE TABLE ers.reinbursmentRequest (
	reinburse_id SERIAL NOT NULL,
	Id_employee_requester int  NOT NULL,
	reinburse_amount INT NOT NULL,
	reinburse_Request_Pending BOOLEAN Default true,
	reinburse_Complete BOOLEAN DEFAULT false,
	reinbure_Approved BOOLEAN Default false,
	Completed_By int null,
	recipt bytea null,
	CONSTRAINT pk_reimbursement_id PRIMARY KEY  (reinburse_id),
	CONSTRAINT fk_employee_id FOREIGN KEY  (Id_employee_requester) REFERENCES employee(id),
	CONSTRAINT fk_manager_id FOREIGN KEY  (Completed_By) REFERENCES manager(id)
	
	
);
