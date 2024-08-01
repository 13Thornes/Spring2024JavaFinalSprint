CREATE TABLE public."Products"
(
    "Product_ID" serial NOT NULL,
    "Product_Name" character varying NOT NULL,
    "Price" numeric(1000) NOT NULL,
    "QTY" integer NOT NULL,
    "Description" character varying(30000),
    "Seller_ID" integer NOT NULL,
    PRIMARY KEY ("Product_ID"),
    CONSTRAINT "Seller_ID" FOREIGN KEY ("Seller_ID")
        REFERENCES public."Seller" ("Seller_ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."Products"
    OWNER to postgres;