-- 코드를 입력하세요
SELECT H.FLAVOR
from FIRST_HALF H join JULY J on H.FLAVOR = J.FLAVOR
group by J.FLAVOR
order by sum(H.TOTAL_ORDER) + sum(J.TOTAL_ORDER) desc
limit 3