-- 코드를 입력하세요
# if문 + like + or 활용하여 중성화 여부 확인진행
SELECT ANIMAL_ID, NAME, if(SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like '%Spayed%', 'O', 'X') as 중성화
from ANIMAL_INS 
order by ANIMAL_ID