select month(START_DATE) as MONTH, CAR_ID, count(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID in (select CAR_ID
                 from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                 where month(START_DATE) >= 8 and month(START_DATE) <=10
                 group by CAR_ID
                 having count(*) >=5
                ) 
# where 조건문을 1개 더 쓴 이유
# 메인 쿼리에 8월~10월에 대한 where조건문이 없다면
# count(CAR_ID)의 집계값에 다른 월에 해당하는 케이스도 같이 잡히기 때문이다!!!
# 이거 때문에 한참 헤맸다...
        and month(START_DATE) >= 8 and month(START_DATE) <=10
group by month(START_DATE), CAR_ID
order by MONTH, CAR_ID desc