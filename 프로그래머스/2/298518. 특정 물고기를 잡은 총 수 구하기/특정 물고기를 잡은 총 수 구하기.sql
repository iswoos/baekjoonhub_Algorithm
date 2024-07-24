select 
    count(*) as FISH_COUNT
from
    FISH_INFO as fish
join
    FISH_NAME_INFO as fish_name
on
    fish.FISH_TYPE = fish_name.FISH_TYPE
where
    fish_name.FISH_NAME = 'BASS' or fish_name.FISH_NAME = 'SNAPPER'