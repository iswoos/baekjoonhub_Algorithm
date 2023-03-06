-- 코드를 입력하세요
# 2. 가지고온 것들 기준으로 NAME이 중복되지 않은 것들만 count진행
SELECT count(distinct(NAME)) as count
from ANIMAL_INS 
# 1. NAME이 not null인 것들만 추출
where NAME is not null