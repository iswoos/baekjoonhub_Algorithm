-- 코드를 입력하세요
SELECT CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK B join BOOK_SALES S on B.BOOK_ID = S.BOOK_ID
where SALES_DATE between '2022-01-01' and '2022-01-31'
group by CATEGORY
order by CATEGORY
