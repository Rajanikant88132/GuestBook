DROP TABLE IF EXISTS PLAYER;

CREATE TABLE GUEST (
  guest_Id INT  PRIMARY KEY,
  guest_Name VARCHAR(250) ,
  guest_Age INT,
  Email_Id  VARCHAR(250) ,
  feedback  VARCHAR(2500)  
);

  commit;





CREATE SEQUENCE GUEST_SEQUENCE_ID START WITH (select max( guest_Id) + 1 from GUEST);

  commit;
