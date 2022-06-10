------------------------------------------------
-- Table: public.medical_cards
------------------------------------------------

CREATE TABLE IF NOT EXISTS public.medical_cards
(
    card_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    patient_id integer,
    CONSTRAINT medical_cards_pkey PRIMARY KEY (card_id),
    CONSTRAINT fkosr1bi7wjcyqt867r454o5bju FOREIGN KEY (patient_id)
    REFERENCES public.patient (patient_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.medical_cards
    OWNER to postgres;

INSERT INTO public.medical_cards (patient_id)
    VALUES (1);

INSERT INTO public.medical_cards (patient_id)
    VALUES (2);

INSERT INTO public.medical_cards (patient_id)
    VALUES (3);
