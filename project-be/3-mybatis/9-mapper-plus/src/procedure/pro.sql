delimiter &&

CREATE DEFINER=`root`@`localhost` PROCEDURE `count_role`(
    in p_role_name varchar(255),
    out count_total int(8),
    out exec_date date )
BEGIN
    SELECT COUNT(*) INTO count_total FROM t_role WHERE role_name LIKE concat("%", p_role_name, "%");
    SELECT now() INTO exec_date;
END &&

delimiter ;