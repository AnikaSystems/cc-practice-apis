-- create 	schema interp_case;

CREATE SCHEMA IF NOT EXISTS interp_case;

alter schema interp_case owner to dev_postgres_user;

GRANT ALL ON SCHEMA interp_case TO dev_postgres_user;
GRANT USAGE ON SCHEMA interp_case to dev_postgres_user;

alter role dev_postgres_user set search_path = interp_case, public;

set search_path = interp_case;


-- create table temp_table (fielda varchar(10), numeral int, iswitch BOOLEAN);

-- drop table temp_table;

CREATE TABLE end_user (
  user_id serial  PRIMARY KEY,
  user_acct_name varchar(20) NOT NULL,
  user_pw varchar(20) NOT NULL, 
  user_first_name varchar(100) NOT NULL,
  user_last_name varchar(100) NOT NULL,
  user_address varchar(400),
  user_phone varchar(15),
  user_email varchar(100),
  user_type varchar(20)
);

comment on column end_user.user_id is 'The Users generated ID Number' ;
comment on column end_user.user_acct_name is 'The Users Login Acct' ;
comment on column end_user.user_first_name is 'The Users First Name' ;
comment on column end_user.user_last_name is 'The Users Last Name';
comment on column end_user.user_address is 'The Users Address';
comment on column end_user.user_phone is 'The Users Phone No';
comment on column end_user.user_email is 'The Users Email Address';
comment on column end_user.user_type is 'The Users type ex…end, officer, casemgr';

CREATE TABLE officer (
  officer_id serial  PRIMARY KEY,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  is_supervisor BOOLEAN, 
  officer_phone varchar(15),
  officer_email varchar(30), 
  officer_field_office varchar(200),
  officer_sig varchar(200),
  officer_sig_doc_path varchar(100),
  officer_sig_doc_file_id varchar(50)
);

comment on column officer.officer_id is 'The Officers generated ID Number' ;
comment on column officer.first_name is 'The Officers First Name' ;
comment on column officer.last_name is 'The Officers Last Name';
comment on column officer.is_supervisor is 'The Officers is Supervisor';

comment on column officer.officer_phone is 'The Officers Phone No';
comment on column officer.officer_email is 'The Officers Email';
comment on column officer.officer_field_office is 'The Officers Field Office' ;
comment on column officer.officer_sig is 'The Officers sig file ID' ;
comment on column officer.officer_sig_doc_path is 'The relative path to Officers CDN Officers sig file';
comment on column officer.officer_sig_doc_file_id is 'The Officers sig file ID' ;


CREATE TABLE case_manager (
  cm_id serial  PRIMARY KEY,
  cm_acct_name varchar(20) NOT NULL,
  cm_pw varchar(20) NOT NULL, 
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  dept_number varchar(9),
  cm_sig varchar(200),
  cm_sig_doc_path varchar(100),
  cm_sig_doc_file_id varchar(50) 
);

comment on column case_manager.cm_id is 'The Case Managers generated ID Number';
comment on column case_manager.cm_acct_name is 'Case Managers Login';
comment on column case_manager.first_name is 'The Case Managers First Name';
comment on column case_manager.last_name is 'The Case Managers Last Name';
comment on column case_manager.dept_number is 'The Case Managers Department';
comment on column case_manager.cm_sig is 'The Case Managers sig file ID';
comment on column case_manager.cm_sig_doc_path is 'The relative path to Case Managers CDN Officers sig file';
comment on column case_manager.cm_sig_doc_file_id is 'The Case Managers sig file ID' ;


CREATE TABLE interview_subject (
  subject_id serial  PRIMARY KEY,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  alien_reg_number varchar(9),
  native_langs  varchar(100)
);

comment on column interview_subject.subject_id is 'The Subjects generated ID Number';
comment on column interview_subject.first_name is 'The Subjects First Name';
comment on column interview_subject.last_name is 'The Subjects Last Name';
comment on column interview_subject.alien_reg_number is 'The Subjects Alien Registration No if known' ;
comment on column interview_subject.native_langs is 'The Subjects Native Languages';



CREATE TABLE interpreter (
  interpreter_id serial  PRIMARY KEY,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  interp_address varchar (400),
  interp_phone varchar (15), 
  id_doc BYTEA, 
  id_doc_path varchar (100),
  id_doc_file_id varchar(50)
);

