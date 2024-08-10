CREATE TABLE public."Admin"
(
    "Admin_ID" serial NOT NULL,
    "Username" character varying(80) NOT NULL,
    "Postion" character varying(30) NOT NULL,
    PRIMARY KEY ("Admin_ID"),
    
);

ALTER TABLE IF EXISTS public."Admin"
    OWNER to postgres;
