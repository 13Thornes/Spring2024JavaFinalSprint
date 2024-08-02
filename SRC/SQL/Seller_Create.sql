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
    CONSTRAINT "Username" FOREIGN KEY ("Username")
        REFERENCES public."User" ("Username") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Seller"
    OWNER to postgres;