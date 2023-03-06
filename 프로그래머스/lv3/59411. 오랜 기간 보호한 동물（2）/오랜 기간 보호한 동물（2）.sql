-- 코드를 입력하세요
SELECT O.ANIMAL_ID, O.NAME
from ANIMAL_INS I join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
# datediff 함수 이용하여 종료일, 시작일간 일수계산하여 내림차순으로 정렬 후 2개만 추출
order by datediff(O.DATETIME,I.DATETIME)+1 desc
limit 2