select 
    YEAR(YM) as YEAR , ROUND(AVG(PM_VAL1),2) AS PM10, ROUND(AVG(PM_VAL2),2) as "PM2.5"
from
    AIR_POLLUTION
where
    LOCATION2 = '수원'
group by YEAR
order by YEAR asc;