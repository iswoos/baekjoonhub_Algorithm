-- 코드를 입력하세요
# 3. 그룹화한 데이터에서 원하는 방식으로 추출
SELECT hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
# 1. hour함수로 시간 추출한 뒤 9부터 19까지만 조건탐색
where hour(DATETIME) between 9 and 19
# 2. DATETIME 별로 그룹화
group by hour(DATETIME)
# 4. 시간순 정렬
order by hour(DATETIME)
