select 
    YEAR(ED.DIFFERENTIATION_DATE) as YEAR, sub.max_size-ED.SIZE_OF_COLONY as YEAR_DEV, ED.ID
from 
    ECOLI_DATA as ED
join
    (
    select
        MAX(ED.SIZE_OF_COLONY) as max_size, YEAR(ED.DIFFERENTIATION_DATE) as year
    from
        ECOLI_DATA as ED
    group by
        YEAR(ED.DIFFERENTIATION_DATE)
    ) as sub
on
    YEAR(ED.DIFFERENTIATION_DATE) = sub.year
order by
    YEAR asc, YEAR_DEV asc;
    