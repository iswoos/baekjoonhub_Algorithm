select 
    count(*) as FISH_COUNT, name.FISH_NAME
from
    FISH_INFO as info
join
    FISH_NAME_INFO as name
on 
    info.FISH_TYPE = name.FISH_TYPE
group by
    FISH_NAME
order by
    FISH_COUNT desc;