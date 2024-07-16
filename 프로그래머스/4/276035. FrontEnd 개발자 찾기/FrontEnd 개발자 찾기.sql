SELECT 
    ID, EMAIL, FIRST_NAME, LAST_NAME
FROM 
    DEVELOPERS
WHERE 
    SKILL_CODE&(
        select 
            sum(CODE) 
        from 
            SKILLCODES where CATEGORY = 'Front End')>0
order by 
    ID;
