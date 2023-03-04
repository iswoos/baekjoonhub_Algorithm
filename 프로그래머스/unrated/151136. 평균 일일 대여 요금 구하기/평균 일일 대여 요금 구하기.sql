-- 코드를 입력하세요
# 3. 필터링된 데이터에서 평균구하는 avg() 함수와 반올림을 하는 round() 함수 이용하여 조회 실행
SELECT round(avg(DAILY_FEE),0) as AVERAGE_FEE 
# 1. 대상 테이블 가져옴
from CAR_RENTAL_COMPANY_CAR 
# 2. 타입이 suv인 것들만 필터링
where CAR_TYPE = 'SUV'