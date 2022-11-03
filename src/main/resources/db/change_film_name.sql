CREATE OR REPLACE PROCEDURE public.change_film_name(IN film_name_from character varying, IN film_name_to character varying)
    LANGUAGE 'plpgsql'

AS $BODY$
declare
 film_name_changed character varying := film_name_from;
 film_name_1 record;

begin
 update film set film_name = film_name_to
  where film_name = film_name_from;

 commit;
end;
$BODY$;