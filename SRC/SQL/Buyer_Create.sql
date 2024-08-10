CREATE TABLE public."Buyer"
(
    "Buyer_ID" serial NOT NULL,
    "Username" character varying(80) NOT NULL,
    "St_Add" character varying(40) NOT NULL,
    "City" character varying(20) NOT NULL,
    "Prov" character varying(2) NOT NULL,
    "Postal_Code" character varying(6) NOT NULL,

);

ALTER TABLE IF EXISTS public."Buyer"
    OWNER to postgres;