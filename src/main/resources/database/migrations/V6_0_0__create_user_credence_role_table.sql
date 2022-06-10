------------------------------------------------
-- Table: public.user_credence_role
------------------------------------------------

CREATE TABLE IF NOT EXISTS public.user_credence_role
(
    credence_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT fklvc9p2sn0geeidshy6v34x407 FOREIGN KEY (role_id)
    REFERENCES public.role (role_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fksi8qvleefgiaddacc4d1dmce FOREIGN KEY (credence_id)
    REFERENCES public.user_credence (credence_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_credence_role
    OWNER to postgres;

