-- 코드를 입력하세요
SELECT 
PT_NAME,
PT_NO,
GEND_CD,
AGE,
# 만약 TLNO의 값이 null이면 'NONE'으로 출력
ifnull(TLNO, 'NONE') as TLNO
from PATIENT 
where AGE <= 12 and GEND_CD = 'W'
# order by 조건 여러개일 경우 아래와 같이 기재
order by AGE desc, PT_NAME