comment on column interpreter.interpreter_id is 'The Interpreters generated ID Number';
comment on column interpreter.first_name is 'The Interpreters First Name';
comment on column interpreter.last_name is 'The Interpreters Last Name';
comment on column interpreter.interp_address is 'The Interpreters Address';
comment on column interpreter.interp_phone is 'The Interpreters Phone Number';
comment on column interpreter.id_doc is 'The Interpreters attached Identity Document if loaded into table';
comment on column interpreter.id_doc_path is 'CDN file path for pdf Interpreters Identity Doc' ;
comment on column interpreter.id_doc_file_id is 'File name of Interpreters Identity Doc';



CREATE TABLE interp_iview_case(
  case_id serial PRIMARY KEY,
  user_id_fk INT,
  cm_id_fk serial,
  subect_id_fk INT,
  interpreter_id_fk INT, 
  interp_id_doc_attach BOOLEAN,
  subject_declare_sig  varchar(200),
  subject_dec_sig_doc_path varchar(100), 
  subject_dec_sig_doc_file_id varchar(50), 
  interp_declare_sig varchar(200),
  interp_dec_sig_doc_path varchar(100),
  interp_dec_sig_doc_file_id varchar(50),
  interp_declare_date date,
  officer_id_fk INT,
  officer_declare_date date,
  officer_declare_sig varchar(200),
  officer_dec_sig_doc_path varchar(100),
  officer_dec_sig_doc_file_id varchar(50),
  officer_declare_entered_name varchar(200), 
  officer_field_office varchar(200),
  interp_dq boolean,
  interp_dq_reason varchar(2000),
  subject_dq_name  varchar(200),
  dq_reschedule boolean,
  officer_dq_sig varchar(200),
  officer_dq_sig_doc_path varchar (100),
  officer_dq_sig_doc_file_id varchar(50),
  officer_dq_entered_name varchar(200), 
  superv_dq_sig varchar(200),
  superv_dq_sig_doc_path varchar(100),
  superv_dq_sig_doc_file_id varchar(50),
  superv_dq_entered_name varchar(200), 
  continue_wo_interpreter boolean, 
  officer_wd_sig varchar(200),  
  officer_wd_sig_doc_path varchar (100),
  officer_wd_sig_doc_file_id varchar(50),
  officer_wd_entered_name varchar(200), 
  subject_wd_sig  varchar(200),
  subject_wd_sig_doc_path varchar(100),
  subject_wd_sig_doc_file_id varchar(50),
  subject_wd_entered_name varchar(200), 
  case_status_code INT,
  case_status_value varchar(50),
  case_update_date timestamp,
  -- CONSTRAINT check_update_date CHECK ((case_update_date <= CURRENT_DATE)),
  CONSTRAINT fk_user FOREIGN KEY(user_id_fk) REFERENCES end_user(user_id),
  CONSTRAINT fk_case_mgr FOREIGN KEY(cm_id_fk) REFERENCES case_manager(cm_id),
  CONSTRAINT fk_subject FOREIGN KEY(subect_id_fk) REFERENCES interview_subject(subject_id),
  CONSTRAINT fk_interpreter FOREIGN KEY(interpreter_id_fk) REFERENCES interpreter(interpreter_id),
  CONSTRAINT fk_officer FOREIGN KEY(officer_id_fk) REFERENCES officer(officer_id)
);

/* This section of comments reflects fields in Interviewee Section */

comment on column interp_iview_case.case_id is 'The case ID and PK';
comment on column interp_iview_case.subect_id_fk is 'The FK to the Interviewee table interview_subject' ;
comment on column interp_iview_case.interpreter_id_fk is 'TheThe FK to the Interpreter table interpreter';
comment on column interp_iview_case.interp_id_doc_attach is 'The Y/N indicator for attached Interpreter ID attached';
comment on column interp_iview_case.subject_declare_sig is 'The Interviewees Signature Declaration';
comment on column interp_iview_case.subject_dec_sig_doc_path is 'The relative path to CDN Interviewees sig file' ;
comment on column interp_iview_case.subject_dec_sig_doc_file_id is 'The Interviewees sig file ID';


