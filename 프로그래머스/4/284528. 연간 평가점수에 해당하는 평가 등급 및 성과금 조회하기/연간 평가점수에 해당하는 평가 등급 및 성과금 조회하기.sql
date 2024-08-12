select
    emp.EMP_NO, emp.EMP_NAME,
    CASE
        WHEN AVG(grade.SCORE) >= 96 THEN 'S'
        WHEN AVG(grade.SCORE) >= 90 THEN 'A'
        WHEN AVG(grade.SCORE) >= 80 THEN 'B'
        ELSE 'C'
        END AS GRADE,
    CASE
        WHEN AVG(grade.SCORE) >= 96 THEN emp.SAL * 0.2
        WHEN AVG(grade.SCORE) >= 90 THEN emp.SAL * 0.15
        WHEN AVG(grade.SCORE) >= 80 THEN emp.SAL * 0.1
        ELSE 0
        END AS BONUS
from
    HR_DEPARTMENT as depar
join
    HR_EMPLOYEES as emp
on
    depar.DEPT_ID = emp.DEPT_ID
join
    HR_GRADE as grade
on
    emp.EMP_NO = grade.EMP_NO
group by
    emp.EMP_NO
order by
    emp.EMP_NO ASC;