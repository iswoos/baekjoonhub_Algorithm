-- 코드를 입력하세요
select CAR_ID,
# 서브쿼리 활용
# CAR_ID가 해당 시기에 속하면 대여중, 아닐 시에는 대여 가능
case when CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where '2022-10-16' between START_DATE and END_DATE)
then '대여중'
else '대여 가능'
end as 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# CAR_ID 기준으로 그룹화
group by CAR_ID
order by CAR_ID desc