/* This section of comments reflects fields in  Interpreter Declaration Section */
comment on column interp_iview_case.interp_declare_sig is 'The Interpreters Declaration Signature' ;
comment on column interp_iview_case.interp_dec_sig_doc_path is 'The relative path to CDN Interpreters sig file';
comment on column interp_iview_case.interp_dec_sig_doc_file_id is 'The Interpreters sig file ID' ;
comment on column interp_iview_case.interp_declare_date is 'The Interpreters sig declaration date';

/* This section of comments reflects fields in Officers Declaration Section */
comment on column interp_iview_case.officer_declare_date is 'The Officers sig declaration date witness subject and interpreter' ;
comment on column interp_iview_case.officer_declare_sig is 'The Officers declaration signature' ;
comment on column interp_iview_case.officer_dec_sig_doc_path is 'The relative path to CDN Officers sig file';
comment on column interp_iview_case.officer_dec_sig_doc_file_id is 'The Officers sig file ID' ;
comment on column interp_iview_case.officer_declare_entered_name is 'The Officers Name Typed Entered' ;
comment on column interp_iview_case.officer_field_office is 'The Officers Field Office' ;

/* This section of comments reflects fields in Interpreter Disqualification Section */
comment on column interp_iview_case.interp_dq is 'The indicator for Interpreter disqualified';
comment on column interp_iview_case.interp_dq_reason is 'The Interpreter disqualified Reason text' ;

comment on column interp_iview_case.subject_dq_name is 'The Subject Attest Name from case identified in DQ';
comment on column interp_iview_case.dq_reschedule is 'The Subject Requests Reschedule indicator post DQ' ;

comment on column interp_iview_case.officer_dq_sig is 'The Officers signature acknowledgment DQ';
comment on column interp_iview_case.officer_dq_sig_doc_path is 'The relative path to CDN Officers sig file DQ' ;
comment on column interp_iview_case.officer_dq_sig_doc_file_id is 'The Officers sig file ID DQ' ;
comment on column interp_iview_case.officer_dq_entered_name is 'The Officers entered Name DQ attest' ;

comment on column interp_iview_case.superv_dq_sig is 'The Supervisor Officers signature acknowledgment DQ';
comment on column interp_iview_case.superv_dq_sig_doc_path is 'The relative path to CDN Supervisor Officers sig file DQ' ;
comment on column interp_iview_case.superv_dq_sig_doc_file_id is 'The Supervisor Officers sig file ID DQ' ;
comment on column interp_iview_case.superv_dq_entered_name is 'The Supervisor Officers entered Name DQ attest' ;

/* This section of comments reflects fields in Withdrawal of Interpreter Section */
comment on column interp_iview_case.continue_wo_interpreter is 'The indicator subject continues wo interpreter WD' ;
comment on column interp_iview_case.officer_wd_sig is 'The Officers signature acknowledgment subject continue WD' ;
comment on column interp_iview_case.officer_wd_sig_doc_path is 'The relative path to CDN Supervisor Officers WD sig file continue';
comment on column interp_iview_case.officer_wd_sig_doc_file_id is 'The Supervisor Officers WD sig file ID continue';
comment on column interp_iview_case.officer_wd_entered_name is 'The Supervisor Officers entered Name WD attest continue';

comment on column interp_iview_case.subject_wd_sig is 'The Subjects signature acknowledgment subject continue WD';
comment on column interp_iview_case.subject_wd_sig_doc_path is 'The relative path to CDN Subjects WD sig file continue';
comment on column interp_iview_case.subject_wd_sig_doc_file_id is 'The Subjects WD sig file ID continue' ;
comment on column interp_iview_case.subject_wd_entered_name is 'The Subjects entered Name WD attest continue';

/* This section of comments reflects the case timestamp to change tracking  and progress status */
comment on column interp_iview_case.case_status_code is 'Interview Case Process Status Code' ;
comment on column interp_iview_case.case_status_value is 'Interview Case Process Value' ;
comment on column interp_iview_case.case_update_date is 'Interview Case change timestamp' ;


-- Insert Data into Dimension Tables (case_manager, end_user, interpreter, interview_subject, officer)


-- Case_manager
insert into case_manager (cm_acct_name, cm_pw, first_name, last_name, dept_number)
values
	('casemgra', 'password1', 'aaaaa', 'usera', 'a100'),
	('casemgrb', 'password2', 'bbbbb', 'userb', 'b100'),
	('casemgrc', 'password4', 'ccccc', 'userc', 'c100'),
	('casemgrd', 'password5', 'ddddd', 'userd', 'a100'),
	('casemgre', 'password6', 'eeeee', 'usere', 'b100'),
	('casemgrf', 'password7', 'fffff', 'userf', 'c100');

