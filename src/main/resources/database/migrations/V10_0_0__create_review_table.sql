------------------------------------------------
-- Table: public.review
------------------------------------------------

CREATE TABLE IF NOT EXISTS public.review
(
    review_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    date_sending timestamp without time zone,
    text_review character varying(255) COLLATE pg_catalog."default",
    recipient_id integer,
    sender_id integer,
    CONSTRAINT review_pkey PRIMARY KEY (review_id),
    CONSTRAINT fkena0dlq0f0ikm41r4jf58x0qr FOREIGN KEY (recipient_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION,
    CONSTRAINT fknbk5kxhflo9qwtofunfqgg4ju FOREIGN KEY (sender_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
                           ON UPDATE NO ACTION
                           ON DELETE NO ACTION
    )
                           WITH (
                               OIDS = FALSE
                               )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.review
    OWNER to postgres;
