-- 코드를 입력하세요
#SQL엔진은 GROUP BY 구문이 실행되기 전에 SELECT 구문에서 사용할 컬럼들을 먼저 해석하고 처리함

# 2. 각 요구사항에 맞게 컬럼 생성
SELECT year(SALES_DATE) as YEAR, 
month(SALES_DATE) as MONTH,
U.GENDER as GENDER,
count(distinct U.USER_ID) as USERS
# 1. 테이블 조인 진행
from USER_INFO U join ONLINE_SALE O on U.USER_ID = O.USER_ID
# 3. select에서 명명한 컬럼을 기준으로 그룹화
group by YEAR, MONTH, GENDER
# 4. GENDER가 비었을 시에는 가져오지 않음
having GENDER is not null
order by YEAR, MONTH, GENDER
