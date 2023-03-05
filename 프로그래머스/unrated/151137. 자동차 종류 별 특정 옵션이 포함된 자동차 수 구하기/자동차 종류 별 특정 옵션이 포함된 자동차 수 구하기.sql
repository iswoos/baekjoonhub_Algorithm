-- 코드를 입력하세요
SELECT CAR_TYPE, count(CAR_ID) as CARS
from CAR_RENTAL_COMPANY_CAR 
where OPTIONS like '%시트%'
# 시트만 필터링된 목록에서 CAR_TYPE으로 그룹화하여 CAR_TYPE과 각 데이터 개수를 컬럼에 추가
group by CAR_TYPE
# 정렬 방식은 CAR_TYPE 오름차순으로 진행
order by CAR_TYPE