-- End User
insert into end_user (user_acct_name, user_pw, user_first_name, user_last_name, user_address, user_phone,user_email, user_type)
values 
	('endusera', 'password1', 'euafirst', 'eualast', '12 main street', '888-214-8888', 'emahmud+endusera@adgtech.net', 'casemgr'),
	('enduserb', 'password2', 'eubfirst', 'eublast', '23 elm street', '999-999-9898', 'emahmud+enduserb@adgtech.net', 'officer'),
	('enduserc', 'password4', 'eucfirst', 'euclast', '34 oak street', '333-321-1234', 'emahmud+enduserc@adgtech.net', 'casemgr'),
	('enduserd', 'password5', 'eucfirst', 'eudlast', '45 pine street', '456-898-9900', 'emahmud+enduserd@adgtech.net', 'officer'),
	('endusere', 'password6', 'euefirst', 'euelast', '56 birch street', '299-555-6666', 'emahmud+endusere@adgtech.net', 'casemgr'),
	('enduserf', 'password7', 'euffirst', 'euflast', '67 spruce street', '777-391-3911', 'emahmud+enduserf@adgtech.net', 'officer');

-- Interpreter
insert into interpreter (first_name, last_name, interp_address, interp_phone)
values 
	('Interp1First', 'Interp1Last', '99 river terrace', '909-909-9090'),
	('Interp2First', 'Interp2Last', '888 lakes drive', '909-909-9090'),
	('Interp3First', 'Interp3Last', '777 streamview road', '909-909-9090'),
	('Interp4First', 'Interp4Last', '1122 ocean blvd', '909-909-9090'),
	('Interp5First', 'Interp5Last', '2468 creek road', '909-909-9090'),
	('InterpFfirst', 'Interp6Last', '99 marsh street', '909-909-9090');

-- Interview Subject
insert into interview_subject (first_name, last_name, alien_reg_number, native_langs)
values 
	('Subject1First', 'Subject1Last', 'B789672AC', 'Bengali, Hindi'),
	('Subject2First', 'Subject2Last', 'B123493V1', 'Dinka, English'),
	('Subject3First', 'Subject3Last', 'D835276G9', 'Spanish, French, English'),
	('Subject4First', 'Subject4Last', 'N856270HH', 'Czech, Hungarian'),
	('Subject5First', 'Subject6Last', 'K65967522', 'Portuguese, Spanish'),
	('Subject6First', 'Subject6Last', 'C882244Z7', 'Norwegian, Swedish');

-- Officer 
insert into officer (first_name, last_name, is_supervisor, officer_phone, officer_email, officer_field_office)
values 
	('Officer1Frist', 'Officer1Last', 'Y', '222-222-2222', 'officer1@email.com', 'Washington, DC'),
	('Officer2Frist', 'Officer2Last', 'N', '333-222-3333', 'officer2@email.com', 'Washington, DC'),
	('Officer3Frist', 'Officer3Last', 'Y', '555-321-5555', 'officer3@email.com', 'New York, NY'),
	('Officer4Frist', 'Officer4Last', 'N', '424-989-2342', 'officer4@email.com', 'San Diego, CA'),
	('Officer5Frist', 'Officer5Last', 'Y', '702-234-9876', 'officer5@email.com', 'Boston, MA'),
	('Officer6Frist', 'Officer6Last', 'N', '501-646-1122', 'officer6@email.com', 'Miami, FL'),
	('Officer7Frist', 'Officer7Last', 'Y', '501-622-9797', 'officer7@email.com', 'Miami, FL');


-- RE RUN after Cerating the FACT table interp_iview_case
CREATE TABLE InterpreterCase (
    case_id_key INT,
    interpreter_id_key INT,
    PRIMARY KEY (case_id_key , interpreter_id_key),
    CONSTRAINT fk_case FOREIGN KEY (case_id_key) REFERENCES interp_iview_case(case_id ),
    CONSTRAINT fk_interp  FOREIGN KEY (interpreter_id_key) REFERENCES interpreter(interpreter_id)
);

