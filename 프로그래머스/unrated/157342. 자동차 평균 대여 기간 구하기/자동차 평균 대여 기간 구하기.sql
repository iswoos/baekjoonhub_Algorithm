-- 코드를 입력하세요
# 3. 추출된 값에서 원하는 형식으로 변환한 뒤 값 도출
select CAR_ID, round(avg(datediff(END_DATE,START_DATE)+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# 1. CAR_ID로 그룹화
group by CAR_ID
# 2. CAR_ID별, datediff(종료일,시작일)+1 을 이용하여 날짜간의 차이평균이 7일을 넘어가는 것만 추출
having avg(datediff(END_DATE,START_DATE)+1) >= 7
order by AVERAGE_DURATION desc, CAR_ID desc