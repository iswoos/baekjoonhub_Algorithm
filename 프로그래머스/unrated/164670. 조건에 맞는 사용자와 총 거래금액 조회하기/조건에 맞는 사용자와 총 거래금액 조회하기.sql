-- 코드를 입력하세요
# concat을 활용하여 String값을 서로 이어줄 수 있음
# left, mid 함수를 이용하여 원하는 자리값만 추출
SELECT U.USER_ID as USER_ID, U.NICKNAME as NICKNAME, 
concat(U.CITY,' ', U.STREET_ADDRESS1, ' ',U.STREET_ADDRESS2) as 전체주소, 
concat (left(TLNO,3),'-',mid(TLNO,4,4),'-',mid(TLNO,8,4))as 전화번호
from USED_GOODS_BOARD B join USED_GOODS_USER U on B.WRITER_ID = U.USER_ID
group by WRITER_ID
having count(WRITER_ID) >= 3
order by U.USER_ID desc