-- 코드를 입력하세요
SELECT count(USER_ID) as USERS
from USER_INFO
# IS NULL > 항목의 값이 NULL인지 체크 (NULL인 모든 항목반환) 반대는 IS NOT NULL
where AGE is NULL