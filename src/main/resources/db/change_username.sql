CREATE OR REPLACE PROCEDURE public.change_username(IN username_from character varying, IN username_to character varying)
    LANGUAGE 'plpgsql'

AS $BODY$
declare
 username_changed character varying := username_from;
 username_1 record;


begin
 update users set username_name = username_to
  where username = username_from;

 commit;
end;
$BODY$;