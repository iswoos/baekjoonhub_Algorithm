select 
    info.ID,
    name.FISH_NAME, 
    info.LENGTH 
from 
    FISH_INFO as info
join
    FISH_NAME_INFO as name
on
    info.FISH_TYPE = name.FISH_TYPE
where
    (info.FISH_TYPE, info.LENGTH) in (
        select
            FISH_TYPE, max(LENGTH)
        from
            FISH_INFO
        group by
            FISH_TYPE
    )
order by 
    info.ID asc;