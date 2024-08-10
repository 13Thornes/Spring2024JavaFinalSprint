CREATE TABLE public."Seller"
(
    "Seller_ID" serial NOT NULL,
    "Username" character varying(80) NOT NULL,
    "Company_Name" character varying(40),
    "St_Add" character varying(40) NOT NULL,
    "City" character varying(20) NOT NULL,
    "Prov" character varying(2) NOT NULL,
    "Postal_Code" character varying(6) NOT NULL,
    PRIMARY KEY ("Seller_ID"),
    
);

ALTER TABLE IF EXISTS public."Seller"
    OWNER to postgres;