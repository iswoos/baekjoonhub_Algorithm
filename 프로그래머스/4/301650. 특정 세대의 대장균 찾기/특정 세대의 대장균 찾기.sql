select 
    ed.id as ID
from(
    select 
        ID as id, PARENT_ID as pi
    from
        ECOLI_DATA as ED
    where 
        PARENT_ID is null
    ) as sub1
join
    (
    select 
        ID as id, PARENT_ID as pi
    from
        ECOLI_DATA as ED
    where 
        PARENT_ID is not null
    ) as sub2
on
    sub1.id = sub2.pi
left join
    ECOLI_DATA as ed
on
    sub2.id = ed.PARENT_ID
where
    ed.PARENT_ID is not null
order by 
    ed.id asc;
    