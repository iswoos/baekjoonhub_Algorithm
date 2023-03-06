-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME,FAVORITES
from REST_INFO
# 음식종류별 즐겨찾기가 가장 많은 식당을 추출 후 음식 종류별로 그룹화하게끔 서브쿼리를 작성
where (FOOD_TYPE, FAVORITES) in
    (select FOOD_TYPE, max(FAVORITES)
    from REST_INFO
     group by FOOD_TYPE
    )
order by FOOD_TYPE desc