WITH GRADE AS (
SELECT EMP_NO, SUM(SCORE) SCORE
FROM HR_GRADE
WHERE YEAR = 2022
GROUP BY EMP_NO
)

SELECT SCORE, B.EMP_NO, EMP_NAME, POSITION, EMAIL
FROM
(SELECT G.SCORE, EMP_NO
FROM GRADE JOIN
(
SELECT MAX(SCORE) SCORE
FROM GRADE) G
ON GRADE.SCORE = G.SCORE) B JOIN HR_EMPLOYEES HE
ON B.EMP_NO = HE.EMP_NO