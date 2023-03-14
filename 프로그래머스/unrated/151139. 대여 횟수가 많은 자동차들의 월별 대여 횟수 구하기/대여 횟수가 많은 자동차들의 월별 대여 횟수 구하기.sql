select month(START_DATE) as MONTH, CAR_ID, count(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID in (select CAR_ID
                 from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                 where month(START_DATE) >= 8 and month(START_DATE) <=10
                 group by CAR_ID
                 having count(*) >=5
                ) and month(START_DATE) >= 8 and month(START_DATE) <=10
group by month(START_DATE), CAR_ID
order by MONTH, CAR_ID desc