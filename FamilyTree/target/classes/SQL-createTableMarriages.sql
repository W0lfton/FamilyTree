CREATE TABLE MARRIAGES (
    MARRIAGE_ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    M_FROM      DATE NOT NULL,
    M_TO        DATE,
    SPOUSE1_ID  INTEGER NOT NULL REFERENCES PEOPLE (ID) ON DELETE CASCADE,
    SPOUSE2_ID  INTEGER NOT NULL REFERENCES PEOPLE (ID) ON DELETE CASCADE
)