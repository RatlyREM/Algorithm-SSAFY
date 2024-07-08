WITH MAX_ECOLI AS (
    SELECT YDD, MAX(SIZE_OF_COLONY) MAXSIZE
    FROM
    (SELECT ID, SIZE_OF_COLONY, YEAR(DIFFERENTIATION_DATE) YDD
    FROM ECOLI_DATA) B
    GROUP BY YDD     
)

SELECT YEAR(DIFFERENTIATION_DATE) YEAR, (MAXSIZE- SIZE_OF_COLONY) YEAR_DEV, ID
FROM ECOLI_DATA, MAX_ECOLI
WHERE YEAR(DIFFERENTIATION_DATE) = YDD
ORDER BY YEAR, YEAR_DEV