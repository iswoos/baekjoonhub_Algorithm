select
    dep.DEPT_ID, dep.DEPT_NAME_EN, round(avg(emp.SAL)) as AVG_SAL
from
    HR_DEPARTMENT as dep
join
    HR_EMPLOYEES as emp
on
    dep.DEPT_ID = emp.DEPT_ID
group by
    dep.DEPT_ID, dep.DEPT_NAME_EN
order by
    AVG_SAL desc;