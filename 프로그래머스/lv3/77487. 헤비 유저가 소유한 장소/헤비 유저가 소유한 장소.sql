-- 코드를 입력하세요
SELECT ID, NAME, HOST_ID
from PLACES
# 1. where절 서브쿼리를 이용
# HOST_ID 값들을 가져올 것이나, 그 조건은 HOST_ID를 그룹화한 뒤 HOST_ID별 개수가 2이상인 HOST_ID 데이터들을 모두 가지고 올 것임
where (HOST_ID) in(
    select HOST_ID 
    from PLACES
    group by HOST_ID
    having count(HOST_ID) >= 2
)
order by ID