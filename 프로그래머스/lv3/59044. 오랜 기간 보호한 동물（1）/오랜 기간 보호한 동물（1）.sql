-- 코드를 입력하세요
# 3. 보호동물 이름, 보호 시작일 추출
SELECT I.NAME, I.DATETIME
# 1. left join을 이용하여 INS 테이블 기준으로 합집합 테이블을 구함 (OUTS에 매칭되는 데이터 없을 경우 null값이 배정되어 조회됨)
from ANIMAL_INS I left join ANIMAL_OUTS O on I.ANIMAL_ID = O.ANIMAL_ID
# 2. 입양일이 빈 것들만 추출
where O.ANIMAL_ID is null
# 4. 보호 시작일 기준으로 정렬
order by I.DATETIME
# 5. 최대 3개만 출력
limit 3