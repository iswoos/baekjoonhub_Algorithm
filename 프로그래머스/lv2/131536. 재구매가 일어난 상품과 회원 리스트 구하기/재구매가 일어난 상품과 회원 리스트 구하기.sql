-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
from ONLINE_SALE 
group by USER_ID, PRODUCT_ID
# group by로 묶은 것에 추가조건을 having 절로 건다
having count(*) >=2
order by USER_ID, PRODUCT_ID desc