CREATE TABLE public."User"
(
    "Username" character varying(70) NOT NULL,
    "Password" character varying(2000) NOT NULL,
    "First_Name" character varying(40) NOT NULL,
    "Last_Name" character varying(40) NOT NULL,
    "Email" character varying(30),
    "Phone_Number" character varying(10),
    "Type" character,
    PRIMARY KEY ("Username")
);

ALTER TABLE IF EXISTS public."User"
    OWNER to postgres;