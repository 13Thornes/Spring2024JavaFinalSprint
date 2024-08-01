CREATE TABLE public."Buyer"
(
    "Buyer_ID" serial NOT NULL,
    "Username" character varying(80) NOT NULL,
    "St_Add" character varying(40) NOT NULL,
    "City" character varying(20) NOT NULL,
    "Prov" character varying(2) NOT NULL,
    "Postal_Code" character varying(6) NOT NULL,
    PRIMARY KEY ("Buyer_ID", "Username"),
    CONSTRAINT "Username" FOREIGN KEY ("Username")
        REFERENCES public."User" ("Username") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Buyer"
    OWNER to postgres;