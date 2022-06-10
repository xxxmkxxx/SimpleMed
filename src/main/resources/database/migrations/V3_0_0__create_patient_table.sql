------------------------------------------------
-- Table: public.patient
------------------------------------------------

CREATE TABLE IF NOT EXISTS public.patient
(
    patient_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    date_of_birth timestamp without time zone,
    height double precision,
    weight double precision,
    user_user_id integer,
    CONSTRAINT patient_pkey PRIMARY KEY (patient_id),
    CONSTRAINT fkhu4n6cvom1ojacxmecd58u5e5 FOREIGN KEY (user_user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
                            ON UPDATE NO ACTION
                            ON DELETE NO ACTION
    )
                            WITH (
                                OIDS = FALSE
                                )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.patient
    OWNER to postgres;

INSERT INTO public.patient (date_of_birth, height, weight, user_user_id)
    VALUES ('1985-01-10 05:15:11', 158, 82, 2);

INSERT INTO public.patient (date_of_birth, height, weight, user_user_id)
    VALUES ('1990-02-10 05:15:11', 178, 90, 4);

INSERT INTO public.patient (date_of_birth, height, weight, user_user_id)
    VALUES ('1976-08-15 05:15:11', 165, 120, 6);