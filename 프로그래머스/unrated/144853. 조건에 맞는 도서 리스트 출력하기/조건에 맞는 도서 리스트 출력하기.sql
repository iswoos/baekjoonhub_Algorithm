-- 코드를 입력하세요
SELECT BOOK_ID, 
# 데이트 포맷이 예시와 동일해야하니,
# DATE_FORMAT() 함수를 이용하여 날짜를 지정한 형식으로 출력한다
DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK
where CATEGORY = '인문'

# 아래와 같이 year함수를 이용하여 년도 값을 빼와 조건값에 대조하거나,
and year(PUBLISHED_DATE) = 2021

# 해당 내용으로 대체해도된다.
# and PUBLISHED_DATE >= '2021-01-01'
# and PUBLISHED_DATE < '2022-01-01'

order by PUBLISHED_DATE